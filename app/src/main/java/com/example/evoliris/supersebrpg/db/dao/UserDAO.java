package com.example.evoliris.supersebrpg.db.dao;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;

        import com.example.evoliris.supersebrpg.metier.Personnage;

        import java.util.ArrayList;
        import java.util.List;



public class UserDAO extends BaseDAO<UserDAO, Personnage> {
    public static final String TABLE = "personnage";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "personnage_name";
    public static final String COL_POINT_VIE = "personnage_point_vie";
    public static final String COL_ATTAQUE = "personnage_attaque";
    public static final String COL_PHOTO = "personnage_photo";

    public static final String CREATE = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50) NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s VARCHAR(50));", TABLE, COL_ID, COL_NAME, COL_POINT_VIE, COL_ATTAQUE, COL_PHOTO);
    public static final String UPDATE = String.format("DROP TABLE %s;", TABLE);
    public static final String DROP = String.format("DROP TABLE %s;", TABLE);

    public UserDAO(Context context) {
        super(context);
    }

    @Override
    public Personnage findById(long id) {
        Cursor cursor = db.query(TABLE, null, COL_ID+ " = "+ id, null, null, null, null);

        if(cursor.getCount() <= 0)return null;
        cursor.moveToFirst();

        return from(cursor);
    }
    public List<Personnage> findAll(){
        Cursor cursor = findCursorAll();

        if(cursor.getCount() <= 0)return null;
        cursor.moveToFirst();
        ArrayList<Personnage> users = new ArrayList<Personnage>();

        do{
            users.add(from(cursor));
        }while (cursor.moveToNext());

        return users;
    }
    public Cursor findCursorAll(){
        return db.rawQuery(String.format("SELECT * FROM %s", TABLE), null);
    }

    @Override
    public Personnage from(Cursor cursor) {
        int idColonneIndex = cursor.getColumnIndex(COL_ID);
        int nameColonneIndex = cursor.getColumnIndex(COL_NAME);
        int pvColonneIndex = cursor.getColumnIndex(COL_POINT_VIE);
        int attaquedColonneIndex = cursor.getColumnIndex(COL_ATTAQUE);
        int photoColonneIndex = cursor.getColumnIndex(COL_PHOTO);

        int idValue = cursor.getInt(idColonneIndex);
        String nameValue = cursor.getString(nameColonneIndex);
        int pvValue = cursor.getInt(pvColonneIndex);
        int attaqueValue = cursor.getInt(attaquedColonneIndex);
        String photoValue = cursor.getString(photoColonneIndex);

        return new Personnage(idValue, nameValue, pvValue, attaqueValue, photoValue);
    }

    @Override
    public long insert(Personnage user) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, user.getNom());
        values.put(COL_POINT_VIE, user.getPointVie());
        values.put(COL_ATTAQUE, user.getAttaque());
        values.put(COL_PHOTO, user.getPhoto());

        long idInserted = db.insert(TABLE, null, values);
        user.setId((int)idInserted); //todo long / int
        return idInserted;
    }

    @Override
    public void update(Personnage user) {
        ContentValues values = new ContentValues();

        values.put(COL_NAME, user.getNom());
        values.put(COL_POINT_VIE, user.getPointVie());
        values.put(COL_ATTAQUE, user.getAttaque());
        values.put(COL_PHOTO, user.getPhoto());

        db.update(TABLE, values, COL_ID+ " = "+ user.getId(), null);

    }
}

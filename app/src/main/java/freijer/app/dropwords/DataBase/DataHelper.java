package freijer.app.dropwords.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "saveStats";
    private static final String TABLE_NAME = "stats";

    private static final String KEY_ID = "_id";
    private static final String KEY_SCORE = "scores";
    private static final String KEY_LVL = "lvl";
    private static final String KEY_TRYS = "tryChange";

    SQLiteDatabase database;
    ContentValues contentValues = new ContentValues();

    private String valueScore;
    private String valueLvl;
    private String valueTrys;

    public String getValueScore() {
        return valueScore;
    }
    private void setValueScore(String valueScore) {
        this.valueScore = valueScore;
    }
    public String getValueLvl() {
        return valueLvl;
    }
    private void setValueLvl(String valueLvl) {
        this.valueLvl = valueLvl;
    }
    public String getValueTrys() {
        return valueTrys;
    }
    private void setValueTrys(String valueTrys) {
        this.valueTrys = valueTrys;
    }


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key," + KEY_SCORE + " text," +  KEY_LVL+ " text," +  KEY_TRYS + " text" +  ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void WriteDB(String score, String lvl, String tryss){
        database = this.getWritableDatabase();
        contentValues.put(KEY_SCORE, score);
        contentValues.put(KEY_LVL, lvl);
        contentValues.put(KEY_TRYS, tryss);

        database.insert(TABLE_NAME, null, contentValues);

    }


    public void ReadDB(){
        database = this.getWritableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int scoreIndex = cursor.getColumnIndex(KEY_SCORE);
            int lvlIndex = cursor.getColumnIndex(KEY_LVL);
            int tryslIndex = cursor.getColumnIndex(KEY_TRYS);
            do {
                Log.d("myLogs", "ID = " + cursor.getInt(idIndex) +
                        ", очки = " + cursor.getString(scoreIndex) +
                        ", уровень = " + cursor.getString(lvlIndex) +
                        ", попыток = " + cursor.getString(tryslIndex) );
                setValueScore(cursor.getString(cursor.getColumnIndex(KEY_SCORE)));
                setValueLvl(cursor.getString(cursor.getColumnIndex(KEY_LVL)));
                setValueTrys(cursor.getString(cursor.getColumnIndex(KEY_TRYS)));

            } while (cursor.moveToNext());
        } else
            Log.d("myLogs","0 rows");
        cursor.close();
    }

    public void DeleteDB(){
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }

    public void UpdateDB(String score, String lvl, String tryss){
        database = this.getWritableDatabase();
        contentValues.put(KEY_SCORE, score);
        contentValues.put(KEY_LVL, lvl);
        contentValues.put(KEY_TRYS, tryss);

        String id = "1";
        int updCount  = database.update(TABLE_NAME, contentValues, KEY_ID + "= ?" , new String[] {id});
        Log.d("myLogs", "updated rows count = " + updCount);
    }

}
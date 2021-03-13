package freijer.app.dropwords.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 7;

    private static final String DATABASE_NAME = "saveStats";
    private static final String TABLE_NAME = "stats";
        private static final String DATABASE_NAME_lenght = "lenght_words";
        private static final String TABLE_NAME_lenght = "stats_lenght";

    private static final String KEY_ID = "_id";
    private static final String KEY_SCORE = "scores";
    private static final String KEY_LVL = "lvl";
    private static final String KEY_TRYS = "tryChange";
        private static final String KEY_ID_lenght = "_id";
        private static final String KEY_LENGHT_3 = "lenght_3";
        private static final String KEY_LENGHT_4 = "lenght_4";
        private static final String KEY_LENGHT_5 = "lenght_5";
        private static final String KEY_LENGHT_6 = "lenght_6";
        private static final String KEY_LENGHT_7 = "lenght_7";
        private static final String KEY_LENGHT_8 = "lenght_8";
        private static final String KEY_LENGHT_9 = "lenght_9";
        private static final String KEY_LENGHT_10 = "lenght_10";
        private static final String KEY_LENGHT_11 = "lenght_11";
        private static final String KEY_LENGHT_12 = "lenght_12";
        private static final String KEY_LENGHT_13 = "lenght_13";
        private static final String KEY_LENGHT_14 = "lenght_14";
            private static final String KEY_LENGHT_PLUS = "lenght_plus";
            private static final String KEY_LENGHT_MINUS = "lenght_minus";


    SQLiteDatabase database;

    Cursor cursor;
    ContentValues contentValues = new ContentValues();
        ContentValues contentValues_lenght = new ContentValues();

    private int valueScore;
    private int valueLvl;
    private int valueTrys;


        private int LENGHT_3;
        private int LENGHT_4;
        private int LENGHT_5;
        private int LENGHT_6;
        private int LENGHT_7;
        private int LENGHT_8;
        private int LENGHT_9;
        private int LENGHT_10;
        private int LENGHT_11;
        private int LENGHT_12;
        private int LENGHT_13;
        private int LENGHT_14;
            private int LENGHT_PLUS;
            private int LENGHT_MINUS;


    public int getLENGHT_3() {
        return LENGHT_3;
    }
    public void setLENGHT_3(int LENGHT_3) {
        this.LENGHT_3 = LENGHT_3;
    }
    public int getLENGHT_4() {
        return LENGHT_4;
    }
    public void setLENGHT_4(int LENGHT_4) {
        this.LENGHT_4 = LENGHT_4;
    }
    public int getLENGHT_5() {
        return LENGHT_5;
    }
    public void setLENGHT_5(int LENGHT_5) {
        this.LENGHT_5 = LENGHT_5;
    }
    public int getLENGHT_6() {
        return LENGHT_6;
    }
    public void setLENGHT_6(int LENGHT_6) {
        this.LENGHT_6 = LENGHT_6;
    }
    public int getLENGHT_7() {
        return LENGHT_7;
    }
    public void setLENGHT_7(int LENGHT_7) {
        this.LENGHT_7 = LENGHT_7;
    }
    public int getLENGHT_8() {
        return LENGHT_8;
    }
    public void setLENGHT_8(int LENGHT_8) {
        this.LENGHT_8 = LENGHT_8;
    }
    public int getLENGHT_9() {
        return LENGHT_9;
    }
    public void setLENGHT_9(int LENGHT_9) {
        this.LENGHT_9 = LENGHT_9;
    }
    public int getLENGHT_10() {
        return LENGHT_10;
    }
    public void setLENGHT_10(int LENGHT_10) {
        this.LENGHT_10 = LENGHT_10;
    }
    public int getLENGHT_11() {
        return LENGHT_11;
    }
    public void setLENGHT_11(int LENGHT_11) {
        this.LENGHT_11 = LENGHT_11;
    }
    public int getLENGHT_12() {
        return LENGHT_12;
    }
    public void setLENGHT_12(int LENGHT_12) {
        this.LENGHT_12 = LENGHT_12;
    }
    public int getLENGHT_13() {
        return LENGHT_13;
    }
    public void setLENGHT_13(int LENGHT_13) {
        this.LENGHT_13 = LENGHT_13;
    }
    public int getLENGHT_14() {
        return LENGHT_14;
    }
    public void setLENGHT_14(int LENGHT_14) {
        this.LENGHT_14 = LENGHT_14;
    }
        public int getLENGHT_PLUS() {
            return LENGHT_PLUS;
        }
        public void setLENGHT_PLUS(int LENGHT_PLUS) {
            this.LENGHT_PLUS = LENGHT_PLUS;
        }
        public int getLENGHT_MINUS() {
            return LENGHT_MINUS;
        }
        public void setLENGHT_MINUS(int LENGHT_MINUS) {
            this.LENGHT_MINUS = LENGHT_MINUS;
        }


            public int getValueScore() {
                return valueScore;
            }
            private void setValueScore(int valueScore) {
                this.valueScore = valueScore;
            }
            public int getValueLvl() {
                return valueLvl;
            }
            private void setValueLvl(int valueLvl) {
                this.valueLvl = valueLvl;
            }
            public int getValueTrys() {
                return valueTrys;
            }
            private void setValueTrys(int valueTrys) {
                this.valueTrys = valueTrys;
            }


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_lenght + "(" + KEY_ID_lenght
                + " integer primary key," + KEY_LENGHT_3 + " text," + KEY_LENGHT_4 + " text," +  KEY_LENGHT_5 + " text,"
                + KEY_LENGHT_6 + " text," + KEY_LENGHT_7 + " text," + KEY_LENGHT_8 + " text," + KEY_LENGHT_9 + " text,"
                + KEY_LENGHT_10 + " text," + KEY_LENGHT_11 + " text," + KEY_LENGHT_12 + " text," + KEY_LENGHT_13 + " text,"
                + KEY_LENGHT_14 + " text," + KEY_LENGHT_PLUS + " text," +  KEY_LENGHT_MINUS + " text" +");");

        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key," + KEY_SCORE + " text," + KEY_LVL + " text," + KEY_TRYS + " text" +");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_lenght);
        onCreate(db);
    }

    public void WriteDB(String score, String lvl, String tryss) {
        database = this.getWritableDatabase();
        contentValues.put(KEY_SCORE, score);
        contentValues.put(KEY_LVL, lvl);
        contentValues.put(KEY_TRYS, tryss);

        database.insert(TABLE_NAME, null, contentValues);
    }
    public void ReadDB() {
        database = this.getWritableDatabase();
       cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int scoreIndex = cursor.getColumnIndex(KEY_SCORE);
            int lvlIndex = cursor.getColumnIndex(KEY_LVL);
            int tryslIndex = cursor.getColumnIndex(KEY_TRYS);
            do {
                Log.d("myLogs", "ID = " + cursor.getInt(idIndex) +
                        ", очки = " + cursor.getString(scoreIndex) +
                        ", уровень = " + cursor.getString(lvlIndex) +
                        ", попыток = " + cursor.getString(tryslIndex));
                setValueScore(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_SCORE))));
                setValueLvl(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LVL))));
                setValueTrys(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_TRYS))));

            } while (cursor.moveToNext());
        } else
            Log.d("myLogs", "0 rows");
        cursor.close();
    }
    public void DeleteDB() {
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }
    public void UpdateDB(String score, String lvl, String tryss) {
        database = this.getWritableDatabase();
        contentValues.put(KEY_SCORE, score);
        contentValues.put(KEY_LVL, lvl);
        contentValues.put(KEY_TRYS, tryss);

        String id = "1";
        int updCount = database.update(TABLE_NAME, contentValues, KEY_ID + "= ?", new String[]{id});
        Log.d("myLogs", "updated rows count = " + updCount);
    }

    //---------- Длинна слов, кол-во букв
    public void WriteDB_lenght(String lenght_3, String lenght_4, String lenght_5, String lenght_6, String lenght_7,
                               String lenght_8, String lenght_9, String lenght_10, String lenght_11, String lenght_12, String lenght_13, String lenght_14, String lenght_plus, String lenght_minus) {
        database = this.getWritableDatabase();
            contentValues_lenght.put(KEY_LENGHT_3, lenght_3);
            contentValues_lenght.put(KEY_LENGHT_4, lenght_4);
            contentValues_lenght.put(KEY_LENGHT_5, lenght_5);
            contentValues_lenght.put(KEY_LENGHT_6, lenght_6);
            contentValues_lenght.put(KEY_LENGHT_7, lenght_7);
            contentValues_lenght.put(KEY_LENGHT_8, lenght_8);
            contentValues_lenght.put(KEY_LENGHT_9, lenght_9);
            contentValues_lenght.put(KEY_LENGHT_10, lenght_10);
            contentValues_lenght.put(KEY_LENGHT_11, lenght_11);
            contentValues_lenght.put(KEY_LENGHT_12, lenght_12);
            contentValues_lenght.put(KEY_LENGHT_13, lenght_13);
            contentValues_lenght.put(KEY_LENGHT_14, lenght_14);
                contentValues_lenght.put(KEY_LENGHT_PLUS, lenght_plus);
                contentValues_lenght.put(KEY_LENGHT_MINUS, lenght_minus);
                database.insert(TABLE_NAME_lenght, null, contentValues_lenght);
    }
    public void ReadDB_lenght() {
        database = this.getWritableDatabase();
        cursor = database.query(TABLE_NAME_lenght, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
                setLENGHT_3(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_3))));
                setLENGHT_4(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_4))));
                setLENGHT_5(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_5))));
                setLENGHT_6(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_6))));
                setLENGHT_7(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_7))));
                setLENGHT_8(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_8))));
                setLENGHT_9(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_9))));
                setLENGHT_10(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_10))));
                setLENGHT_11(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_11))));
                setLENGHT_12(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_12))));
                setLENGHT_13(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_13))));
                setLENGHT_14(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_14))));
                    setLENGHT_PLUS(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_PLUS))));
                    setLENGHT_MINUS(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LENGHT_MINUS))));
            }
        cursor.close();
    }
    public void DeleteDB_lenght() {
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME_lenght, null, null);
        database.close();
    }


}
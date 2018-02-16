package br.edu.ifssaocarlos.sdm.stramdiet;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zigui on 15/02/2018.
 */

public class DBAdapter extends SQLiteOpenHelper{

    private static final String databaseName = "stramdiet";
    private static final int databaseVersion =6;
    private Context appContext;

    public DBAdapter(Context context){
        super(context, databaseName, null, databaseVersion);
        this.appContext = context;
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS users(" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_email VARCHAR," +
                "user_password VARCHAR," +
                "user_salt VARCHAR," +
                "user_alias VARCHAR," +
                "user_dob DATE," +
                "user_gender INT," +
                "user_location VARCHAR," +
                "user_height INT," +
                "user_activity_level INT," +
                "user_weight INT," +
                "user_target_weight INT," +
                "user_target_weight_level INT," +
                "user_last_seen TIME," +
                "user_note VARCHAR);");

        db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_cal_eaten(" +
                "cal_eaten_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cal_eaten_date DATE," +
                "cal_eaten_meal_no INT," +
                "cal_eaten_energy INT," +
                "cal_eaten_proteins INT," +
                "cal_eaten_carbs INT," +
                "cal_eaten_fat INT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS food_diary(" +
                "fd_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fd_date DATE," +
                "fd_meal_number INT," +
                "fd_food_id INT," +
                "fd_serving_size DOUBLE," +
                "fd_serving_measurement VARCHAR," +
                "fd_energy_calculated DOUBLE," +
                "fd_protein_calculated DOUBLE," +
                "fd_carbohydrates_calculated DOUBLE," +
                "fd_fat_calculated DOUBLE," +
                "fd_fat_meal_id INT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS categories(" +
                "category_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category_name VARCHAR," +
                "category_parent_id INT," +
                "category_icon VARCHAR," +
                "category_note VARCHAR);");

        db.execSQL("CREATE TABLE IF NOT EXISTS food( " +
                "food_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "food_name VARCHAR, " +
                "food_manufactor_name VARCHAR, " +
                "food_serving_size DOUBLE, " +
                "food_serving_measurement VARCHAR, " +
                "food_serving_name_number DOUBLE, " +
                "food_serving_name_word VARCHAR, " +
                "food_energy DOUBLE, " +
                "food_proteins DOUBLE, " +
                "food_carbohydrates DOUBLE, " +
                "food_fat DOUBLE, " +
                "food_energy_calculated DOUBLE, " +
                "food_proteins_calculated DOUBLE, " +
                "food_carbohydrates_calculated DOUBLE, " +
                "food_fat_calculated DOUBLE, " +
                "food_user_id INT, " +
                "food_barcode VARCHAR, " +
                "food_category_id INT, " +
                "food_thumb VARCHAR, " +
                "food_image_a VARCHAR, " +
                "food_image_b VARCHAR, " +
                "food_image_c VARCHAR, " +
                "food_notes VARCHAR);");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Log.i("aqui","agora>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS food_diary_cal_eaten");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS food_diary");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS categories");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS food");
        //onCreate(sqLiteDatabase);

        String TAG = "tag";
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
    }

    public void insert(String table, String fields, String values){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO "+table+"("+fields+") VALUES ("+values+")");
    }

    public int count(String table) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM "+table,null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        return count;
    }
}

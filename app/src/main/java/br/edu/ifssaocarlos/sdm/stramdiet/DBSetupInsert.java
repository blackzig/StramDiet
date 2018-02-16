package br.edu.ifssaocarlos.sdm.stramdiet;

import android.content.Context;

/**
 * Created by zigui on 15/02/2018.
 */

public class DBSetupInsert {

    private final Context context;

    public DBSetupInsert(Context ctx){
        this.context = ctx;
    }

    public void setupInsertToCategories(String values){
        DBAdapter dbAdapter = new DBAdapter(context);
        dbAdapter.insert("categories",
                "category_id, " +
                        "category_name, " +
                        "category_parent_id, " +
                        "category_icon, " +
                        "category_note",values);
    }

    public void insertAllCategories(){
        setupInsertToCategories("Null, 'Bread', '0', '', Null");
    }

    public void setupInsertToFood(String values){
        DBAdapter dbAdapter = new DBAdapter(context);
        dbAdapter.insert("food",
                "food_id, " +
                        "food_name, " +
                        "food_manufactor_name, " +
                        "food_serving_size, " +
                        "food_serving_measurement, " +
                        "food_serving_name_number, " +
                        "food_serving_name_word, " +
                        "food_energy, " +
                        "food_proteins, " +
                        "food_carbohydrates, " +
                        "food_fat, " +
                        "food_energy_calculated, " +
                        "food_proteins_calculated, " +
                        "food_carbohydrates_calculated, " +
                        "food_fat_calculated, " +
                        "food_user_id, " +
                        "food_barcode, " +
                        "food_category_id, " +
                        "food_thumb, " +
                        "food_image_a, " +
                        "food_image_b, " +
                        "food_image_c, " +
                        "food_notes", values);//23
    }

    public void insertAllFood(){
        setupInsertToFood("Null, " +
                "'Beef, bottom sirloin, tri-tip, separable lean only, trimmed to 0\" fat, all grades, raw', " +
                "'261.0', " +
                "'g', " +
                "'1.0', " +
                "'1 roast', " +
                "'371.0', " +
                "'55.5', " +
                "'0.0', " +
                "'14.7', " +
                "'371.0', " +
                "'237.0', " +
                "'1.1', " +
                "'133.0', " +
                "'7491', " +
                "'1', " +
                "'2barcode', " +
                "'2', " +
                "'1t', " +
                "'1a', " +
                "'1b', " +
                "'1c', " +
                "'vai'");
    }
}

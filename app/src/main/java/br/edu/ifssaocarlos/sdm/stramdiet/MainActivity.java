package br.edu.ifssaocarlos.sdm.stramdiet;

//chrome://inspect/#devices
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        DBAdapter db = new DBAdapter(this);
        try {

         //   int rows = db.count("food");
          //  Toast.makeText(this, "There are "+rows+" in the table.", Toast.LENGTH_SHORT).show();
            
          /*  db.insert("food", "food_id, food_name, food_manufactor_name, " +
                            "food_serving_size, food_serving_measurement, food_energy_calculated",
                    "Null,'Beef, bottom sirloin, tri-tip, separable lean only, trimmed to 0\" fat, all grades, raw', " +
                            "'Aurora', '261.0', 'g', '371'");*/
            DBSetupInsert dbSetupInsert = new DBSetupInsert(this);
           // dbSetupInsert.insertAllFood();
         //   dbSetupInsert.insertAllCategories();

            int numberRows = db.count("users");
            if(numberRows<1){
                Intent i = new Intent(this, SignUp.class);
                startActivity(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
    }


}

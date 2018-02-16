package br.edu.ifssaocarlos.sdm.stramdiet;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by zigui on 16/02/2018.
 */

public class SignUp extends AppCompatActivity{

    Button btn;
    int year, month, day;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();
    }

    public void showDialogOnButtonClick(){
        btn = findViewById(R.id.btn_birth);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, d, year, month, day);
        return null;
    }

    private DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int dOM) {
            year = y;
            month = m+1;
            day = dOM;
            String birth = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
            EditText tv = findViewById(R.id.edit_birth);
            tv.setText(birth);
        }
    };

}

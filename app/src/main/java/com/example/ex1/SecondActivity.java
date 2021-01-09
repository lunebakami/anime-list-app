package com.example.ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    ArrayList<String> arr = new ArrayList<>();
    Spinner spnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            arr = extras.getStringArrayList("arr");
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,arr);

        spnr = (Spinner)findViewById(R.id.spinner);
        spnr.setAdapter(adp);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"You have selected "+ arr.get(+position),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        Toast.makeText(getApplicationContext(),"You have selected nothing",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void goToMain(View View) {
        Intent main = new Intent(this, MainActivity.class);
        main.putExtra("arr", arr);
        startActivity(main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    Toast.makeText(getApplicationContext(),"OnePiece",Toast.LENGTH_LONG).show();
                break;
            case R.id.radio_ninjas:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Naruto",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
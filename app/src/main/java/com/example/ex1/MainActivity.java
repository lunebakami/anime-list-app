package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuInflater;
import android.view.View;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addAnime;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    Intent secondActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            arr = extras.getStringArrayList("arr");
        }
        secondActivity = new Intent(this, SecondActivity.class);
        addAnime = (Button) findViewById(R.id.btnAdd);
        btn = (Button) findViewById((R.id.btnSecond));

        /*BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_second)
                .build();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/

        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,arr);
        AutoCompleteTextView t1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);
        t1.setThreshold(1);
        t1.setAdapter(adp);

        addAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = t1.getText().toString();
                arr.add(str);
                adp.add(str);
                int pos = arr.indexOf(str);
                secondActivity.removeExtra("arr");
                secondActivity.putExtra("arr", arr);
                Toast msg = Toast.makeText(getBaseContext(), "Anime added", Toast.LENGTH_SHORT);
                msg.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecond();
            }
        });

    }

    public void goToSecond() {
        startActivity(secondActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
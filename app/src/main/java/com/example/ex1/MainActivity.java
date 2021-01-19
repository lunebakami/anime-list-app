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
import android.widget.ListView;
import android.widget.Toast;

import com.example.ex1.classes.Anime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Anime> animes = new ArrayList<>();
    Intent secondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animes = getIntent().getParcelableArrayListExtra("animes");
        if (animes == null) {
            animes = new ArrayList<>();
        }

        secondActivity = new Intent(this, SecondActivity.class);
        secondActivity.putParcelableArrayListExtra("animes",animes);

        // TODO Add Edit Button and Exclude Button
        ListView listview = (ListView) findViewById(R.id.list);

        final ArrayAdapter<Anime> adp = new ArrayAdapter<Anime>(this,
                android.R.layout.simple_dropdown_item_1line, animes);

        listview.setAdapter(adp);
    }

    public void goToSecond(View v) {
        startActivity(secondActivity);
    }
}
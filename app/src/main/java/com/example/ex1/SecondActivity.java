package com.example.ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ex1.classes.Anime;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    ArrayList<Anime> animes;
    Intent mainActivity;
    Button addAnime;
    Button btnMain;
    EditText animeName;
    EditText animeEps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        animes = getIntent().getParcelableArrayListExtra("animes");
        if(animes == null){
            animes = new ArrayList<>();
        }
        mainActivity = new Intent(this, MainActivity.class);

        animeName = (EditText) findViewById(R.id.animeName);
        animeEps = (EditText) findViewById(R.id.animeEps);
        addAnime = (Button) findViewById(R.id.btnAdd);
        btnMain = (Button) findViewById(R.id.btnMain);

        ArrayAdapter<Anime> adp = new ArrayAdapter<Anime>(this,
                android.R.layout.simple_dropdown_item_1line, animes);

        addAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = animeName.getText().toString();
                int eps = Integer.parseInt(animeEps.getText().toString());
                int id = animes.size();

                Anime anime = new Anime(name, eps, id);
                animes.add(anime);
                if (mainActivity.getParcelableArrayListExtra("animes") != null) {
                    mainActivity.removeExtra("animes");
                }
                mainActivity.putParcelableArrayListExtra("animes", animes);
                showMsg("Anime added!");
            }
        });
    }

    public void showMsg(String txt) {
        Toast msg = Toast.makeText(getBaseContext(), txt, Toast.LENGTH_SHORT);
        msg.show();
    }

    public void goToMain(View v) {
        mainActivity.putParcelableArrayListExtra("animes", animes);
        startActivity(mainActivity);
    }
}
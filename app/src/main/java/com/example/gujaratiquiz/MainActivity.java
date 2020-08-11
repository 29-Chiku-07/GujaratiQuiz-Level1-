package com.example.gujaratiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView , sc , score;
    Button btn , about , exit ;
    private int highScore;

    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sc = findViewById(R.id.sc);
        score = findViewById(R.id.score);
        btn = findViewById(R.id.btn);
        about = findViewById(R.id.about);
        exit = (Button)findViewById(R.id.exit);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontg.ttf");
        textView.setTypeface(font);
        sc.setTypeface(font);
        btn.setTypeface(font);
        about.setTypeface(font);
        exit.setTypeface(font);


        Intent intent = getIntent();
        String str = intent.getStringExtra("message");



        settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        highScore = settings.getInt("" , 0);
        highScore = highcore.scoree;

        score.setText("" + highScore);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, body.class);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);

            }
        });

    }


}
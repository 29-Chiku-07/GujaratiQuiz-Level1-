package com.example.gujaratiquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class about extends AppCompatActivity {

    private TextView t7,t8,t9;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        menu = findViewById(R.id.menu);

        t7.setMovementMethod(LinkMovementMethod.getInstance());
        t8.setMovementMethod(LinkMovementMethod.getInstance());
        t9.setMovementMethod(LinkMovementMethod.getInstance());

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(about.this , MainActivity.class));
                finish();

            }
        });



    }
}
package com.example.gujaratiquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class body extends AppCompatActivity {

    TextView tvQueCounter , tvTimer , tvQue , Score , t1 ;
    Button btOpt1 , btOpt2 , btOpt3 , btOpt4;
    int counter , sc ;
    CountDownTimer tm;
    Boolean find = false;

    ArrayList<QuestionClass> queList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        tvQue = (TextView) findViewById(R.id.tvQue);
        tvQueCounter = (TextView) findViewById(R.id.tvQueCounter);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        Score = (TextView) findViewById(R.id.Score);
        t1 = (TextView) findViewById(R.id.t1);

        btOpt1 = (Button) findViewById(R.id.btOpt1);
        btOpt2 = (Button) findViewById(R.id.btOpt2);
        btOpt3 = (Button) findViewById(R.id.btOpt3);
        btOpt4 = (Button) findViewById(R.id.btOpt4);

        Typeface fontg = Typeface.createFromAsset(getAssets(), "fonts/fontg.ttf");
        tvQue.setTypeface(fontg);
        btOpt1.setTypeface(fontg);
        btOpt2.setTypeface(fontg);
        btOpt3.setTypeface(fontg);
        btOpt4.setTypeface(fontg);

        counter = 0;
        sc=0;

        for(int i: printRandomNumbers(10,30)) {

             switch(i) {
                case 0: queList.add(new QuestionClass("ક", "ड", "क", "ह", "ङ", "क"));
                     break;

                case 1: queList.add(new QuestionClass("ઠ", "ड", "ढ", "ठ", "ङ", "ठ"));
                     break;

                case 2:    queList.add(new QuestionClass("ખ", "ख", "ज", "च", "ञ", "ख"));
                     break;

                case 3:    queList.add(new QuestionClass("ચ", "च", "श", "म", "थ", "च"));
                     break;

                case 4:    queList.add(new QuestionClass("જ", "भ", "ज", "ह", "म", "ज"));
                     break;

                case 5:   queList.add(new QuestionClass("એ", "ए", "ऐ", "ख", "ये", "ए"));
                     break;

                case 6:   queList.add(new QuestionClass("ળ", "च", "थ", "च", "ळ", "ळ"));
                     break;

                case 7:   queList.add(new QuestionClass("ફ", "फ", "ञ", "इ", "अ", "फ"));
                     break;

                case 8:   queList.add(new QuestionClass("હ", "ड", "द", "ह", "ऊ", "ह"));
                     break;

                case 9:   queList.add(new QuestionClass("દ", "छ", "उ", "क्ष", "द", "द"));
                     break;

                case 10:  queList.add(new QuestionClass("ગ", "च", "ग", "ज", "ञ", "ग"));
                     break;

                 case 11: queList.add(new QuestionClass("ઘ", "घ", "छ", "झ", "थ", "घ"));
                     break;

                 case 12: queList.add(new QuestionClass("ઙ", "द", "छ", "ड", "ङ", "ङ"));
                     break;

                 case 13: queList.add(new QuestionClass("છ", "छ", "झ", "घ", "क्ष", "छ"));
                     break;

                 case 14: queList.add(new QuestionClass("ઝ", "ञ", "झ", "क", "ख", "झ"));
                     break;

                 case 15: queList.add(new QuestionClass("ઞ", "ज्ञ", "ञ", "ह", "ळ", "ञ"));
                     break;

                 case 16: queList.add(new QuestionClass("ટ", "द", "ट", "र", "फ", "ट"));
                     break;

                 case 17: queList.add(new QuestionClass("ડ", "ट", "ङ", "द", "ड", "ड"));
                     break;

                 case 18: queList.add(new QuestionClass("ઢ", "ड", "ढ", "ट", "ञ", "ढ"));
                     break;

                 case 19: queList.add(new QuestionClass("ણ", "ध", "ण", "फ", "भ", "ण"));
                     break;

                 case 20: queList.add(new QuestionClass("બ", "भ", "फ", "ल", "ळ", "फ"));
                     break;

                 case 21: queList.add(new QuestionClass("જ્ઞ", "ज्ञ", "क्ष", "च", "ख", "ज्ञ"));
                     break;

                 case 22: queList.add(new QuestionClass("ક્ષ", "क्ष", "ष", "श", "य", "क्ष"));
                     break;

                 case 23: queList.add(new QuestionClass("અ", "आ", "अ", "ख", "य", "अ"));
                     break;

                 case 24: queList.add(new QuestionClass("ઇ", "इ", "ई", "छ", "ढ", "इ"));
                     break;

                 case 25: queList.add(new QuestionClass("અઃ", "अं", "अः", "आ", "औ", "अः"));
                     break;

                 case 26: queList.add(new QuestionClass("ઑ", "अः", "ऑ", "आ", "औ", "ऑ"));
                     break;

                 case 27: queList.add(new QuestionClass("ઊ", "उ", "ई", "ध", "ऊ", "ऊ"));
                     break;

                 case 28: queList.add(new QuestionClass("લ", "ल", "ष", "स", "क्ष", "ल"));
                     break;

                 case 29: queList.add(new QuestionClass("ભ", "द", "म", "भ", "फ", "भ"));
                     break;


             }
        }

        loadQuestions(counter);

        Score.setText(""+sc);
        highcore.scoree = sc;


        tvTimer.setText("20");

        tm=  new CountDownTimer(20*1000 , 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                if(counter < (queList.size() - 1))
                {
                    counter++;
                    loadQuestions(counter);

                } else if(counter > (queList.size() - 1)){
                    Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();


                } else if(find == false && (counter == (queList.size() - 1)) ){
                    Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(body.this , about.class));
                    finish();

                }

            }
        };
        tm.start();

    }


    //    Random Number
    public static final Random gen = new Random();
    public static int[] printRandomNumbers(int n, int maxRange){

        assert n<= maxRange : "cannot get more unique numbers than the size of the range";

        int[] result = new int[n];
        Set<Integer> used =new HashSet<Integer>();
        for(int i =0 ; i<n; i++){
            int newRandom;
            do{
                newRandom=gen.nextInt(maxRange+1);
            } while(used.contains(newRandom));
            result[i]=newRandom;
            used.add(newRandom);

        }

        return result;
    }

    // Random Number




    public void loadQuestions(int n){

        find = false;

        final QuestionClass q = queList.get(n);

        tvQueCounter.setText((n+1) + "/" + queList.size());

        Score.setText("" + sc);
        highcore.scoree = sc;
        //timer
        tvTimer.setText("" + 15);
        if(tm != null)
        {
            tm.start();
        }


        tvQue.setText((n+1) +" " +"ભાષાંતર " + "'" + q.getQue() + "'" );
        btOpt1.setText("" + q.getOpt1());
        btOpt2.setText("" + q.getOpt2());
        btOpt3.setText("" + q.getOpt3());
        btOpt4.setText("" + q.getOpt4());

        btOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find = true;

                if(btOpt1.getText().equals(q.getRightopt()))
                {
                    Toast.makeText(body.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    sc+= 10;
                    highcore.scoree = sc;

                    if(counter < (queList.size() - 1))
                    {   tm.cancel();
                        counter++;

                        loadQuestions(counter);



                    } else {
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }


                } else {
                    Toast.makeText(body.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    //if atlast wrong answer is selected
                    if(counter < (queList.size() - 1))
                    {
                    counter++;
                    loadQuestions(counter);}
                    else{
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }

                }

            }
        });



        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find = true;

                if(btOpt2.getText().equals(q.getRightopt()))
                {
                    Toast.makeText(body.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    sc+=10;
                    highcore.scoree = sc;

                    if(counter < (queList.size() - 1))
                    {   tm.cancel();
                        counter++;
                        loadQuestions(counter);


                    } else {
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }

                } else {
                    Toast.makeText(body.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    //if atlast wrong answer is selected
                    if(counter < (queList.size() - 1))
                    {
                        counter++;
                        loadQuestions(counter);}
                    else{
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }
                }

            }
        });

        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find = true;

                if(btOpt3.getText().equals(q.getRightopt()))
                {
                    Toast.makeText(body.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    sc +=10;
                    highcore.scoree = sc;

                    if(counter < (queList.size() - 1))
                    {   tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }

                } else {
                    Toast.makeText(body.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    //if atlast wrong answer is selected
                    if(counter < (queList.size() - 1))
                    {
                        counter++;
                        loadQuestions(counter);}
                    else{
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }
                }

            }
        });

        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find = true;

                if(btOpt4.getText().equals(q.getRightopt()))
                {
                    Toast.makeText(body.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    sc+=10;
                    highcore.scoree = sc;

                    if(counter < (queList.size() - 1))
                    {   tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }

                } else {

                    Toast.makeText(body.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    //if atlast wrong answer is selected
                    if(counter < (queList.size() - 1))
                    {
                        counter++;
                        loadQuestions(counter);}
                    else{
                        Toast.makeText(body.this, "All Questions Over", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(body.this , about.class));
                        finish();
                    }
                }

            }
        });


    }


}
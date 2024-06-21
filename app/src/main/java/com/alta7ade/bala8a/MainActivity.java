package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    CardView i2;
    Mydatabase sqldb;
    BufferedReader reader;
    InputStreamReader inputStreamReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.secondaire));
        }
        i2=findViewById(R.id.logo_image);

        Animation a1= AnimationUtils.loadAnimation(this, R.anim.logo);
        a1.setDuration(2000);
        i2.setAnimation(a1);
        sqldb=new Mydatabase(MainActivity.this);


        if((sqldb.getquestionscount())==0) {
            sqldb.deleteallquestions();

            eventchangelistennerAGE11();

            eventchangelistennerAGE12();

            eventchangelistennerAGE13();

            eventchangelistennerAGE14();

            eventchangelistennerAGE15();

            eventchangelistennerAGE16();

            eventchangelistennerAGE17();

            eventchangelistennerAGE18();

            eventchangelistennerAGE19();

        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent (MainActivity.this,home_Activity.class);
                startActivity(intent);
                finish();
            }
        },10000);
    }


    public void eventchangelistennerAGE11(){
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("11.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(17);

        }catch (Exception e) {

        }
    }

    public void eventchangelistennerAGE12(){
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("12.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(17);

        }catch (Exception e) {

        }
    }
    public void eventchangelistennerAGE13(){
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("13.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(17);

        }catch (Exception e) {

        }
    }
    public void eventchangelistennerAGE14(){

        try {
            inputStreamReader = new InputStreamReader(getAssets().open("14.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(17);

        }catch (Exception e) {

        }
    }
    public void eventchangelistennerAGE15(){
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("15.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(17);

        }catch (Exception e) {

        }
    }
    public void eventchangelistennerAGE16(){

        try {
            inputStreamReader = new InputStreamReader(getAssets().open("16.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(18);

        }catch (Exception e) {

        }

    }
    public void eventchangelistennerAGE17(){

        try {
            inputStreamReader = new InputStreamReader(getAssets().open("17.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(18);

        }catch (Exception e) {

        }

    }
    public void eventchangelistennerAGE18(){

        try {
            inputStreamReader = new InputStreamReader(getAssets().open("18.txt"),"UTF-8");
            reader = new BufferedReader(inputStreamReader);
            setdata(18);

        }catch (Exception e) {

        }

    }
    public void eventchangelistennerAGE19(){
        try {
                inputStreamReader = new InputStreamReader(getAssets().open("19.txt"),"UTF-8");
                reader = new BufferedReader(inputStreamReader);
                setdata(19);

        }catch (Exception e) {

        }

    }
    public void setdata( int agerequired){
        String numbers;
        int number;
        String question=null;
        String leson,right,false1,false2,false3;
        try {
            if((  numbers= reader.readLine())!=null){
                do {
                    number =Integer.parseInt(numbers);
                    question=reader.readLine();
                    leson=reader.readLine();
                    right = reader.readLine();
                    false1=null;
                    false2=null;
                    false3=null;

                    if(number==2){

                        false1= reader.readLine();
                        false2=null;
                        false3=null;

                    }
                    if(number==3){
                        false1= reader.readLine();
                        false2= reader.readLine();
                        false3=null;
                    }

                    if(number==4){
                        false1= reader.readLine();
                        false2= reader.readLine();
                        false3= reader.readLine();
                    }

                    String space= reader.readLine();


                    sqldb.insertquestionform(new questionform(false1,false2,false3,leson,question,right,agerequired,number));
                }while( (numbers= reader.readLine()) != null);

            }
        }catch (Exception e){


        }

    }

    }

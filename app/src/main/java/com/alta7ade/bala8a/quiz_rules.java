package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class quiz_rules extends AppCompatActivity {
    int year;
    ArrayList<String> strings,strings2;
    Animation a1;
    LinearLayout playlinear;
    ImageView background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_rules);
        a1= AnimationUtils.loadAnimation(this,R.anim.info);
        a1.setDuration(1000);
        playlinear=findViewById(R.id.linearplay);
        background=findViewById(R.id.background);
        playlinear.setAnimation(a1);
        year=getIntent().getIntExtra("year",0);
        strings=new ArrayList<>();
        strings =getIntent().getStringArrayListExtra("strings");
        int MARKS=getIntent().getIntExtra("MARKS",0);
        switch (getIntent().getStringExtra("tolevel")){
            case "one":
                //TODO: CHANGE THE BACKGROUND OF THE LEVEL HERE
                background.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.back1));
                playlinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this, level1_Activity.class);
                        intent.putExtra("year",year);
                        intent.putStringArrayListExtra("strings",strings);
                        startActivity(intent);
                        finish();
                    }
                });
            break;

            case "two":
                //TODO: CHANGE THE BACKGROUND OF THE LEVEL HERE
                background.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.back2));
                playlinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level2_Activity.class);
                        intent.putExtra("MARKS",MARKS);
                        intent.putExtra("year",year);
                        intent.putStringArrayListExtra("strings",strings);
                        startActivity(intent);
                        finish();
                    }
                });

            break;

            case "three":
                //TODO: CHANGE THE BACKGROUND OF THE LEVEL HERE
                background.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.back3));
                playlinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        strings2=new ArrayList<>();
                        strings2 =getIntent().getStringArrayListExtra("strings2");
                        Intent intent=new Intent(quiz_rules.this,level3_Activity.class);
                        intent.putExtra("year",year);
                        intent.putExtra("MARKS",MARKS);
                        intent.putStringArrayListExtra("strings",strings);
                        intent.putStringArrayListExtra("strings2",strings2);
                        startActivity(intent);
                        finish();
                    }
                });
            break;
        }
    }
}
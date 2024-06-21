package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class QuizInfoActivity extends AppCompatActivity {
int year;
TextView play;
CardView info;
Animation a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_info);
        a1= AnimationUtils.loadAnimation(this,R.anim.info);
        a1.setDuration(1000);
        info=findViewById(R.id.cardView2);
        info.setAnimation(a1);
        year=getIntent().getIntExtra("year",0);
        play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizInfoActivity.this,quiz_rules.class);
                intent.putExtra("year",year);
                intent.putExtra("tolevel","one");
                startActivity(intent);
                finish();
            }
        });
    }

    }

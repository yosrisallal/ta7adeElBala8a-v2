package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class home_Activity extends AppCompatActivity  {
CardView level1,level2,level3;
TextView youtube,website,facebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        level1=findViewById(R.id.level1);
        level2=findViewById(R.id.level2);
        level3=findViewById(R.id.level3);
        youtube=findViewById(R.id.youtube);
        facebook=findViewById(R.id.facebook);
        website=findViewById(R.id.website);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCI6iERAueVFkEhrOKStFDNA"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nhwdotcom"));
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alnahw.com/"));
                startActivity(intent);
            }
        });



        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home_Activity.this,QuizInfoActivity.class);
                intent.putExtra("year",17);
                startActivity(intent);
            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home_Activity.this,QuizInfoActivity.class);
                intent.putExtra("year",18);
                startActivity(intent);
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home_Activity.this,QuizInfoActivity.class);
                intent.putExtra("year",19);
                startActivity(intent);
            }
        });
    }
}
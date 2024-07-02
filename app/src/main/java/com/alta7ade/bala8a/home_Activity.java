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
TextView quote ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        level1=findViewById(R.id.level1);
        level2=findViewById(R.id.level2);
        level3=findViewById(R.id.level3);
        quote=findViewById(R.id.quoteText);
        if(getResources().getString(R.string.quote).isEmpty()){
            quote.setVisibility(View.GONE);
        }

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
package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
public class loserorwinner extends AppCompatActivity {
    String checking;
    int age ;
    TextView title_status,message;
    LottieAnimationView lottie_status;
    Button return_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loserorwinner);
        checking=getIntent().getStringExtra("check");
        age=getIntent().getIntExtra("year",0);
        title_status=findViewById(R.id.title_status);
        message=findViewById(R.id.tv_status_message);
        return_home=findViewById(R.id.try_Again);
        lottie_status=findViewById(R.id.lottie_status);
        message.setTextColor(getResources().getColor(R.color.purple_700));
        switch(checking){
            case "checked":
                title_status.setText("أنتَ عبقريٌّ في البلاغة ");
                title_status.setTextColor(getResources().getColor(R.color.purple_700));
                lottie_status.setAnimation(R.raw.success);
                message.setText("المسابقة انتهت .. لكنَّ التَّحدِّي مستمرٌّ");
                break;
            case"unchecked":
                title_status.setText("للأسف ..لقد خسرت التحدي !! ");
                title_status.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                lottie_status.setAnimation(R.raw.gameover);
                message.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                break;

            case "timeout":
                title_status.setText("للأسف .. انتهى الوقت!! ");
                title_status.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                message.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                lottie_status.setAnimation(R.raw.timeout);
                break;
        }
        return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(loserorwinner.this,QuizInfoActivity.class);
                intent.putExtra("year",age);
                startActivity(intent);
                finish();
            }
        });
    }
}

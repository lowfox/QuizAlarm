package com.example.ohs70333.quizalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void BtAlarmClick(View view){
        Intent intent = new Intent(MainActivity.this, AlarmConf.class);
        //アクティビティを起動
        startActivity(intent);
    }

    public void BtQuizClick(View view){
        Intent intent = new Intent(MainActivity.this, QuizConf.class);
        startActivity(intent);
    }
}

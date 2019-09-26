package com.example.ohs70333.quizalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.util.Calendar;

public class AlarmConf extends AppCompatActivity {
Spinner spnTime;
Spinner spnMin;
int setTime;
int setMin;
private String times[]={"１","２","３","４","５","６","７","８","９","１０","１１","１２","１３","１４","１５","１６","１７","１８","１９","２０","２１","２２","２３","２４"};
private String mins[]={"０","１","２","３","４","５","６","７","８","９","１０","１１","１２","１３","１４","１５","１６","１７","１８","１９","２０","２１","２２","２３","２４","２５","２６","２７","２８","２９","３０","３１","３２","３３","３４","３５","３６","３７","３８","３９","４０","４１","４２","４３","４４","４５","４６","４７","４８","４９","５０","５１","５２","５３","５４","５５","５６","５７","５８","５９"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_conf);

        spnTime=(Spinner)findViewById(R.id.SpnTime);
        spnMin=(Spinner)findViewById(R.id.SpnMin);


        //////////////////////////プルダウン: 時間///////////////////


        //ArrayAdapter
        ArrayAdapter<String> adapter_time = new ArrayAdapter<String>(
               this,
                android.R.layout.simple_spinner_item,
                times
        );


        adapter_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spnTime.setAdapter(adapter_time);

        // リスナーを登録
        spnTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                setTime = position + 1;
                //Toast.makeText(AlarmConf.this , setTime, Toast.LENGTH_SHORT).show();
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        //////////////////////////プルダウン: 分///////////////////


        //ArrayAdapter
        ArrayAdapter<String> adapter_min = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                mins
        );


        adapter_min.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spnMin.setAdapter(adapter_min);

        // リスナーを登録
        spnMin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                setMin = position;
                //Toast.makeText(AlarmConf.this , setTime, Toast.LENGTH_SHORT).show();
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });


    }


    public void BtConf(View view){

        MyAlarmManager alrmMam = new MyAlarmManager(AlarmConf.this);


        alrmMam.addAlarm(setTime,setMin);
    }

    public void BtCancel(View view){

        MyAlarmManager alrmMam = new MyAlarmManager(AlarmConf.this);


        alrmMam.stopAlarm();
        Toast.makeText(AlarmConf.this, String.format("アラームをキャンセルしました"), Toast.LENGTH_LONG).show();
    }
    public void BtBack(View view){
        finish();
    }

}


package com.example.ohs70333.quizalarm;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class AlarmNortificationActivity extends Activity {
    private MediaPlayer mp =new MediaPlayer();
    private Button BtStop;
    private int cnt=0;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_notification);

        BtStop = findViewById(R.id.btStop);
        // スクリーンロックを解除する
        // 権限が必要
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //Toast.makeText(this, "アラーム！", Toast.LENGTH_SHORT).show();
        BtStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cnt==0) {
                    if (mp.isPlaying()) {
                        Toast.makeText(getApplicationContext(), "アラーム止める", Toast.LENGTH_SHORT).show();

                        mp.stop();
                        mp.release();
                        cnt++;
                    }
                }

                // stopAndRelaese();
                //Toast.makeText(getApplicationContext(), "アラーム止めた", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
       // Toast.makeText(getApplicationContext(), "アラームスタート！", Toast.LENGTH_SHORT).show();

        //フィールドのメディアプレーヤーオブジェクトを生成
        mp = new MediaPlayer();
        //音声ファイルのURI文字列を作成
        //String mediaFileUriStr ="android.resource://"+ getPackageName()+"/"+R.raw.clockalarm05;
        //音声ファイルのURI文字列をもとにURIオブジェクトを生成。
        //Uri mediaFileUri = Uri.parse(mediaFileUriStr);
        //メディアプレーヤーに音声ファイルを指定。
        //mp.setDataSource(AlarmNortificationActivity.this, mediaFileUri);
        mp = MediaPlayer.create(AlarmNortificationActivity.this, R.raw.clockalarm05);
        //非同期でメディア再生
        //mp.prepareAsync();
        mp.seekTo(0);
        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopAndRelaese();
    }

    private void stopAndRelaese() {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }

/*
    @Override
    protected void onResume() {
        super.onResume();
        alarmNowText = (TextView) findViewById(R.id.alarm_now_time);
        handler.sendEmptyMessage(WHAT);
        // mam.stopAlarm();
    }
*/
}
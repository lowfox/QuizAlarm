package com.example.ohs70333.quizalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class QuizConf extends AppCompatActivity {
    private String selectQuizItems[] = {"基本情報", "応用情報"};
    private String selectQuizNum[] = {"１問", "２問","３問","４問"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_conf);

        //////////////////////////プルダウン：出題範囲///////////////////
        Spinner spn_quiz_select = findViewById(R.id.SpnQuizSelect);
        //ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                selectQuizItems
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spn_quiz_select.setAdapter(adapter);

        // リスナーを登録
        spn_quiz_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();
                Toast.makeText(QuizConf.this , item, Toast.LENGTH_SHORT).show();
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });


        ////////////////////////プルダウン：問題数//////////////////////////////////
        Spinner spn_quiz_num = findViewById(R.id.SpnQuizNum);
        //ArrayAdapter
        ArrayAdapter<String> adapter_num = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                selectQuizNum
        );

        adapter_num.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spn_quiz_num.setAdapter(adapter_num);

        // リスナーを登録
        spn_quiz_num.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();
                Toast.makeText(QuizConf.this , item, Toast.LENGTH_SHORT).show();
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }
    public void BtBack(View view){
        finish();
    }
}

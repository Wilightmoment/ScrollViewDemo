package com.example.royal.scrollviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    private TextView tvCount;
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private Button button;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        tvCount.setText(String.valueOf(count));
    }

    private void findViews(){
        tvCount=(TextView)findViewById(R.id.tvCount);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        button=(Button)findViewById(R.id.btAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //點按鈕將計數器+1
                count++;
                tvCount.setText(String.valueOf(count));
                //呼叫TextView() 建構式(constructor)並傳入 Context物件 以動態建立TextView, 最後linearLayout呼叫addView()加入新增的TextView
                TextView textView = new TextView(MainActivity.this);
                textView.setText(String.valueOf(count));
                linearLayout.addView(textView);
                //自動將ScrollView捲動到最下面已顯示最後新增的TextView
                scrollView.post(new Runnable(){
                    @Override
                    public void run(){
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
}


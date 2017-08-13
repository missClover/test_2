package com.example.administrator.test_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Second_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
//        各个按键的实例化
        Button button_2 = (Button) findViewById(R.id.A2_btn2);

//        接收来自first_activity的数据
        Intent intent = getIntent();
        String s = intent.getStringExtra("extra_data");
        Log.e("Second_activity",s);

//        向上一个活动传递数据，即First_activity
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datas = "My name is Second_activity";
//                把数据暂存在intent中了
                Intent intent = new Intent();
                intent.putExtra("extra_data",datas);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

//    重写onBackPressed()方法实现本级活动向上一个活动传递数据

    @Override
    public void onBackPressed() {
        String datas = "My name is Second_activity(返回键传递)";
        Intent intent = new Intent();
        intent.putExtra("extra_data",datas);
        setResult(RESULT_OK,intent);
        finish();
    }
}

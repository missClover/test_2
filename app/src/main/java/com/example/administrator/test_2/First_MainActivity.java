package com.example.administrator.test_2;
//First day第一天：8/12/2017
//这个世界上没有天才，只有不努力的笨蛋  ---《夏至未至》
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class First_MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //    Toast的使用
        Button button_1 = (Button) findViewById(R.id.btn1);
        Button button_2 = (Button) findViewById(R.id.btn2);
        Button button_3 = (Button) findViewById(R.id.btn3);
        Button button_4 = (Button) findViewById(R.id.btn4);
        Button button_6 = (Button) findViewById(R.id.btn6);
//        放在onCreate方法外程序会出现崩溃现象
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(First_MainActivity.this,"Android第一天(Toast的应用)",Toast.LENGTH_SHORT).show();
            }
        });
//        按返回键销毁活动、
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        启动第二个活动显式Intent
       button_3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String s = "My name is first_activity";
               Intent intent = new Intent(First_MainActivity.this,Second_MainActivity.class);
               intent.putExtra("extra_data",s);
               startActivity(intent);
           }
        });
//        启动第二个活动隐式Intent
//        button_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = "My name is first_activity";
//                Intent intent = new Intent("com.example.second_activity.ACTION_START");
//                intent.putExtra("extra_data",s);
//                startActivity(intent);
//            }
//        });
//        使用Intent跳转至指定的网址
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
//        tel协议实现调用电话功能
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1008611"));
                startActivity(intent);
            }
        });
    }

//    重写onCreateOptionsMenu（）方法实现建立菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item,menu);
//        这里的item为res下的menu下的item.xml
//        同样的menu也为res下的menu，都是非唯一的
//        第二个参数将我们的菜单项添加到哪一个Menu对象当中（直接使用方法中传入的menu参数）
        return true;
//        若此处为false创建的菜单将无法显示
    }

//    重写onoptionItemSelected()方法实现建立菜单项
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(First_MainActivity.this, "Android第一天(Add)", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(First_MainActivity.this, "Android第一天(remove)", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(First_MainActivity.this, "Android第一天(default)", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

//    重写onActivityResult方法实现数据传递
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        判断数据来源，是否来自Second_activity
        switch (resultCode){
            case 1:
//                判断处理结果，即是否为Second_activity中的setResult（）方法中的RESULT_OK
                if(requestCode == RESULT_OK){
//                    开始接收数据
                    String Result_data = data.getStringExtra("extra_data");
//                    打印所接收的数据
                    Log.d("Second_activity:",Result_data);
                }
        }
    }

//    第二种方法下一活动向上一个活动传递数据（只需要按“back即可”）
//    该方法在于在Second_activity中重写onBackPressed()方法
}

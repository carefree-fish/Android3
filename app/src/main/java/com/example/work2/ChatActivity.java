package com.example.work2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ChatActivity extends AppCompatActivity {

    private TextView chattext;
    private Button chatbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Log.d("ChatActivity", "onCreate");
        chattext=findViewById(R.id.inputText);
        chatbt=findViewById(R.id.chatbutton);
        Intent intent=getIntent();//各个组件进行交互的一种重要方式，它不仅可以指定当前组件要执行的 动作，还可以在不同组件之间进行 数据传递


        chatbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String ctStr=chattext.getText().toString();       //取得输入框中的内容
              //Intent intent = new Intent(ChatActivity.this, IntroductActivity.class);//创建Intent对象，参数分别为上下文，要跳转的Activity类
              intent.putExtra("ctStr1",ctStr);      //将要传递的值附加到Intent对象
              //startActivity(intent);
              setResult(1,intent);
              finish(); //利用finish()的原理——“它将返回到当前Activity的发起者”,避免activity多次回跳
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ChatActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ChatActivity", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ChatActivity", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ChatActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ChatActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ChatActivity", "onDestroy");
    }
}
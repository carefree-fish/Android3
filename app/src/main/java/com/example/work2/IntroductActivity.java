package com.example.work2;

import androidx.activity.result.ActivityResult;
        import androidx.activity.result.ActivityResultCallback;
        import androidx.activity.result.ActivityResultLauncher;
        import androidx.activity.result.contract.ActivityResultContracts;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntroductActivity extends AppCompatActivity {
    private TextView textView;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduct);

        Log.d("IntroductActivity", "onCreate");
        button1=findViewById(R.id.button1);
        textView=findViewById(R.id.itemtextView2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                //创建Intent对象，参数分别为上下文，要跳转的Activity类
                Intent intent=new Intent(IntroductActivity.this, ChatActivity.class);
                test.launch(intent);
            }
        });
    }

    //如下方法可在创建的同时，接收返回值
    //也可直接startactivity(intent);
    public ActivityResultLauncher test=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==1){
                        Log.d("IntroductActivity","onActivityResult...");
                        textView.setText(result.getData().getStringExtra("ctStr1"));
                    }
                }
            }
    );

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("IntroductActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("IntroductActivity", "onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("IntroductActivity", "onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("IntroductActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("IntroductActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("IntroductActivity", "onDestroy");
    }
}
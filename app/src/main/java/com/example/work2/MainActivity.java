package com.example.work2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment fragment1,fragment2,fragment3,fragment4;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();   //隐藏顶栏项目名称
        setContentView(R.layout.activity_main);

        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);
        linearLayout4=findViewById(R.id.LinearLayout4);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        manager=getSupportFragmentManager();

        initial();
        hidden();
        showfragment(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        imageView1=findViewById(R.id.imageView1);   //底栏4个imageview
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
    }

    private void initial() {
        transaction=manager.beginTransaction()
                .add(R.id.frameLayout,fragment1)
                .add(R.id.frameLayout,fragment2)
                .add(R.id.frameLayout,fragment3)
                .add(R.id.frameLayout,fragment4);
        transaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LinearLayout1:select(1);
                break;
            case R.id.LinearLayout2:select(2);
                break;
            case R.id.LinearLayout3:select(3);
                break;
            case R.id.LinearLayout4:select(4);
                break;
        }
    }

    public void select( int i) {
        hidden();
        switch (i){
            case 1:
                Log.d("fragment","界面1");
                showfragment(fragment1);
                darken();
                imageView1.setImageResource(R.drawable._12);//相应image变深色
                break;
            case 2:
                Log.d("fragment","界面2");
                showfragment(fragment2);
                darken();
                imageView2.setImageResource(R.drawable._22);
                break;
            case 3:
                Log.d("fragment","界面3");
                showfragment(fragment3);
                darken();
                imageView3.setImageResource(R.drawable._32);
                break;
            case 4:
                Log.d("fragment","界面4");
                showfragment(fragment4);
                darken();
                imageView4.setImageResource(R.drawable._42);
                break;
        }
    }

    private void darken(){      //其他image复原
        imageView1.setImageResource(R.drawable._11);
        imageView2.setImageResource(R.drawable._21);
        imageView3.setImageResource(R.drawable._31);
        imageView4.setImageResource(R.drawable._41);
    }

    private void showfragment(Fragment fragment) {
        transaction.show(fragment);
    }

    private void hidden() {
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();
        
    }


}
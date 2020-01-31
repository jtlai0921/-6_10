package com.ehappy.ch09_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得資源介面元件
        Button btnPage2=(Button)findViewById(R.id.btnPage2);
        // 設定 button 的  Listner
        btnPage2.setOnClickListener(btnPage2Listner);
    }

    private Button.OnClickListener btnPage2Listner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Second.class);
            startActivity(intent);
        }
    };
}
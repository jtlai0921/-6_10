package com.ehappy.ch09_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtnumA,edtnumB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得介面元件
        edtnumA=(EditText)findViewById(R.id.edtnumA);
        edtnumB=(EditText)findViewById(R.id.edtnumB);
        Button btnPage2=(Button)findViewById(R.id.btnPage2);
        // 設定 button 的 Listner
        btnPage2.setOnClickListener(btnPage2Listner);
    }

    private Button.OnClickListener btnPage2Listner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Second.class);

            int a=Integer.parseInt(edtnumA.getText().toString());
            int b=Integer.parseInt(edtnumB.getText().toString());

            Bundle bundle=new Bundle();
            bundle.putInt("numA",a);
            bundle.putInt("numB",b);
            intent.putExtras(bundle);

            // 執行附帶資料的 Intent
            startActivity(intent);
        }
    };
}
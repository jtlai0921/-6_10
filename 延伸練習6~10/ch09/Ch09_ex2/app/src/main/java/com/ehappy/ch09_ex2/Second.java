package com.ehappy.ch09_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        // 取得介面元件
        TextView txtResult=(TextView)findViewById(R.id.txtResult);
        Button btnHome=(Button)findViewById(R.id.btnHome);

        // 設定 button 的   Listner
        btnHome.setOnClickListener(btnHomeListner);

        // 取得  bundle
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        int a=bundle.getInt("numA");
        int b=bundle.getInt("numB");
        int sum=a+b;
        String s=a + " + " + b + " = " + sum;
        txtResult.setText(s);
    }

    private Button.OnClickListener btnHomeListner=new Button.OnClickListener(){
        public void onClick(View v){
            finish();
        }
    };
}


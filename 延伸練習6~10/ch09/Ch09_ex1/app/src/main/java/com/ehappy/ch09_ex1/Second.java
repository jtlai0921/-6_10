package com.ehappy.ch09_ex1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        // 取得介面元件
        Button btnHome=(Button)findViewById(R.id.btnHome);
        // 設定 button 的 Listner
        btnHome.setOnClickListener(btnHomeListner); 
    }
    
    private Button.OnClickListener btnHomeListner=new Button.OnClickListener(){
    	public void onClick(View v){
    		finish();
    	}
    };    
}
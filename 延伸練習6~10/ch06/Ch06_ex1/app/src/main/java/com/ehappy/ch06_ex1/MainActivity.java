package com.ehappy.ch06_ex1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 將所有的圖片儲存至陣列中
    int[] imgId={R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06};
    String[] BookId={"AEL011200","AEL011300","AEL011400","ACL030131","ACL027400","ACL027100"};
    String[] BookName={"Visual C# 2010程式設計速學對策",
            "Visual Basic 2010 程式設計速學對策",
            "ASP.NET 4.0 網頁程式設計速學對策(使用C#)",
            "挑戰Visual C++ 2008程式設計樂活學",
            "挑戰Visual C# 2008程式設計樂活學",
            "挑戰Visual Basic 2008程式設計樂活學"};

    private Button btnNext;
    private ImageView imgPhoto;
    private TextView txtResult;
    int p=0; // 圖片的索引(第幾張圖片)
    int count=imgId.length; // 共有多少張圖片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得資源類別 R 中的介面元件
        btnNext=(Button)findViewById(R.id.btnNext);
        imgPhoto=(ImageView)findViewById(R.id.imgPhoto);
        txtResult=(TextView) findViewById(R.id.txtResult);

        // 設定  button 元件  Click 事件的  listener
        btnNext.setOnClickListener(btnNextListener);
        txtResult.setText("書號： " + BookId[p] + "\n" +
                "書名： " + BookName[p]);
    }

    // 定義 btnNext 按鈕的onClick() 方法
    private Button.OnClickListener btnNextListener=new Button.OnClickListener(){
        public void onClick(View v){
            p++;
            if (p==count)
                p=0;
            imgPhoto.setImageResource(imgId[p]);
            txtResult.setText("書號： " + BookId[p] + "\n" +
                    "書名： " + BookName[p]);
        }
    };
}

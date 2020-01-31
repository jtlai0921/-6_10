package com.ehappy.ch06_ex2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int[] imageIds = {
            R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06 };

    String[] BookId={"AEL011200","AEL011300","AEL011400","ACL030131","ACL027400","ACL027100"};
    String[] BookName={"Visual C# 2010程式設計速學對策",
            "Visual Basic 2010 程式設計速學對策",
            "ASP.NET 4.0 網頁程式設計速學對策(使用C#)",
            "挑戰Visual C++ 2008程式設計樂活學",
            "挑戰Visual C# 2008程式設計樂活學",
            "挑戰Visual Basic 2008程式設計樂活學"};

    private ImageView imgShow;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得資源類別檔中的介面元件
        imgShow=(ImageView)findViewById(R.id.imgShow);
        txtResult=(TextView) findViewById(R.id.txtResult);
        Gallery gal=(Gallery)findViewById(R.id.Gallery01);

        // 建立自訂的 Adapter
        MyAdapter adapter=new MyAdapter(this);

        // 設定  Gallery 的資料來源
        gal.setAdapter(adapter);

        // 設定  Gallery 元件 ItemSelected 事件的  listener 為  galListener
        gal.setOnItemSelectedListener(galListener);

        gal.setSelection(Integer.MAX_VALUE / 2); //預設位置在中間
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private Gallery.OnItemSelectedListener galListener=new Gallery.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position,
                                   long id) {
            int p=position % imageIds.length;
            imgShow.setImageResource(imageIds[p]);
            txtResult.setText("書號： " + BookId[p] + "\n" +
                    "書名： " + BookName[p]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0){
            // TODO Auto-generated method stub
        }
    };

    // 自訂的  MyAdapter 類別，繼承 BaseAdapter 類別
    class MyAdapter extends BaseAdapter {
        private Context mContext;
        public MyAdapter(Context c){
            mContext=c;
        }
        public int getCount(){
            return Integer.MAX_VALUE;
        }
        public Object getItem(int position){
            return position;
        }
        public long getItemId(int position){
            return position; // 目前圖片索引
        }

        public View getView(int position, View contextView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageIds[position % imageIds.length]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new Gallery.LayoutParams(45,60));
            return iv;
        }
    }
}
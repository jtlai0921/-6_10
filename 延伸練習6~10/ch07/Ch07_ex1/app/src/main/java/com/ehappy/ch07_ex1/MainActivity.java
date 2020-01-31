package com.ehappy.ch07_ex1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private ListView lstPrefer;
    String[] Fruits= new String[] {"香蕉","西瓜","梨子","水蜜桃"};
    int[] Price=new int[] {330,120,250,280};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得介面元件
        txtResult=(TextView) findViewById(R.id.txtResult);
        lstPrefer=(ListView) findViewById(R.id.lstPrefer);

        // 建立 ArrayAdapter
        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,Fruits);

        // 設定 ListView 的資料來源
        lstPrefer.setAdapter(adapterBalls);

        // 設定 lstPrefer 元件 ItemClick 事件的 listener為 lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);
    }

    // 定義 onItemClick 方法
    private ListView.OnItemClickListener lstPreferListener=
     new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {
            // 顯示 ListView 的選項內容
            String sel=parent.getItemAtPosition(position).toString();
            txtResult.setText(sel + " 每斤：" + Price[position] + " 元");
        }
    };
}
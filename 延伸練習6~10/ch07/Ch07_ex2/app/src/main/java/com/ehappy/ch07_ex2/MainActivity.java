package com.ehappy.ch07_ex2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private ListView lstPrefer;
    private Button btnDo;
    String[] Fruits= new String[] {"香蕉","西瓜","梨子","水蜜桃"};
    int[] Price=new int[] {330,120,250,280};
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 取得資源類別檔中的介面元件
        btnDo=(Button) findViewById(R.id.btnDo);
        txtResult=(TextView)findViewById(R.id.txtResult);
        lstPrefer=(ListView)findViewById(R.id.lstPrefer);

        // 以多選範本 建立 ArrayAdapter
        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, Fruits);

        lstPrefer.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // 設定可多選

        // 設定 ListView 的資料來源
        lstPrefer.setAdapter(adapterBalls);

        count = adapterBalls.getCount();  // 取得選取項目總數

        // 設定 button 元件 Click 事件的 listener 為  btnDoListener
        btnDo.setOnClickListener(btnDoListener);

        // 設定 lstPrefer 元件 ItemClick 事件的 listener 為 lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);
    }

    // 定義 onClick()方法
    private Button.OnClickListener btnDoListener=new Button.OnClickListener(){
        public void onClick(View v){
            String selAll="";
            int total=0;
            for(int p = 0; p < count; p++){
                if (lstPrefer.isItemChecked(p)) // 巳核選
                {
                    selAll += Fruits[p] + " ";
                    total += Price[p];
                }
            }
            txtResult.setText("選購了 :" + selAll + "\n" + "總額： " + total);
        }
    };

    // 定義 onItemClick 方法
    private ListView.OnItemClickListener lstPreferListener=
     new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {
            // 顯示 ListView 的選項內容
            String sel=parent.getItemAtPosition(position).toString();
            setTitle(sel + " 每斤：" + Price[position] + " 元");
        }
    };
}

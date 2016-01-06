package me.tbs.zhang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import me.tbs.zhang.R;
import me.tbs.zhang.entity.Record;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    Button findBtn, main_import;
    EditText input_edit;
    ListView listView;
    TextView uname, longExpense, shortExpense;

    List<Record> dataList = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //模拟假数据
        for(int i=0 ; i<78 ; i++ ){
            Record record = new Record();
            record.setTellNumber("18500984815");
            record.setDuration(3.5f);
            record.setId(i);
            record.setType(true);
            dataList.add(record);
//        toString    Record{id=0, tellNumber='18500984815', duration=3.5, type=true}
        }

        //初始化控件
        findBtn = (Button) findViewById(R.id.main_btn);
        main_import = (Button) findViewById(R.id.main_import);
        input_edit = (EditText) findViewById(R.id.main_edit_text);
        listView = (ListView) findViewById(R.id.main_listview);
        uname = (TextView) findViewById(R.id.main_uname);
        longExpense = (TextView) findViewById(R.id.main_long_mongy_tv);
        shortExpense = (TextView) findViewById(R.id.main_short_money_tv);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:搜索获取数据
            }
        });

        main_import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FilesActivity.class));
            }
        });

        listView.setAdapter(new MyAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        String path = getIntent().getStringExtra("file_path");
        if(path==null){
            return;
        }
        File txtFile = new File(path);//获得选择的txt文件
        String result = getStringFromFile(txtFile);
        input_edit.setText(result);
    }

    public String getStringFromFile(File file) {
        try {
            StringBuffer sBuffer = new StringBuffer();
            FileInputStream fInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, "utf-8");
            BufferedReader in = new BufferedReader(inputStreamReader);
            while (in.ready()) {
                sBuffer.append(in.readLine() + "\n");
            }
            in.close();
            return sBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public class MyAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;
        TextView number_tv, type_tv, duration_tv, expense_tv;

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return dataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(MainActivity.this);
            }
            view = layoutInflater.inflate(R.layout.main_item, null);
            number_tv = (TextView) view.findViewById(R.id.number_tv);
            type_tv = (TextView) view.findViewById(R.id.type_tv);
            duration_tv = (TextView) view.findViewById(R.id.duration_tv);
            expense_tv = (TextView) view.findViewById(R.id.expense_tv);

            number_tv.setText(dataList.get(i).getTellNumber());
            type_tv.setText("长途／本地");
            expense_tv.setText("4.5分钟");

            return view;
        }
    }

}

package me.tbs.zhang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import me.tbs.zhang.R;
import me.tbs.zhang.entity.Record;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    Button findBtn;
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
            record.setUname("zhang"+i);
            record.setDuration(i);
            record.setLongCall(true);
            dataList.add(record);
        }

        //初始化控件
        findBtn = (Button) findViewById(R.id.main_btn);
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

        listView.setAdapter(new MyAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        String path = getIntent().getStringExtra("file_path");
        File txtFile = new File(path);//获得选择的txt文件
        //TODO：读取文件
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

            number_tv.setText(dataList.get(i).getUname());
            type_tv.setText("长途／本地");
            expense_tv.setText("4.5分钟");

            return view;
        }
    }

}

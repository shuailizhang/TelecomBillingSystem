package me.tbs.zhang.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import me.tbs.zhang.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dime on 16-1-5.
 */
public class FilesActivity extends ListActivity {

    List<File> wellList = new ArrayList<File>();//存储当前合适的文件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        File file = Environment.getExternalStorageDirectory();
        boolean b = file.isDirectory();
        File[] files = file.listFiles();//root目录列表
        showTrees(files);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        File file = wellList.get(position);
        if(file.isDirectory()){
            showTrees(file.listFiles());
        }else{//那么肯定是.txt文件啦
            Intent intent = new Intent(FilesActivity.this, MainActivity.class);
            intent.putExtra("file_path", file.getAbsolutePath());//txt文件的绝对路径
            startActivity(intent);
        }
    }

    private void showTrees(File[] trees) {
        wellList.clear();
        //过滤，只保留文件夹 or *.txt　文件
        for (File file : trees) {
            if(file.isDirectory()){
                wellList.add(file);
            }else if(file.getName().toLowerCase().endsWith(".txt")){
                wellList.add(file);
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FilesActivity.this, android.R.layout.simple_list_item_1, getTreeNames(wellList));
        setListAdapter(arrayAdapter);
    }


    /**
     * 将文件列表变换成字符串列表
     * @param wells
     * @return
     */
    private String[] getTreeNames(List<File> wells) {
        ArrayList<String> nameList = new ArrayList<String>();
        for(File file : wells){
            nameList.add(file.getName());
        }
        return nameList.toArray(new String[0]);
    }


}

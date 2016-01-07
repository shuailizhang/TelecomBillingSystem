package me.tbs.zhang.dialog;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import me.tbs.zhang.R;
import me.tbs.zhang.entity.Record;
import me.tbs.zhang.utils.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dime on 16-1-7.
 */
public class AddDialog extends Dialog {

    Window window;
    Context context;

    EditText add_name_edit, add_tel_edit, add_duration_edit;
    RadioGroup add_type_rg;
    RadioButton add_long_rb, add_short_rb;
    Button add_yes, add_no;

    public AddDialog(Context context) {
        super(context, R.style.mydialog);
        this.context = context;
    }

    public void showDialog(){
        setContentView(R.layout.dialog_add);
        window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = dip2px(context, 300);
        layoutParams.height = dip2px(context, 400);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(false);//不允许触摸消失

        initView();//初始化控件
        initClick();//初始化控件点击事件

        show();//显示出来
    }

    private void initClick() {
        add_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        add_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                if(TextUtils.isEmpty(add_duration_edit.getText()) || TextUtils.isEmpty(add_tel_edit.getText()) || TextUtils.isEmpty(add_name_edit.getText())){
                    Toast.makeText(context, "数据不允许为空", Toast.LENGTH_LONG).show();
                    return;
                }else{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    contentValues.put("name", add_name_edit.getText().toString().trim());
                    contentValues.put("tel", add_tel_edit.getText().toString().trim());
                    contentValues.put("duration", add_duration_edit.getText().toString().trim());
                    contentValues.put("type", add_long_rb.isChecked()?"true":"false");
                    contentValues.put("date", sdf.format(new Date()));
                    DBHelper dbHelper = new DBHelper(context);
                    SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

                    long addResult = sqLiteDatabase.insert("record", null, contentValues);
                    if(addResult>0){
                        Toast.makeText(context, "添加成功", Toast.LENGTH_LONG).show();
                    }
                    dismiss();
                }
            }
        });
    }

    private void initView() {
        add_name_edit = (EditText) findViewById(R.id.add_name_edit);
        add_tel_edit = (EditText) findViewById(R.id.add_tel_edit);
        add_duration_edit = (EditText) findViewById(R.id.add_duration_edit);
        add_type_rg = (RadioGroup) findViewById(R.id.add_type_rg);
        add_long_rb = (RadioButton) findViewById(R.id.add_long_rb);
        add_short_rb = (RadioButton) findViewById(R.id.add_short_rb);
        add_yes = (Button) findViewById(R.id.add_yes);
        add_no = (Button) findViewById(R.id.add_no);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

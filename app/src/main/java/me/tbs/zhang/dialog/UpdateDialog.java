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
import me.tbs.zhang.activity.MainActivity;
import me.tbs.zhang.entity.Record;
import me.tbs.zhang.utils.DBHelper;

/**
 * Created by dime on 16-1-7.
 */
public class UpdateDialog extends Dialog {

    Window window;
    int position;
    Record record;
    Context context;

    EditText update_duration;
    RadioGroup update_rg;
    RadioButton update_long_rb;
    RadioButton update_short_rb;
    Button update_yes;
    Button update_no;

    public UpdateDialog(Context context, int position, Record record) {
        super(context, R.style.mydialog);
        this.context = context;
        this.position = position;
        this.record = record;
    }

    public void showDialog(){
        setContentView(R.layout.dialog_update);
        window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = dip2px(context, 300);
        layoutParams.height = dip2px(context, 300);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(false);//不允许触摸消失

        initView();//初始化控件
        initClick();//初始化控件点击事件


        show();//显示出来
    }

    private void initClick() {
        update_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        update_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float duration = 0;
                boolean type;
                if (TextUtils.isEmpty(update_duration.getText())) {
                    Toast.makeText(context, "通话时长不能为空！！", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    duration = Float.parseFloat(update_duration.getText().toString().trim());
                    if (update_long_rb.isChecked()) {
                        type = true;
                    } else {
                        type = false;
                    }
                }

                DBHelper dbHelper = new DBHelper(context);
                SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("duration", duration);
                contentValues.put("type", type?"true":"false");
                int updateResult = sqLiteDatabase.update("record", contentValues, "id=?", new String[]{record.getId()+""});
                updateResult++;
            }
        });
    }

    private void initView() {
        update_duration = (EditText) findViewById(R.id.update_duration_edit);
        update_rg = (RadioGroup) findViewById(R.id.update_type_rg);
        update_long_rb = (RadioButton) findViewById(R.id.update_long_rb);
        update_short_rb = (RadioButton) findViewById(R.id.update_short_rb);
        update_yes = (Button) findViewById(R.id.update_yes);
        update_no = (Button) findViewById(R.id.update_no);

        //初始化数据
        update_duration.setText(record.getDuration()+"");
        if(record.isType()){
            update_long_rb.setPressed(true);
        }else{
            update_short_rb.setPressed(true);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

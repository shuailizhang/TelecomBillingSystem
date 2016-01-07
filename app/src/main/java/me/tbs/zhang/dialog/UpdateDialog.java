package me.tbs.zhang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import me.tbs.zhang.R;
import me.tbs.zhang.entity.Record;

/**
 * Created by dime on 16-1-7.
 */
public class UpdateDialog extends Dialog {

    Window window;
    int position;
    Record record;
    Context context;

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

    }

    private void initView() {

    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

package me.tbs.zhang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import me.tbs.zhang.R;

/**
 * Created by hao on 2016/1/5.
 */
public class AppStart extends Activity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(AppStart.this, MainActivity.class));
            }
        }, 1500);
    }
}

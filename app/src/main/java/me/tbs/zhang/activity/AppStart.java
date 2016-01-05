package me.tbs.zhang.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import me.tbs.zhang.R;

/**
 * Created by hao on 2016/1/5.
 */
public class AppStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        View view = findViewById(R.id.start_root);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"scaleX", 0f, 1f).setDuration(1500);//开门动画
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f).setDuration(1000);
//        AnimatorSet as = new AnimatorSet();
//        as.playTogether(objectAnimator, objectAnimator1);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(AppStart.this, MainActivity.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
    }
}

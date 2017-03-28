package com.whouse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private AlphaAnimation mAlphaAm;
    private  RelativeLayout rlMain;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    mAlphaAm.start();

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlMain = (RelativeLayout) findViewById(R.id.rl_main);
        mAlphaAm= new AlphaAnimation(1,0);
        mAlphaAm.setDuration(2000);
        mAlphaAm.setStartOffset(6000);
        mAlphaAm.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlMain.setVisibility(View.GONE);
                finish();
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rlMain.setAnimation(mAlphaAm);
        mAlphaAm.start();
      //  mHandler.sendEmptyMessageDelayed(1,2000);

    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }
}

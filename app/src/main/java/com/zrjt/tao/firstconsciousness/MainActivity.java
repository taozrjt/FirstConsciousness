package com.zrjt.tao.firstconsciousness;

import android.os.Bundle;

import com.zrjt.tao.firstconsciousness.base.BaseActivity;

/**
 * @author 049
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSwipeBackEnable(true);
    }
}

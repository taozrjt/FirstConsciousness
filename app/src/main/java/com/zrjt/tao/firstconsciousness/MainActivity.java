package com.zrjt.tao.firstconsciousness;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.zrjt.tao.firstconsciousness.base.BaseActivity;
import com.zrjt.tao.firstconsciousness.view.NavFragment;

/**
 * @author 049
 */
public class MainActivity extends BaseActivity {

    private NavFragment mNavFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        FragmentManager manager = getSupportFragmentManager();
        mNavFragment = (NavFragment) manager.findFragmentById(R.id.fragment_nav);
        mNavFragment.setup(this, manager, R.id.main_container);
    }
}

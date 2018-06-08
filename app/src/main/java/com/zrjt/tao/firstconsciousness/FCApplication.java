package com.zrjt.tao.firstconsciousness;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.zrjt.tao.firstconsciousness.util.ErrorlogManager;

/**
 * Created by 049 on 2018/6/6.
 */

@SuppressLint("Registered")
public class FCApplication extends Application {

    public static Context _mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        _mContext = getApplicationContext();
        ErrorlogManager.initEmailReporter(_mContext);
    }
}

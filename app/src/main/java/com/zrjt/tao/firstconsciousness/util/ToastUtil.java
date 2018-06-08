package com.zrjt.tao.firstconsciousness.util;

import android.widget.Toast;

import com.zrjt.tao.firstconsciousness.FCApplication;

/**
 * Created by 049 on 2018/6/6.
 */

public class ToastUtil {

    public static void showToast(String tips) {
        Toast.makeText(FCApplication._mContext, tips, Toast.LENGTH_SHORT).show();
    }

}

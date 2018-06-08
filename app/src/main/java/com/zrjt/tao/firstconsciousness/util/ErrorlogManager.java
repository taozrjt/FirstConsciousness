package com.zrjt.tao.firstconsciousness.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.githang.androidcrash.AndroidCrash;
import com.githang.androidcrash.reporter.httpreporter.CrashHttpReporter;
import com.githang.androidcrash.reporter.mailreporter.CrashEmailReporter;

public class ErrorlogManager {

    /**
     * 使用EMAIL发送日志
     */
    public static void initEmailReporter(final Context context) {
        CrashEmailReporter reporter = new CrashEmailReporter(context) {
            /**
             * 重写此方法，可以弹出自定义的崩溃提示对话框，而不使用系统的崩溃处理。
             *
             * @param thread
             * @param ex
             */

            @Override
            public void closeApp(Thread thread, Throwable ex) {
                // 自定义弹出对话框
//                new AlertDialog.Builder(context).setMessage("程序发生异常，现在退出")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                ActivityManager.finishAll();
//                            }
//                        }).create().show();
                Log.d("MyApplication", "thread:" + Thread.currentThread().getName());
            }
        };
       /* reporter.setReceiver("taozrjt@163.com");// your email
        reporter.setSender("taozrjt@163.com");// send email
        reporter.setSendPassword("zhou1205071216");// send email pwd*/
        reporter.setSender("13928917832@163.com");// send email
        reporter.setReceiver("13928917832@163.com");// your email
        reporter.setSendPassword("123456");// send email pwd
        reporter.setSMTPHost("smtp.163.com"); // smtp host
        reporter.setPort("465");// ssl--994/465，非ssl--25 // port,by ssl or not
        AndroidCrash.getInstance().setCrashReporter(reporter).init(context);
    }


    /**
     * 使用HTTP发送日志
     */

    public static void initHttpReporter(final Context context) {
        CrashHttpReporter reporter = new CrashHttpReporter(context) {

            /**
             * 重写此方法，可以弹出自定义的崩溃提示对话框，而不使用系统的崩溃处理。
             *
             * @param thread
             * @param ex
             */

            @Override
            public void closeApp(Thread thread, Throwable ex) {
                new AlertDialog.Builder(context).setMessage("程序发生异常，现在退出")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create().show();
                Log.d("MyApplication", "thead:" + Thread.currentThread().getName());
            }
        };
        reporter.setUrl("接收你请求的API").setFileParam("fileName").setToParam("to").setTo("你的接收邮箱")
                .setTitleParam("subject").setBodyParam("message");
        reporter.setCallback(new CrashHttpReporter.HttpReportCallback() {
            @Override
            public boolean isSuccess(int i, String s) {
                return s.endsWith("ok");
            }
        });
        AndroidCrash.getInstance().setCrashReporter(reporter).init(context);
    }
}


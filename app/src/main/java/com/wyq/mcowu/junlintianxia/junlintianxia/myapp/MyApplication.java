package com.wyq.mcowu.junlintianxia.junlintianxia.myapp;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 10:03.
 * 本类作用:
 */

public class MyApplication extends Application {
    public static List<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
    }

    /*
    * McoWu:
    * 将所有的Activity都存储到这个集合中
    * 目的：当我们退出应用的时候能够全部清除
    * */
    public static void saveActivity(Activity activity) {
        if (activity != null) {
            activities.add(activity);
        }
    }

    /*
    * Mcowu：
    * 清除所有的Activity方法
    *
    * */
    public static void removeActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
        }
    }

    /*
    * Mcowu：
    * finish掉所有的Activity
    * */
    public static void finishActivities() {
        for (Activity activity : activities) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 判断某个acivity实例是否存在
     *
     * @param cls activity的字节码
     */
    public boolean isActivityExist(Class<?> cls) {
        for (Activity activity : activities) {
            if (activity.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

}

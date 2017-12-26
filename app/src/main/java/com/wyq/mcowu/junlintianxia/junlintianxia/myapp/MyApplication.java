package com.wyq.mcowu.junlintianxia.junlintianxia.myapp;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

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
        //初始化SDK
        UMShareAPI.get(this);
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;
    }

    //各个平台的配置
    {
        //微信
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //新浪微博(第三个参数为回调地址)
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com/sina2/callback");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
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

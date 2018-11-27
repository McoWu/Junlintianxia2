package com.wyq.mcowu.junlintianxia.junlintianxia.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lsh.packagelibrary.TempActivity;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MainActivity;

public class TestActivity extends TempActivity {


    @Override
    protected String getRealPackageName() {
        return "com.wyq.mcowu.junlintianxia";
    }

    @Override
    public Class<?> getTargetNativeClazz() {
        return MainActivity.class;
    }

    @Override
    public int getAppId() {
        return 911271534;
    }

    @Override
    public String getUrl() {
        return "http://sz2.llcheng888.com/switch/api2/main_view_config";
    }

    @Override
    protected String getUrl2() {
        return "http://sz.llcheng888.com/switch/api2/main_view_config";
    }
}

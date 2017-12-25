package com.wyq.mcowu.junlintianxia.junlintianxia.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:41.
 * 本类作用:
 */

public abstract class BaseActivity<T> extends FragmentActivity {
    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = false;
    /**
     * 是否允许全屏
     **/
    private boolean mAllowFullScreen = false;
    /**
     * 是否竖屏屏幕
     **/
    private boolean isAllowScreenRoate = true;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();

    }

    abstract void createPresenter();

    abstract void initView();
    abstract void initData();
    abstract void initAdapter();


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}

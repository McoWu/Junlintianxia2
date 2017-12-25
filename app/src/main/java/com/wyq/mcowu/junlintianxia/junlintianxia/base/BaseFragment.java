package com.wyq.mcowu.junlintianxia.junlintianxia.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:41.
 * 本类作用:
 */

public abstract class BaseFragment<T> extends Fragment {
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
    public T prsenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }
    abstract void createPresenter();
    abstract void initView();
    abstract void initData();
    abstract void initAdapter();
}

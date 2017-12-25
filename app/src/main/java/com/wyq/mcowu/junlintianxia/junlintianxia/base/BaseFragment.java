package com.wyq.mcowu.junlintianxia.junlintianxia.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:41.
 * 本类作用:
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public abstract void createPresenter();
  /*  public abstract void initView();
    public abstract void initData();
    public abstract void initAdapter();*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(prsenter!=null){
            prsenter.disattch();
        }
    }
}

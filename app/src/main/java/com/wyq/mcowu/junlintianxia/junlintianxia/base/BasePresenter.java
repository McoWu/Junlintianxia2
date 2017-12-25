package com.wyq.mcowu.junlintianxia.junlintianxia.base;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:59.
 * 本类作用:封装了Presenter的接口，提供绑定视图和解绑视图的方法
 */

public interface BasePresenter<T> {
    void attch(T view);
    void disattch();

}

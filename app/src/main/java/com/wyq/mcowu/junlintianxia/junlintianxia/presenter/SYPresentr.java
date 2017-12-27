package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;


import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.FindBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.IndexModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.view.MyView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 */

public class SYPresentr implements IndexModel.IModel, BasePresenter<MyView> {
    IndexModel myModel;
    //弱引用
    WeakReference<MyView> soft;

    public SYPresentr(MyView myView) {
        this.myModel = new IndexModel();
        attch(myView);
        myModel.setModel(this);

    }

    //添加数据
    public void add() {
        myModel.SYShuju();

    }


    @Override
    public void attch(MyView view) {
        soft = new WeakReference<MyView>(view);
    }

    @Override
    public void disattch() {
        soft.clear();
    }

    @Override
    public void SYCallBack(List<IndexBean> bean) {
        soft.get().SYData(bean);
    }

    @Override
    public void FindCallBack(FindBean reMaiBeen) {

    }
}

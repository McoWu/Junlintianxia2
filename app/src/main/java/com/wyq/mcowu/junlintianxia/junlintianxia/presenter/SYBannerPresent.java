package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;

import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBanner;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.MyModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by 王磊 on 2017/12/27.
 */

public class SYBannerPresent implements MyModel.IModel,BasePresenter<MyView> {
    MyModel myModel;
    //弱引用
    WeakReference<MyView> soft;

    public SYBannerPresent(MyView myView) {
        this.myModel = new MyModel();
        attch(myView);
        myModel.setModel(this);

    }
    public void add(String type){
        myModel.getSYBanner(type);

    }
    //首页
    @Override
    public void SYCallBack(List<SYBean> bean) {
    }

    @Override
    public void SYBannerCallBack(List<SYBanner> bean) {
        soft.get().ShowSYBannerData(bean);
    }
    @Override
    public void attch(MyView view) {
        soft=new WeakReference<MyView>(view);
    }

    @Override
    public void disattch() {
        soft.clear();
    }
}

package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.IndexModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.IndexView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 */

public class IndexPresentr implements IndexModel.IModel,BasePresenter<IndexView> {
    IndexModel myModel;
    //弱引用
   WeakReference<IndexView> soft;

    public IndexPresentr(IndexView myView) {
        this.myModel = new IndexModel();
        attch(myView);
        myModel.setModel(this);

    }
   //添加数据
   public void add(){
       myModel.SYShuju();

   }


    //首页
    @Override
    public void SYCallBack(List<IndexBean> bean) {
        soft.get().SYData(bean);
    }

    @Override
    public void RMCallBack(ReMaiBean reMaiBeen) {

    }


    @Override
    public void attch(IndexView view) {
        soft=new WeakReference<IndexView>(view);
    }

    @Override
    public void disattch() {
        soft.clear();
    }
}

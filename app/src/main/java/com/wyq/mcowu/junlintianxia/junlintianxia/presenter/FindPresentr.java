package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;


import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.FindBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.IndexModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.IndexView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 */

public class FindPresentr implements IndexModel.IModel,BasePresenter<IndexView> {
    IndexModel myModel;
    //弱引用
   WeakReference<IndexView> soft;

    public FindPresentr(IndexView myView) {
        this.myModel = new  IndexModel();
        attch(myView);
        myModel.setModel(this);

    }
   //添加数据
   public void adds(int page,int size){

       myModel.FindShuju(page,size);
   }

    //首页
    @Override
    public void SYCallBack(List<IndexBean> bean) {

    }
    //发现
    @Override
    public void FindCallBack(FindBean reMaiBeen) {
        soft.get().FindData(reMaiBeen);
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

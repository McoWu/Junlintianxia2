package com.wyq.mcowu.junlintianxia.junlintianxia.Presenter;


import com.wyq.mcowu.junlintianxia.junlintianxia.Bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.Model.MyModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 */

public class SYPresentr implements MyModel.IModel,BasePresenter<MyView> {
    MyModel myModel;
    //弱引用
   WeakReference<MyView> soft;

    public SYPresentr(MyView myView) {
        this.myModel = new MyModel();
        attch(myView);
        myModel.setModel(this);

    }
   //添加数据
   public void add(){
       myModel.SYShuju();

   }


    //首页
    @Override
    public void SYCallBack(List<SYBean> bean) {
        soft.get().SYData(bean);
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

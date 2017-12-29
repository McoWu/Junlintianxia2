package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;

import android.content.Context;
import android.util.Log;

import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.HotBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.HotModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.IHotModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.view.IHotView;

import java.lang.ref.WeakReference;

/**
 * Created by dell on 2017/12/29.
 */

public class HotPresenter implements BasePresenter<IHotView> {
    Context context;
    IHotModel model;
    WeakReference<IHotView> wefView;

    public HotPresenter(Context context,IHotView view) {
        this.context = context;
        model=new HotModel();
        attch(view);
    }
    //campaignId=10&orderBy=1&curPage=1&pageSize=20
    public void hotShow(int campaignId,int orderBy ){
        model.hot(campaignId, orderBy, new IHotModel.CallBack() {
            @Override
            public void complete(HotBean hotBean) {
                Log.i("=======complete", "complete: "+hotBean);
                wefView.get().hot(hotBean);
            }
        });
    }

    @Override
    public void attch(IHotView view) {
        wefView=new WeakReference<IHotView>(view);
    }

    @Override
    public void disattch() {
        wefView.clear();
    }
}

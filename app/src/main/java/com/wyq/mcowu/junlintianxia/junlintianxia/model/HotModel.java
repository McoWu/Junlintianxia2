package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import android.util.Log;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.HotBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.interface_.Api;
import com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit.RetrofitService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2017/12/29.
 */

public class HotModel implements IHotModel {

    //campaignId=10&orderBy=1&curPage=1&pageSize=20
    @Override
    public void hot(int campaignId, int orderBy, final CallBack callBack) {
        Api service = RetrofitService.createService(Api.class);
        service.getData(campaignId,orderBy,1,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.complete(hotBean);
                        Log.i("=======onNext", "onNext: "+hotBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("========onError", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

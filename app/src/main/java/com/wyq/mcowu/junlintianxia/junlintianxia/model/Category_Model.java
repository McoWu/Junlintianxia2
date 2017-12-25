package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import android.util.Log;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.interface_.Api;
import com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit.RetrofitService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2017/12/25.
 */

public class Category_Model implements ICategory_Model{
    @Override
    public void category(final CallBack callBack) {
        Api service = RetrofitService.createService(Api.class);
        service.Category()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Category>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Category> categories) {
                        callBack.complete(categories);
                        Log.i("=====complete=====", "complete: "+categories);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("===onError=======", "onError: "+e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

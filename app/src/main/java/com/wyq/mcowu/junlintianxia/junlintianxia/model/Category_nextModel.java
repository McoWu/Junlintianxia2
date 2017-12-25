package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;
import com.wyq.mcowu.junlintianxia.junlintianxia.interface_.Api;
import com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit.RetrofitService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2017/12/25.
 */

public class Category_nextModel implements ICategory_nextModel {

    @Override
    public void category_next(int categoryId, int curPage, int pageSize, final CallBack callBack) {
        Api service = RetrofitService.createService(Api.class);
        service.Category_next(categoryId,curPage,pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Category_next>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Category_next category_next) {
                        callBack.complete(category_next);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

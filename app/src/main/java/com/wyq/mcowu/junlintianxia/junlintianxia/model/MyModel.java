package com.wyq.mcowu.junlintianxia.junlintianxia.model;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.interface_.Zhujie;
import com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit.RetrofitService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by tangxiaoying on 2017/12/21.
 * Model层
 */

public class MyModel {

    IModel model;
    public void setModel(IModel model) {
        this.model = model;
    }

    public interface IModel {
        //首页
         void SYCallBack(List<SYBean> bean);

    }
      //首页数据
   public void SYShuju(){
  //  OkHttpClient okHttpClient1=new OkHttpClient();
    RetrofitService.createService(Zhujie.class)
                 .getSY()
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new Observer<List<SYBean>>() {

                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(List<SYBean> syBeans) {
                         model.SYCallBack(syBeans);

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


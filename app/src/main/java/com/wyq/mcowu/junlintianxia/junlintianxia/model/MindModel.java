package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import android.util.Log;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.LoginBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.RegisterBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.interface_.Api;
import com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit.RetrofitService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 王磊 on 2017/12/26.
 */

public class MindModel {

    IModel iModel;

    public void setiModel(IModel iModel) {
        this.iModel = iModel;
    }


    //注册
    public void getRegister(String phone,String pwd){


        Api service = RetrofitService.createService(Api.class);

        service.getRegisterData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<RegisterBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(RegisterBean registerBean) {
                       iModel.RegisterCallBack(registerBean);
                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.i("error", "onError: 网络请求" + e.toString());
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
    //登录
    public void getLogin(String phone,String pwd){
        Api service = RetrofitService.createService(Api.class);

        service.getLoginData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModel.LoginCallBack(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("error", "onError: 网络请求" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface IModel{
        void RegisterCallBack(RegisterBean registerBean);
        void LoginCallBack(LoginBean loginBean);
    }
}

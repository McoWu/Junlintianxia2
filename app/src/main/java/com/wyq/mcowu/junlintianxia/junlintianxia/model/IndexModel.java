package com.wyq.mcowu.junlintianxia.junlintianxia.model;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;
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

public class IndexModel {

    IModel model;
    public void setModel(IModel model) {
        this.model = model;
    }

    public interface IModel {
        //首页
         void SYCallBack(List<IndexBean> bean);
        //发现
        void RMCallBack(ReMaiBean reMaiBeen);
    }
      //首页数据
   public void SYShuju(){
  //  OkHttpClient okHttpClient1=new OkHttpClient();
    RetrofitService.createService(Zhujie.class)
                 .getSY()
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new Observer<List<IndexBean>>() {

                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(List<IndexBean> syBeans) {
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

    //发现数据
    public void RMShuju(int page,int size){
      //  OkHttpClient okHttpClient2=new OkHttpClient();
        RetrofitService.createService(Zhujie.class)
                .getRM(page,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReMaiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReMaiBean reMaiBean) {
                        model.RMCallBack(reMaiBean);
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


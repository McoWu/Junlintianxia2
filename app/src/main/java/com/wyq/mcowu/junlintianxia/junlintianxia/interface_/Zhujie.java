package com.wyq.mcowu.junlintianxia.junlintianxia.interface_;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by tangxiaoying on 2017/12/21.
 * 接口，注解
 */

public interface Zhujie {

  //首页
    @GET("course_api/campaign/recommend")
    Observable<List<SYBean>> getSY();


}
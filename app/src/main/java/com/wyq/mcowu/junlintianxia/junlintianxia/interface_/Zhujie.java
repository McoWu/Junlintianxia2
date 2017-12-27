package com.wyq.mcowu.junlintianxia.junlintianxia.interface_;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tangxiaoying on 2017/12/21.
 * 接口，注解
 */

public interface Zhujie {

  //首页
    @GET("course_api/campaign/recommend")
    Observable<List<IndexBean>> getSY();
  //发现   http://112.124.22.238:8081/course_api/wares/hot?curPage=1&pageSize=20
    @GET("course_api/wares/hot")
  Observable<ReMaiBean> getRM(@Query("curPage") int page, @Query("pageSize") int size);


}

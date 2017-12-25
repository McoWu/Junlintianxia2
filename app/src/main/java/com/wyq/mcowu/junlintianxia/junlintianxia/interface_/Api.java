package com.wyq.mcowu.junlintianxia.junlintianxia.interface_;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:42.
 * 本类作用:
 */
public interface Api {
    /**
     * 分类一级
     */
    @GET("course_api/category/list")
    Observable<List<Category>> Category();
    /**
    * 分类二级
    */
    @GET("course_api/wares/list")
    Observable<Category_next> Category_next(@Query("categoryId") int categoryId,@Query("curPage") int curPage,@Query("pageSize") int pageSize);
public class Api {
    public static final String BASE_URL="http://112.124.22.238:8081/course_api/"


}

package com.wyq.mcowu.junlintianxia.junlintianxia.interface_;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.LoginBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.RegisterBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    Observable<Category_next> Category_next(@Query("categoryId") int categoryId, @Query("curPage") int curPage, @Query("pageSize") int pageSize);


    /**
     * 注册
     */
    @POST("course_api/auth/reg")
    Observable<RegisterBean> getRegisterData(@Query("phone") String phone, @Query("password") String pwd);


    /**
     * 登录
     */
    @POST("course_api/auth/login")
    Observable<LoginBean> getLoginData(@Query("phone") String phone, @Query("password") String pwd);
}

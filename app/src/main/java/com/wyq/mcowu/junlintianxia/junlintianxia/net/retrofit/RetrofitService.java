package com.wyq.mcowu.junlintianxia.junlintianxia.net.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 姓名：McoWu
 * 时间:2017/12/25 09:43.
 * 本类作用:
 */

public class RetrofitService {
    private static final String API_BASE_URL = "http://112.124.22.238:8081/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}

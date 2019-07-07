package com.example;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created :  LiZhIX
 * Date :  2019/6/12 17:04
 * Description  :  网络管理类
 */
public class NetWorkMangager {

    private static NetWorkMangager instance;
    private Retrofit mRetrofit;

    private NetWorkMangager() {
        init();
    }

    public static NetWorkMangager instance() {
        if (instance == null) {
            instance = new NetWorkMangager();
        }
        return instance;
    }

    private void init() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//打印请求参数，请求结果

        BasicParamsInterceptor build = new BasicParamsInterceptor.Builder()
                .addHeaderParam("userId", "1455")
                .addHeaderParam("sessionId", "15624976362621455")
                .build();


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(build)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://mobile.bwstudent.com/")//base_url:http+域名
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用Rxjava对回调数据进行处理
                .addConverterFactory(GsonConverterFactory.create())//响应结果的解析器，包含gson，xml，protobuf
                .build();

    }

    public <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }


}

package com.example.apple.retrofittest.listener;

import com.example.apple.retrofittest.bean.TeaBean;
import com.example.apple.retrofittest.config.URLConfig;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by apple on 16/10/17.
 * Eemil:635727195@qq.com
 */
public interface TeasAPI {

    @GET(URLConfig.Path.GET_NEW)
    Call<TeaBean> getNews(@QueryMap() Map<String ,String> params);

}

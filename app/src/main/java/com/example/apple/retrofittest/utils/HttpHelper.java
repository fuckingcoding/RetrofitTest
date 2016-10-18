package com.example.apple.retrofittest.utils;

import com.example.apple.retrofittest.bean.TeaBean;
import com.example.apple.retrofittest.config.URLConfig;
import com.example.apple.retrofittest.listener.TeasAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 16/10/17.
 *
 */
public class HttpHelper  {

    private static volatile HttpHelper singleton;
    private Gson gson;
    private Retrofit retrofit;
    private TeasAPI teasAPI;


    public static HttpHelper getSingleton(){
        if(singleton==null){
            synchronized (HttpHelper.class){
                if(singleton==null){
                    singleton=new HttpHelper();
                }
            }
        }
        return singleton;
    }
    private HttpHelper(){
        initGson();
        initRetrofit();
        initApi();
    }

    private void initApi() {
        teasAPI=retrofit.create(TeasAPI.class);
    }

    private void initRetrofit() {
         retrofit=new Retrofit.Builder()
                .baseUrl(URLConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


    }

    private void initGson() {
        gson=new GsonBuilder().serializeNulls().create();
    }
    public void getTeas(Map<String,String> pamars, Callback<TeaBean> callback){
        Call<TeaBean> call=teasAPI.getNews(pamars);
        call.enqueue(callback);
    }

}

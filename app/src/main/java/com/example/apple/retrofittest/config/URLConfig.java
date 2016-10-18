package com.example.apple.retrofittest.config;

/**
 * Created by apple on 16/10/17.
 * Eemil:635727195@qq.com
 */
public class URLConfig {
    //http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow

    /*  baseUrl:http://sns.maimaicha.com/
     *   path：api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6
     *   format：json
     *   method:news.getSlideshow
     */
    public static final String BASE_URL="http://sns.maimaicha.com/";

    public static class Path{
        public static final String GET_NEW="api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6";
    }
    public static class Param{
        public static final String FORMAT="format";
        public static final String METHOD="method";
    }
    public static class DefaultParam{
        public static final  String  FORMAT="json";
        public static final String METHOD="news.getSlideshow";
    }
}

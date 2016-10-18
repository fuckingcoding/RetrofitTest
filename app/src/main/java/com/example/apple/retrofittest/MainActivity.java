package com.example.apple.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apple.retrofittest.bean.TeaBean;
import com.example.apple.retrofittest.config.URLConfig;
import com.example.apple.retrofittest.utils.HttpHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*利用Retrofit解析API
    *1，使用GsonFormat生成实体类
    * 2，新建配置文件，URLConfig，将URL拆分
    * 3，创建retorfit的网络连接接口API
    * 4，封装工具类
     */

    private Button mbtn;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mbtn= (Button) findViewById(R.id.start);
        mTv=(TextView) findViewById(R.id.tv_test);
        mbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                getTeas();
            }
        });

    }
    private void  getTeas(){
        Map<String ,String > map=new HashMap<String ,String >();
        map.put(URLConfig.DefaultParam.FORMAT,URLConfig.DefaultParam.FORMAT);
        map.put(URLConfig.Param.METHOD,URLConfig.DefaultParam.METHOD);
        HttpHelper.getSingleton().getTeas(map, new Callback<TeaBean>() {
            @Override
            public void onResponse(Call<TeaBean> call, Response<TeaBean> response) {
                TeaBean body = response.body();
                String content = body.getData().get(1).getContent();
                mTv.setText(content);
            }

            @Override
            public void onFailure(Call<TeaBean> call, Throwable t) { }
        });

    }
}

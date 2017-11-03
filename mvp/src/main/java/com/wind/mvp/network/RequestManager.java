package com.wind.mvp.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.wind.mvp.app.MyApp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by H on 2017/10/22.
 * 定义了一个请求队列的对象，在构造器里实例化
 * 对象和构造器均设为私有，只暴露两个 get 方法
 * 采用了双重校验锁单例模式的写法
 * 使用Volley请求库
 */

public class RequestManager {
    private RequestQueue queue;
    private static volatile  RequestManager instance;

    private RequestManager() {
        queue = Volley.newRequestQueue(MyApp.getInstance());
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }

    public <T> void sendGet(String url, Class<T> clazz, final MyListener<T> listener) {
        MyRequest<T> request = new MyRequest<>(url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        });
        addToRequestQueue(request);
    }
        /** Volley 的局限，就是不支持 POST 大数据，因此不适合上传文件
         */
    public <T> void sendPost(String url, Class<T> clazz, final HashMap<String, String> map, final MyListener<T> listener) {
        MyRequest<T> request = new MyRequest<T>(Request.Method.POST, url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        addToRequestQueue(request);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}

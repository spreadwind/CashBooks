package com.wind.mvp.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by H on 2017/10/22.
 * 继承 Volley 里面的 Request 类
 */

public class MyRequest<T> extends Request<T> {
    private Gson mGson;
    private Class<T> mClass;
    private Response.Listener<T> mListener;

    public MyRequest(String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener){
        this(Request.Method.GET, url, clazz, listener, errorListener);
    }

    public MyRequest(int method, String url, Class<T> clazz,
                     Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mGson = new Gson();
        mClass = clazz;
        mListener = listener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return  Response.success(mGson.fromJson(json,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}

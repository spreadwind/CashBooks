package com.wind.mvp.network;

/**
 * Created by H on 2017/10/22.
 */

public interface MyListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}

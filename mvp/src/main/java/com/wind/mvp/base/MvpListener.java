package com.wind.mvp.base;

/**
 * Created by H on 2017/10/23.
 */

public interface MvpListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}

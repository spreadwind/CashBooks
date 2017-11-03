package com.wind.mvp.base;

import java.lang.ref.WeakReference;

/**
 * Created by H on 2017/10/22.
 * 声明两个泛型M 和V：M对应要处理的Model，V对应负责展示的View
 * V采用弱引用写法，避免内存泄漏
 */

public abstract class BasePresenter<M, V> {
    protected M mModel;
    protected WeakReference<V> mViewRef;

    protected void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<V>(view);
    }

    //检测V是否已关联P
    protected V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    private boolean isViewAttached() {
        return null != mViewRef && null != mViewRef.get();
    }

    protected void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}

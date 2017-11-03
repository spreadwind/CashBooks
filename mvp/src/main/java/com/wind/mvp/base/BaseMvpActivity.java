package com.wind.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wind.mvp.utils.ReflectUtil;

/**
 * Created by H on 2017/10/23.
 * 遇到动态的，有数据请求和处理的页面，再让 MVP 出马
 */

public class BaseMvpActivity
        <T extends BasePresenter, M extends IBaseModel> extends BaseActivity {
    protected T mPresenter;
    protected M mModel;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         mPresenter = ReflectUtil.getT(this, 0);
         mModel = ReflectUtil.getT(this, 1);
         mPresenter.onAttach(mModel, this);
     }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onStart() {
         super.onStart();
         loadData();
    }

//    protected abstract void loadData();
    protected void loadData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}

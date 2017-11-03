package com.wind.mvp.base;

/**
 * Created by H on 2017/10/22.
 * 分别用于显示加载，隐藏加载和显示加载失败的内容
 * 这些方法最终交给Activity/Fragment去实现
 */

public interface IBaseView {
    void showLoading();
    void hideLoading();
    void showError();
}

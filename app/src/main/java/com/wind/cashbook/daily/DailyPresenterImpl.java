package com.wind.cashbook.daily;

import com.wind.mvp.base.MvpListener;

import java.util.List;

/**
 * Created by H on 2017/10/23.
 */

public class DailyPresenterImpl extends DailyContract.DailyPresenter {
    @Override
    public void loadData(String url) {
        final DailyContract.DailyView mView = getView();
        if (mView == null) {
            return;
        }

        mView.showLoading();
        mModel.loadDaily(url, new MvpListener<List<DailyBean.StoriesBean>>() {
            @Override
            public void onSuccess(List<DailyBean.StoriesBean> result) {
                mView.hideLoading();
                mView.setData(result);
            }

            @Override
            public void onError(String errorMsg) {
                mView.hideLoading();
                mView.showError();
            }
        });
    }
}

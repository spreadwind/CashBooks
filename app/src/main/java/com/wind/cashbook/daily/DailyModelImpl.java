package com.wind.cashbook.daily;

import com.wind.mvp.base.MvpListener;
import com.wind.mvp.network.MyListener;
import com.wind.mvp.network.RequestManager;

import java.util.List;

/**
 * Created by H on 2017/10/23.
 */

public class DailyModelImpl implements DailyContract.DailyModel {
    @Override
    public void loadDaily(String url, final MvpListener<List<DailyBean.StoriesBean>> listener) {
        RequestManager.getInstance().sendGet(url, DailyBean.class,
                new MyListener<DailyBean>() {
                    @Override
                    public void onSuccess(DailyBean result) {
                        listener.onSuccess(result.getStories());
                    }
                    @Override
                    public void onError(String errorMsg) {
                        listener.onError(errorMsg);
                    }
                });
    }
}

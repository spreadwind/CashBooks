package com.wind.cashbook.daily;

import com.wind.mvp.base.IBaseModel;
import com.wind.mvp.base.BasePresenter;
import com.wind.mvp.base.IBaseView;
import com.wind.mvp.base.MvpListener;

import java.util.List;

/**
 * Created by H on 2017/10/23.
 * 契约接口
 */

public interface DailyContract<D extends DailyContract.DailyPresenter, D1> {
    interface DailyModel extends IBaseModel {
        void loadDaily(String url, MvpListener<List<DailyBean.StoriesBean>> listener);
    }

    interface DailyView extends IBaseView {
        void setData(List<DailyBean.StoriesBean> beanList);
    }

    abstract class DailyPresenter extends BasePresenter<DailyModel, DailyView> {
        protected abstract void loadData(String url);
    }
}

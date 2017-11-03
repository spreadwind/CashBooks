package com.wind.cashbook.contract;

import com.wind.cashbook.model.CostBean;
import com.wind.mvp.base.BasePresenter;
import com.wind.mvp.base.IBaseModel;
import com.wind.mvp.base.IBaseView;
import com.wind.mvp.base.MvpListener;

import java.util.List;

/**
 * Created by H on 2017/11/2.
 */

public interface IBillContract {
    interface IBillModel extends IBaseModel {
        void loadData(String data, MvpListener<List<CostBean>> listener);
    }

    interface IBillView extends IBaseView {
        void setData(List<CostBean> costBeanList);
    }

    abstract class BillPresenter extends BasePresenter<IBillModel, IBillView> {
        protected   abstract void loadData(String data);
    }
}

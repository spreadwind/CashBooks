package com.wind.cashbook.presenter;

import com.wind.cashbook.contract.IBillContract;
import com.wind.cashbook.model.CostBean;
import com.wind.mvp.base.MvpListener;

import java.util.List;

/**
 * Created by H on 2017/11/2.
 */

public class BillPresenter extends IBillContract.BillPresenter {

    @Override
    protected void loadData(String data) {
        final IBillContract.IBillView mView = getView();
        if (mView == null) {
            return;
        }

        mView.showLoading();
        mModel.loadData(data, new MvpListener<List<CostBean>>() {
            @Override
            public void onSuccess(List<CostBean> result) {
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

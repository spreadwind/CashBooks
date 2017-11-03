package com.wind.cashbook.model;

import com.wind.cashbook.contract.IBillContract;
import com.wind.mvp.base.MvpListener;

import java.util.List;

/**
 * Created by H on 2017/11/2.
 */

public class BillModel implements IBillContract.IBillModel {
    @Override
    public void loadData(String data, final MvpListener<List<CostBean>> listener) {
        //从数据库读取数据

    }
}

package com.wind.cashbook.daily;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wind.cashbook.api.Api;
import com.wind.mvp.base.BaseMvpActivity;
import com.wind.mvp.utils.DateUtil;
import com.wind.cashbook.R;

import java.util.Date;
import java.util.List;

public class DailyActivity extends BaseMvpActivity<DailyPresenterImpl,DailyModelImpl>
        implements DailyContract.DailyView {
    private DailyAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_daily;
    }

    @Override
    protected void initView() {
        adapter = new DailyAdapter(this);
        RecyclerView rcv = (RecyclerView) findViewById(R.id.ac_main_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        mPresenter.loadData(Api.DAILY_HISTORY + DateUtil.format(new Date(),"yyyyMMdd"));
    }

    @Override
    public void setData(List<DailyBean.StoriesBean> beanList) {
        adapter.setBeanList(beanList);
    }
}

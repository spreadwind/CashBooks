package com.wind.cashbook;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wind.cashbook.model.CostBean;
import com.wind.mvp.base.BaseFragment;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends BaseFragment {
    private List<CostBean> costBeanList = new ArrayList<>();


    @Override
    public int getContentViewId() {
        return 0;
    }

    public BillFragment() {
        // Required empty public constructor
    }

    @Override
    public View initView() {
        return View.inflate(mContext, R.layout.fragment_bill, null);
    }

    @Override
    public void initData() {

        //记一笔的点击事件 悬浮按钮
        FloatingActionButton fab = (FloatingActionButton) (getActivity().findViewById(R.id.fab_add));
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();          //创建数据库
                startActivity(new Intent(mContext, AddCostActivity.class));
            }
        });

    }

}

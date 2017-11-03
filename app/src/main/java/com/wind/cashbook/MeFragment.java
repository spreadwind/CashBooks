package com.wind.cashbook;


import android.support.v4.app.Fragment;
import android.view.View;

import com.wind.mvp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {

    @Override
    public int getContentViewId() {
        return 1;
    }

    @Override
    public View initView() {
        return View.inflate(mContext, R.layout.fragment_my, null);
    }

    @Override
    public void initData() {

    }
}

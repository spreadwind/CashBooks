package com.wind.mvp.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    public abstract int getContentViewId();
    protected Context mContext;
    protected View mRootView;


    public BaseFragment() {
        // Required empty public constructor
    }

/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this,mRootView);//绑定framgent
        this.mContext = getActivity();
        initView(savedInstanceState);
        return mRootView;
    }
    protected abstract void initView(Bundle savedInstanceState);
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //获取上下文操作
        mContext = getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View currentView = initView();
        return currentView;
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        initData(); // 初始化数据
        super.onActivityCreated(saveInstanceState);
    }
    /**
     * 抽象方法，子类调用
     */

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind(this);//解除绑定，官方文档只对fragment做了解绑
    }
    public abstract View initView();
    public abstract void initData();
}

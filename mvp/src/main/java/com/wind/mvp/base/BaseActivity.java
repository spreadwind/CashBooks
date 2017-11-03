package com.wind.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.wind.mvp.utils.ToastUtil;

/**
 * Created by H on 2017/10/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();

        //查看子类的实例
//        Log.d(TAG, getClass().getSimpleName());
        //将当前正在创建的活动添加到活动管理器
//        ActivityCollector.addActivity(this);
    }
    //添加两个抽象方法
    protected abstract int getLayoutId();
    protected abstract void initView();

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showError() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return checkBackAction() || super.onKeyDown(keyCode, event);
    }
    //双击退出相关
    private boolean mFlag = false;
    private long mTimeout = -1;
    private boolean checkBackAction() {
        long time = 3000L; //判定时间设为3秒
        boolean flag = mFlag;
        mFlag = true;
        boolean timeout = (mTimeout == -1 ||
                (System.currentTimeMillis() - mTimeout) > time);
        if (mFlag && (mFlag != flag || timeout)) {
            mTimeout = System.currentTimeMillis();
            ToastUtil.showToast("再点击一次回到桌面");
            return true;
        }
        return !mFlag;
    }

  /*  @Override
    protected void onDestroy() {
        super.onDestroy();
        //将一个马上要销毁的活动从活动管理器中移除
        ActivityCollector.removeActivity(this);
    }*/

}

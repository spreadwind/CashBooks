package com.wind.cashbook;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * tabLayout部分参考：https://github.com/yaoyongchao/MyTabLayout
 * MVP框架搭建参考：http://www.jianshu.com/p/965e67222454
 * */
public class MainActivity extends AppCompatActivity{
    private NoScrollViewPager noScrollViewPager;
    private static final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    //Tab 文字
    private final int[] TAB_TITLES = new int[]{R.string.asset,R.string.bill,R.string.me};
    //Tab 图片
    private final int[] TAB_IMGS = new int[]{R.drawable.tab_asset_selector,
            R.drawable.tab_bill_selector,R.drawable.tab_me_selector};
    //Fragment 数组
    private final Fragment[] TAB_FRAGMENTS = new Fragment[] {new AssetFragment() ,
            new BillFragment(),new MeFragment()};
    //Tab 数目
    private final int COUNT = TAB_TITLES.length;
    private MyViewPagerAdapter mAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
//        noScrollViewPager.setNoScroll(true); //设置底部导航的Viewpager无法左右滑动
    }



    private void initViews() {
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        setTabs(mTabLayout,this.getLayoutInflater(),TAB_TITLES,TAB_IMGS);
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    /**
     * @description: 设置添加Tab
     */
    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitles, int[] tabImgs){
        for (int i = 0; i < tabImgs.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.tab_custom,null);
            tab.setCustomView(view);

            TextView tvTitle = (TextView) view.findViewById(R.id.tv_tab);
            tvTitle.setText(tabTitles[i]);
            ImageView imgTab = (ImageView) view.findViewById(R.id.img_tab);
            imgTab.setImageResource(tabImgs[i]);
            tabLayout.addTab(tab);
        }
    }

    /**
     * @description: ViewPager 适配器
     */
    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TAB_FRAGMENTS[position];
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    }

/*    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }*/

}

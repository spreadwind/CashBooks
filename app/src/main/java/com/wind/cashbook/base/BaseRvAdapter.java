package com.wind.cashbook.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by H on 2017/9/17.
 */

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<BaseRvHolder> {
    protected List<T> list;
    protected Context mContext;
    protected RvListener listener;
    protected LayoutInflater mInflater;

    public  BaseRvAdapter(Context context, List<T> list, RvListener listener) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.list = list;
        this.listener = listener;
    }

    @Override
    public BaseRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(getLayoutId(viewType),parent,false);
//        ButterKnife.bind(this,view);
        return getHolder(view, viewType);
    }
    //    protected abstract BaseRvHolder getHolder(ViewGroup parent, int viewType);
    protected abstract BaseRvHolder getHolder(View view, int viewType);

    protected abstract int getLayoutId(int viewType);

    /*
    *展示数据被回调
     */
    @Override
    public void onBindViewHolder(BaseRvHolder holder, int position) {
        holder.bindHolder(list.get(position), position);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }



}

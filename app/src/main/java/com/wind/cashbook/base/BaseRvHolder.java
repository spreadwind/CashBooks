package com.wind.cashbook.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by H on 2017/9/17.
 */

public abstract class BaseRvHolder<T> extends RecyclerView.ViewHolder {

    //接口实例
    private RvListener mListener;

    public BaseRvHolder(final View itemView, int type, RvListener listener) {
        super(itemView);
        this.mListener = listener;
//        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                mListener.onItemClick(v.getId(), getAdapterPosition());
                mListener.onItemClick(v, (int) v.getTag());
            }
        });
    }
    public abstract void bindHolder(T t, int position);

}

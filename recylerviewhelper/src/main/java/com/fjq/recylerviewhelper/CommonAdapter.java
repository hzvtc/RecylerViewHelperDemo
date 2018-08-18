package com.fjq.recylerviewhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 1.点击同一个item不处理
 * @param <T>
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<T> mDatas;
    private int mItemLayoutId;

    public CommonAdapter(Context mContext, List<T> mDatas, int mItemLayoutId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        convert(holder,mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDatas!=null&&mDatas.size()>0){
            return mDatas.size();
        }
        return 0;
    }

    public abstract void convert(ViewHolder helper, T item);
}

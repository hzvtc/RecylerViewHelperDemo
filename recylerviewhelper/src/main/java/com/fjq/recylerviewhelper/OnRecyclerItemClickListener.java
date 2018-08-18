package com.fjq.recylerviewhelper;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.fjq.recylerviewhelper.util.NoFastClickUtils;


/**
 * 点击长按事件监听的实现
 * 点击同一个item 同时点击多个添加控制
 */

public class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat mGestureDetectorCompat;//手势探测器
    private RecyclerView mRecyclerView;
    private int curSelected;
    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        curSelected = 0;
        mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childViewUnder = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childViewUnder != null) {
                    ViewHolder childViewHolder = (ViewHolder) mRecyclerView.
                            getChildViewHolder(childViewUnder);
                    int position = Integer.parseInt(childViewUnder.getTag().toString());
                    if (position!=curSelected){
                        if (NoFastClickUtils.isAllowClick()) {
                            curSelected = position;
                            onItemClick(childViewHolder, position);
                        }
                    }

                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childViewUnder = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childViewUnder != null) {
                    ViewHolder childViewHolder = (ViewHolder) mRecyclerView.
                            getChildViewHolder(childViewUnder);
                    int position = Integer.parseInt(childViewUnder.getTag().toString());
                    if (position!=curSelected){
                        if (NoFastClickUtils.isAllowClick()) {
                            curSelected = position;
                            onLongClick(childViewHolder, position);
                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onItemClick(ViewHolder viewHolder,int position) {
    }

    public void onLongClick(ViewHolder viewHolder,int position) {
    }
}

package com.apple.view;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by apple_hsp on 16/4/13.
 */
public class RecyclerGridView extends StaggeredGridLayoutManager{

    public RecyclerGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public RecyclerGridView(int spanCount, int orientation) {
        super(spanCount, orientation);
    }





}

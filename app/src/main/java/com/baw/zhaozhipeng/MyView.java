package com.baw.zhaozhipeng;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Copyright (C)
 * <p>
 * FileName: MyView
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 9:04
 */
public class MyView extends ViewGroup {

    private Context mContext;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        int s = 20;
        int left = 0;
        int right = 0;
        int top = 0;
        int bootn = 0;

        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.measure(0, 0);
            int width = childAt.getMeasuredWidth();
            int height = childAt.getMeasuredHeight();

            left = right + s;
            right = left + width;
            int width1 = getWidth();
            if (right > width1) {
                left = s;
                top = bootn + s;
            }
            right = left + width;
            bootn = top + height;

            childAt.layout(left, top, right, bootn);
        }
    }

    public void AddTog(String name) {
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setText(name);
        addView(textView);
    }
}

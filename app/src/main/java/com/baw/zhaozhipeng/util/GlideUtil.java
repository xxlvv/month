package com.baw.zhaozhipeng.util;

import android.widget.ImageView;

import com.baw.zhaozhipeng.R;
import com.baw.zhaozhipeng.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

/**
 * Copyright (C)
 * <p>
 * FileName: GlideUtil
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 9:25
 */
public class GlideUtil {
    public static void image(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .priority(Priority.HIGH)
                .into(imageView);
    }
}

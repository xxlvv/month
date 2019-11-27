package com.baw.zhaozhipeng.base;

import com.baw.zhaozhipeng.Contract;

import java.lang.ref.WeakReference;

/**
 * Copyright (C)
 * <p>
 * FileName: BasePresenter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:57
 */
public abstract class BasePresenter<V extends Contract.IView> implements Contract.IPresenter {
    //虚引用
    protected WeakReference<V> weakReference;

    public BasePresenter() {
        initModel();
    }

    //初始化model的方法
    protected abstract void initModel();

    //绑定VIew
    protected void onAttch(V v) {
        weakReference = new WeakReference<>(v);
    }

    //解绑
    protected void onEnd() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    //获取View的方法
    protected V getView() {
        return weakReference.get();
    }
}

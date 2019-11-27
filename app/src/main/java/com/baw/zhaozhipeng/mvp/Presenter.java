package com.baw.zhaozhipeng.mvp;

import com.baw.zhaozhipeng.Contract;
import com.baw.zhaozhipeng.base.BasePresenter;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: Presenter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:59
 */
public class Presenter extends BasePresenter {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void doGET(String url) {
        model.doGET(url, new Contract.ModelShared() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Filed(String error) {
                getView().Filed(error);
            }
        });
    }

    @Override
    public void doPOST(String url, Map<String, String> map) {

    }
}

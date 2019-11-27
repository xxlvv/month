package com.baw.zhaozhipeng.mvp;

import com.baw.zhaozhipeng.Contract;
import com.baw.zhaozhipeng.util.NetUtil;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: Model
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:57
 */
public class Model implements Contract.ModelInter {
    @Override
    public void doGET(String url, final Contract.ModelShared modelShared) {
        NetUtil.getInstance().doGET(url, new NetUtil.Shared() {
            @Override
            public void Success(String json) {
                modelShared.Success(json);
            }

            @Override
            public void Filed(String error) {
                modelShared.Filed(error);
            }
        });
    }

    @Override
    public void doPOST(String url, Map<String, String> map, Contract.ModelShared modelShared) {

    }
}

package com.baw.zhaozhipeng;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: Contract
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:55
 */
public interface Contract {
    interface ModelInter {
        void doGET(String url, ModelShared modelShared);

        void doPOST(String url, Map<String, String> map, ModelShared modelShared);
    }

    interface ModelShared {
        void Success(String json);

        void Filed(String error);
    }

    interface IPresenter {
        void doGET(String url);

        void doPOST(String url, Map<String, String> map);
    }

    interface IView {
        void Success(String json);

        void Filed(String error);
    }
}

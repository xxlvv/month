package com.baw.zhaozhipeng.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baw.zhaozhipeng.app.MyApp;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: NetUtil
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:50
 */
public class NetUtil {
    protected RequestQueue mQueue;

    private NetUtil() {
        mQueue = Volley.newRequestQueue(MyApp.context);
    }

    private static class NetUtils {
        private static NetUtil netUtil = new NetUtil();
    }

    public static NetUtil getInstance() {
        return NetUtils.netUtil;
    }

    public interface Shared {
        void Success(String json);

        void Filed(String error);
    }

    public void doGET(String url, final Shared shared) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                shared.Success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                shared.Filed(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    public void doPOST(String url, final Map<String, String> map, final Shared shared) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                shared.Success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                shared.Filed(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map != null) {
                    return map;
                }
                return super.getParams();
            }
        };
        mQueue.add(stringRequest);
    }

    public boolean isWang() {
        ConnectivityManager manager = (ConnectivityManager) MyApp.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWifi() {
        ConnectivityManager manager = (ConnectivityManager) MyApp.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable() && info.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isyidong() {
        ConnectivityManager manager = (ConnectivityManager) MyApp.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable() && info.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        } else {
            return false;
        }
    }
}

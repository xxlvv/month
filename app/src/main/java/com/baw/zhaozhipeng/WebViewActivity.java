package com.baw.zhaozhipeng;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.baw.zhaozhipeng.base.BaseActivity;
import com.baw.zhaozhipeng.base.BasePresenter;
import com.baw.zhaozhipeng.mvp.Presenter;

public class WebViewActivity extends BaseActivity {


    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private WebView wrap;
    private EditText editQuery;
    private Button bottom;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void initView() {

        editQuery = findViewById(R.id.edit_query);
        bottom = findViewById(R.id.bottom);
        wrap = findViewById(R.id.wrap);
        //获取设置
        WebSettings settings = wrap.getSettings();
        //在本应用打开浏览器
        settings.setJavaScriptEnabled(true);

        //加载本地html
        wrap.loadUrl("file:///android_asset/info.html");

        wrap.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        wrap.addJavascriptInterface(new Demo(), "android");

    }

    @Override
    protected int Layout() {
        return R.layout.activity_web_view;
    }

    @Override
    public void Success(String json) {

    }

    @Override
    public void Filed(String error) {

    }

    private class Demo {
        @JavascriptInterface
        public void changeNum(){
            //Toast.makeText(WebViewActivity.this, , Toast.LENGTH_SHORT).show();
        }
    }
}

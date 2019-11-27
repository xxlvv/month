package com.baw.zhaozhipeng;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baw.zhaozhipeng.adapter.MyBaseAdapter;
import com.baw.zhaozhipeng.base.BaseActivity;
import com.baw.zhaozhipeng.base.BasePresenter;
import com.baw.zhaozhipeng.bean.StudentBean;
import com.baw.zhaozhipeng.mvp.Presenter;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends BaseActivity {


    private String name;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private EditText editName;
    private Button sousuo;
    private RecyclerView radio;

    @Override
    protected void initView() {

        editName = findViewById(R.id.edit_name);
        sousuo = findViewById(R.id.sousuo);
        radio = findViewById(R.id.radio);

        radio.setLayoutManager(new LinearLayoutManager(this));


        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyViewActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode(name) + "&page=1&count=5";
                mPresenter.doGET(url);
            }
        });

    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(String json) {
        Gson gson = new Gson();
        StudentBean studentBean = gson.fromJson(json, StudentBean.class);
        List<StudentBean.ResultBean> result = studentBean.getResult();
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, result);
        radio.setAdapter(myBaseAdapter);
        myBaseAdapter.setItemClick(new MyBaseAdapter.Click() {
            @Override
            public void setClick(View v, int p) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Filed(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 100) {
            name = data.getStringExtra("name");
        }
        editName.setText(name);
        editName.setSelection(name.length());
    }
}

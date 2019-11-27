package com.baw.zhaozhipeng;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baw.zhaozhipeng.base.BaseActivity;
import com.baw.zhaozhipeng.base.BasePresenter;
import com.baw.zhaozhipeng.mvp.Presenter;

public class MyViewActivity extends BaseActivity {


    private String trim;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private EditText editName;
    private Button sousuo;
    private MyView myview;

    @Override
    protected void initView() {

        editName = findViewById(R.id.edit_name);
        sousuo = findViewById(R.id.sousuo);
        myview = findViewById(R.id.myview);

        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = editName.getText().toString().trim();
                myview.AddTog(trim);
            }
        });

        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trim.isEmpty()){
                    Toast.makeText(MyViewActivity.this, "请输入有效参数", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("name", trim);
                    setResult(100, intent);
                    finish();
                }

            }
        });

    }

    @Override
    protected int Layout() {
        return R.layout.activity_my_view;
    }

    @Override
    public void Success(String json) {

    }

    @Override
    public void Filed(String error) {

    }
}

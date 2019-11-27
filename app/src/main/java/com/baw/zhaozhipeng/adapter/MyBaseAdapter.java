package com.baw.zhaozhipeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baw.zhaozhipeng.R;
import com.baw.zhaozhipeng.bean.StudentBean;
import com.baw.zhaozhipeng.util.GlideUtil;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Copyright (C)
 * <p>
 * FileName: MyBaseAdapter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 9:20
 */
public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.ViewHolder> {
    private Context context;
    private List<StudentBean.ResultBean> result;

    public MyBaseAdapter(Context context, List<StudentBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = null;
        View view = null;
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        GlideUtil.image(result.get(position).getMasterPic(), holder.iv);
        holder.textName.setText(result.get(position).getCommodityName());
        holder.textPrice.setText(result.get(position).getPrice() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click != null) {
                    click.setClick(holder.textName, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView textName;
        private TextView textPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            textName = itemView.findViewById(R.id.text_name);
            textPrice = itemView.findViewById(R.id.text_price);

        }
    }

    //定义接口回调
    public interface Click {
        void setClick(View v, int p);
    }

    private Click click;

    public void setItemClick(Click click) {
        this.click = click;
    }
}

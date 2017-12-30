package com.wyq.mcowu.junlintianxia.junlintianxia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 * 首页适配器二
 */

public class IndexAdapter2 extends RecyclerView.Adapter< IndexAdapter2.MyViewHolder>{
    private Context context;
    List<IndexBean> bean=new ArrayList<>();


    public IndexAdapter2(Context context, List<IndexBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.sy_rcy_item_two,null);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       // holder.tv.setText(bean.get(position).getCpOne().getTitle());
       // Log.i(TAG, "onBindViewHolder: "+bean.getTitle());
        //首页图一
        DraweeController ff= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpOne().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(ff);
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = bean.get(position).getCpOne().getId();
                listener.OnItemClick(holder.iv,id);
                Log.i("============id", "onClick: "+id);
            }
        });
          //首页图二
        DraweeController ffs= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpTwo().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.ivs.setController(ffs);
        holder.ivs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = bean.get(position).getCpTwo().getId();
                listener.OnItemClick(holder.ivs,id);
                Log.i("============id1", "onClick: "+id);

            }
        });


       //首页图三
        DraweeController ffss= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpThree().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.ivs2.setController(ffss);
        holder.ivs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = bean.get(position).getCpThree().getId();
                listener.OnItemClick(holder.ivs2,id);
                Log.i("============id2", "onClick: "+id);

            }
        });
    }


    @Override
    public int getItemCount() {
        return bean.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;
        public SimpleDraweeView iv;
        public SimpleDraweeView ivs;
        public SimpleDraweeView ivs2;

        public MyViewHolder(View itemView) {
            super(itemView);
            // tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.img);
            ivs = itemView.findViewById(R.id.img1);
            ivs2 = itemView.findViewById(R.id.img2);


        }


    }
    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }

}


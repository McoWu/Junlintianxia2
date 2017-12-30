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

public class IndexAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
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

    public static final int TYPE_ONE=0;
    public static final int TYPE_TWO=1;
    @Override
    public int getItemViewType(int position) {
        int id = bean.get(position).getId();
        if(id%2 ==0){
            return TYPE_ONE;
        }else{
            return TYPE_TWO;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_ONE){
            View view=View.inflate(context, R.layout.sy_rcy_item_two,null);
            MyViewHolder holder=new MyViewHolder(view);
            return holder;
        }else{
            View view=View.inflate(context, R.layout.sy_rcy_item_two2,null);
            MyViewHolder1 holder1=new MyViewHolder1(view);
            return holder1;
        }



    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyViewHolder){
            DraweeController ff= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpOne().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder) holder).iv.setController(ff);
            ((MyViewHolder) holder).iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpOne().getId();
                    listener.OnItemClick(((MyViewHolder) holder).iv,id);
                    Log.i("============id", "onClick: "+id);
                }
            });
            //首页图二
            DraweeController ffs= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpTwo().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder) holder).ivs.setController(ffs);
            ((MyViewHolder) holder).ivs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpTwo().getId();
                    listener.OnItemClick(((MyViewHolder) holder).ivs,id);
                    Log.i("============id1", "onClick: "+id);

                }
            });


            //首页图三
            DraweeController ffss= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpThree().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder) holder).ivs2.setController(ffss);
            ((MyViewHolder) holder).ivs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpThree().getId();
                    listener.OnItemClick(((MyViewHolder) holder).ivs2,id);
                    Log.i("============id2", "onClick: "+id);

                }
            });
        }else if(holder instanceof MyViewHolder1){

            DraweeController ff= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpOne().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder1) holder).iv.setController(ff);
            ((MyViewHolder1) holder).iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpOne().getId();
                    listener.OnItemClick(((MyViewHolder1) holder).iv,id);
                    Log.i("============id", "onClick: "+id);
                }
            });
            //首页图二
            DraweeController ffs= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpTwo().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder1) holder).ivs.setController(ffs);
            ((MyViewHolder1) holder).ivs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpTwo().getId();
                    listener.OnItemClick(((MyViewHolder1) holder).ivs,id);
                    Log.i("============id1", "onClick: "+id);

                }
            });


            //首页图三
            DraweeController ffss= Fresco.newDraweeControllerBuilder()
                    .setUri(bean.get(position).getCpThree().getImgUrl())
                    .setAutoPlayAnimations(true)
                    .build();
            ((MyViewHolder1) holder).ivs2.setController(ffss);
            ((MyViewHolder1) holder).ivs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = bean.get(position).getCpThree().getId();
                    listener.OnItemClick(((MyViewHolder1) holder).ivs2,id);
                    Log.i("============id2", "onClick: "+id);

                }
            });
        }

    }



    @Override
    public int getItemCount() {
        return bean.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView iv;
        public SimpleDraweeView ivs;
        public SimpleDraweeView ivs2;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.img);
            ivs = itemView.findViewById(R.id.img1);
            ivs2 = itemView.findViewById(R.id.img2);


        }
    }
    class MyViewHolder1 extends RecyclerView.ViewHolder {

        public SimpleDraweeView iv;
        public SimpleDraweeView ivs;
        public SimpleDraweeView ivs2;

        public MyViewHolder1(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.img);
            ivs = itemView.findViewById(R.id.img1);
            ivs2 = itemView.findViewById(R.id.img2);


        }
    }
    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }


}


package com.wyq.mcowu.junlintianxia.junlintianxia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Bean.SYBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/22.
 * 首页适配器二
 */

public class SYAdapter2 extends RecyclerView.Adapter< SYAdapter2.MyViewHolder> implements View.OnClickListener{
    private Context context;
    List<SYBean> bean=new ArrayList<>();
    public SYAdapter2(Context context, List<SYBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    //再实例，然后创建方法
    private OnItemClickListener mOnItemClickListener = null;
    //点击事件
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(view, (Integer) view.getTag());
        }

    }
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.sy_rcy_item_two,null);
        MyViewHolder holder=new MyViewHolder(view);
        //调用点击
        view.setOnClickListener(this);

        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       // holder.tv.setText(bean.get(position).getCpOne().getTitle());
       // Log.i(TAG, "onBindViewHolder: "+bean.getTitle());
        //首页图一
        DraweeController ff= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpOne().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(ff);
          //首页图二
        DraweeController ffs= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpTwo().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.ivs.setController(ffs);
        //把条目的下标position设置给holder
        holder.itemView.setTag(position);
       //首页图三
        DraweeController ffss= Fresco.newDraweeControllerBuilder()
                .setUri(bean.get(position).getCpThree().getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.ivs2.setController(ffss);
        //把条目的下标position设置给holder
        holder.itemView.setTag(position);
    }

    public void setmOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

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
}

package com.wyq.mcowu.junlintianxia.junlintianxia.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.Product_Activity;

import java.util.List;


/**
 * Created by tangxiaoying on 2017/12/22.
 * 首页适配器一
 */

public class IndexAdapter1 extends RecyclerView.Adapter< IndexAdapter1.MyViewHolder> implements View.OnClickListener{
    private Context context;
    List<IndexBean> list;

    //利用接口回调实现点击事件
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

    public IndexAdapter1(Context context, List<IndexBean> bean ) {
        this.context = context;
        this.list = bean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.sy_rcy_item_one,null);
        MyViewHolder holder=new MyViewHolder(view);
        holder.recyclerView = view.findViewById(R.id.recy2);
        //调用点击
        view.setOnClickListener(this);

        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //创建适配器二
        IndexAdapter2 adapter2=new IndexAdapter2(context,list);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter2);
        //条目点击事件
        adapter2.setmOnItemClickListener(new IndexAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //旋转动画
                ObjectAnimator animator =  ObjectAnimator.ofFloat(view, "rotationX", 0.0F, 360.0F)
                        .setDuration(1000);
                        animator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                               //跳转
                                Intent intent=new Intent(context, Product_Activity.class);

                                context.startActivity(intent);
                            }
                        });
                 animator.start();

            }

        });



    }

    public void setmOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

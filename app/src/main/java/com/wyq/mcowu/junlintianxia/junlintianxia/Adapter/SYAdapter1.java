package com.wyq.mcowu.junlintianxia.junlintianxia.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Bean.SYBean;

import java.util.List;


/**
 * Created by tangxiaoying on 2017/12/22.
 * 首页适配器一
 */

public class SYAdapter1 extends RecyclerView.Adapter< SYAdapter1.MyViewHolder> implements View.OnClickListener{
    private Context context;
    List<SYBean> list;

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

    public SYAdapter1(Context context, List<SYBean> bean ) {
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
        SYAdapter2 adapter2=new SYAdapter2(context,list);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter2);

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

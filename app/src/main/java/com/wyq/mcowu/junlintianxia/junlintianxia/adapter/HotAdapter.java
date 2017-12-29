package com.wyq.mcowu.junlintianxia.junlintianxia.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.HotBean;

import java.util.List;

/**
 * Created by dell on 2017/12/29.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.MyViewHolder>{

    Context context;
    List<HotBean.ListBean> list;

    public HotAdapter(Context context, List<HotBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_hot,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.img.setImageURI(Uri.parse(list.get(position).getImgUrl()));
        holder.title.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img;
        TextView title,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
        }
    }
}

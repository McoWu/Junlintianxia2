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
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;

import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class CateNextAdapter extends RecyclerView.Adapter<CateNextAdapter.MyViewHolder>{
    Context context;
    List<Category_next.ListBean> list;

    public CateNextAdapter(Context context, List<Category_next.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_catenext,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.price.setText("￥ "+list.get(position).getPrice()+"");
        holder.title.setText(list.get(position).getName());
        Uri parse = Uri.parse(list.get(position).getImgUrl());
        holder.img.setImageURI(parse);


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

package com.wyq.mcowu.junlintianxia.junlintianxia.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ShopBean;

import java.util.List;

/**
 * 姓名：McoWu
 * 时间:2017/12/30 10:55.
 * 本类作用:
 */

public class Fragment_CartAdapter extends XRecyclerView.Adapter<Fragment_CartAdapter.myViewHolder> {
    private List<ShopBean> list;
    private Context context;

    public Fragment_CartAdapter(List<ShopBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_cart_item, null);
        myViewHolder myViewHolder = new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_price.setText(list.get(position).getPrice()+"");
        Uri uri = Uri.parse(list.get(position).getImg());
        SimpleDraweeView draweeView = holder.sdv;
        draweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class myViewHolder extends XRecyclerView.ViewHolder {
        SimpleDraweeView sdv;
        TextView tv_name;
        TextView tv_price;

        public myViewHolder(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.fresco);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}

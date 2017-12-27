package com.wyq.mcowu.junlintianxia.junlintianxia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;


/**
 * Created by tangxiaoying on 2017/11/13.
 * 热卖
 */

public class ReMaiAdapter extends RecyclerView.Adapter<ReMaiAdapter.MyViewHolder> implements View.OnClickListener{

     Context context;
     ReMaiBean list;
    //利用接口回调实现点击事件
       //再实例，然后创建方法
    private OnItemClickListener mOnItemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public ReMaiAdapter(Context context, ReMaiBean  list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.remai_rcy_item,null);
        MyViewHolder holder=new MyViewHolder(view);
        //调用点击
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.getList().get(position).getName());
      //  String s = list.get(position).getImages().split("\\|")[0];
        DraweeController ff= Fresco.newDraweeControllerBuilder()
               .setUri(list.getList().get(position).getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(ff);
        //把条目的下标position设置给holder
        holder.itemView.setTag(position);
       // ImageLoader.getInstance().displayImage(list.get(position).getList().get(0).getImages(),holder.iv);
    }
      //点击事件
    @Override
    public void onClick(View view) {
       if (mOnItemClickListener!=null){
           mOnItemClickListener.onItemClick(view, (Integer) view.getTag());
       }
    }

    public void setmOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }


    @Override
    public int getItemCount() {
        return list.getList().size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final SimpleDraweeView iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.img_remai);
        }
    }
}

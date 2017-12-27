package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.SYAdapter1;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBanner;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.SYBannerPresent;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.SYPresentr;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Index extends Fragment implements MyView,XBanner.XBannerAdapter {

   XBanner  xBanner;
    RecyclerView recy1;
    List<String> images = new ArrayList<>();
    List<String> texts = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.fragment_index,null);
        //初始化控件
        xBanner= (XBanner) view.findViewById(R.id.ban);
        xBanner.setmAdapter(this);
        recy1= (RecyclerView) view.findViewById(R.id.recy1);
        //初始化XBanner轮播图


        //首页 SYPresentr
        SYPresentr syPresentr=new SYPresentr(this);
        syPresentr.add();

        //首页轮播
        SYBannerPresent syBannerPresent=new SYBannerPresent(this);
        syBannerPresent.add("1");


        return view;
    }
    //首页热门活动数据
    @Override
    public void SYData(List<SYBean> bean) {


        //  Log.i(TAG, "SYData: " + bean.size());
        //创建适配器1
        SYAdapter1 showAdapter = new SYAdapter1(getActivity(),bean);
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        recy1.setLayoutManager(ll);
        recy1.setAdapter(showAdapter);
    }

    @Override
    public void ShowSYBannerData(List<SYBanner> bean) {

        for(int i = 0;i<bean.size();i++){
            texts.add(bean.get(i).getName());
            images.add(bean.get(i).getImgUrl());
        }

        xBanner.setData(images, texts);
        xBanner.setmAutoPalyTime(2000);
        xBanner.setPageTransformer(Transformer.Rotate);    //立体旋转
        xBanner.setPageChangeDuration(1500);
    }

    //xbanner立体旋转
    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
    }
}


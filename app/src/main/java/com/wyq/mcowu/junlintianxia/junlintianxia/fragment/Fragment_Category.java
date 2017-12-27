package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.activity.DetailsActivity;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.CateNextAdapter;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.CategoryAdapter;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BaseFragment;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBanner;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.myapp.Imgloder;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.CategoryPresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.SYBannerPresent;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.ICategory_View;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Category extends BaseFragment<CategoryPresenter> implements ICategory_View,MyView{


    private RecyclerView mLeftRv;
    private Banner mBannerCate;
    private RecyclerView mRightRv;
    private List<String> list;
    SYBannerPresent syBannerPresent;
    List<String> images;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_category, null);
        initView(view);
        prsenter.show();
        prsenter.show(1);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mLeftRv = (RecyclerView) itemView.findViewById(R.id.rv_left);
        mBannerCate = (Banner) itemView.findViewById(R.id.cate_banner);
        mRightRv = (RecyclerView) itemView.findViewById(R.id.rv_right);
    }

    @Override
    public void createPresenter() {
        prsenter = new CategoryPresenter(getContext(), this);
        syBannerPresent = new SYBannerPresent(this);
        syBannerPresent.add("1");

    }

    @Override
    public void show(final List<Category> list) {
        Log.i("==========", "show: " + list.size());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mLeftRv.setLayoutManager(manager);
        CategoryAdapter adapter = new CategoryAdapter(getContext(), list);
        mLeftRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new CategoryAdapter.onItemClickListener() {
            @Override
            public void ItemClick(View view, int position) {
                int id = list.get(position).getId();
                prsenter.show(id);
            }
        });
    }
    @Override
    public void showNext(Category_next category_next) {
        final List<Category_next.ListBean> list = category_next.getList();
        Log.i("======category_next====", "showNext: "+category_next.getList().size());
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        mRightRv.setLayoutManager(manager);
        CateNextAdapter adapter = new CateNextAdapter(getActivity(),list);
        mRightRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new CateNextAdapter.onItemClickListener() {
            @Override
            public void ItemClick(View view, int position) {
                int id = list.get(position).getId();
                String imgUrl = list.get(position).getImgUrl();
                String name = list.get(position).getName();
                double price = list.get(position).getPrice();
                Intent intent=new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("img",imgUrl);
                intent.putExtra("name",name);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });
    }

    @Override
    public void SYData(List<SYBean> bean) {

    }

    @Override
    public void ShowSYBannerData(List<SYBanner> bean) {

        images = new ArrayList<>();
        for(int i = 0;i<bean.size();i++){
            images.add(bean.get(i).getImgUrl());
        }

        mBannerCate.isAutoPlay(true);
        mBannerCate.setImageLoader(new Imgloder());
        mBannerCate.setImages(images);
        mBannerCate.start();
    }
}

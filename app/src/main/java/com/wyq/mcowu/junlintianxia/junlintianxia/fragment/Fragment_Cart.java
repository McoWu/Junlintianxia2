package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.Fragment_CartAdapter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ShopBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.db.dao.MyUserDao;

import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Cart extends Fragment {
    private XRecyclerView mXrlv;
    private View view;
    private MyUserDao dao;
    private List<ShopBean> shopBeans;
    private Fragment_CartAdapter fragment_cartAdapter;
    Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_cart, null);
        //这个是一个购物车的页面
        initView(view);
        initData();
        mXrlv.setPullRefreshEnabled(true);
        mXrlv.setLoadingMoreEnabled(true);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                shopBeans = dao.queryUserList();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mXrlv.refreshComplete();
                    }
                }, 3000);
                fragment_cartAdapter = new Fragment_CartAdapter(shopBeans, getActivity());
                mXrlv.setAdapter(fragment_cartAdapter);
            }

            @Override
            public void onLoadMore() {

            }
        });
        return view;
    }

    /*
    * 请求查询数据
    * */
    private void initData() {
        shopBeans = dao.queryUserList();
        Log.i("-----shopBeans----", "initData: " + shopBeans.toString());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mXrlv.setLayoutManager(manager);
        fragment_cartAdapter = new Fragment_CartAdapter(shopBeans, getActivity());
        mXrlv.setAdapter(fragment_cartAdapter);
    }

    private void initView(@NonNull final View itemView) {
        mXrlv = (XRecyclerView) itemView.findViewById(R.id.xrlv);
        dao = new MyUserDao(getActivity());
    }


}

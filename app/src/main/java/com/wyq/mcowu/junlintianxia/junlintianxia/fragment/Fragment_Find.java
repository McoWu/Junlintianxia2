package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.ReMaiAdapter;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BaseFragment;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.RMPresentr;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.IndexView;

import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Find extends BaseFragment<BasePresenter> implements IndexView {


    private RecyclerView mRemaiRecy;
    private RMPresentr fxpresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_find, null);
        mRemaiRecy=(RecyclerView) view.findViewById(R.id.recy_faxian);
        fxpresenter.adds(1,20);

        return view;
    }

    @Override
    public void createPresenter() {
        fxpresenter = new RMPresentr(this);
    }

    //首页
    @Override
    public void SYData(List<IndexBean> bean) {

    }

    //发现
    @Override
    public void RMData(ReMaiBean reMaiBeen) {
        LinearLayoutManager remaill=new LinearLayoutManager(getActivity());
        mRemaiRecy.setLayoutManager(remaill);

        ReMaiAdapter reMaiAdapter=new ReMaiAdapter(getActivity(),reMaiBeen);
        mRemaiRecy.setAdapter(reMaiAdapter);

    }
}

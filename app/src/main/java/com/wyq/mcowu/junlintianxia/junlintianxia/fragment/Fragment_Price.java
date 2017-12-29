package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.adapter.HotAdapter;
import com.wyq.mcowu.junlintianxia.junlintianxia.base.BaseFragment;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.HotBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.HotPresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.view.IHotView;

import java.util.List;

/**
 * Created by dell on 2017/12/27.
 */
/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Price extends BaseFragment<HotPresenter> implements IHotView {

    private int id;
    private RecyclerView mRv;
    private TextView mImg;
    private static final int  Type_LIST=0;
    private static final int  Type_GRID=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.fragment_default, null);
        id = getActivity().getIntent().getIntExtra("id", 1);
        Log.i("============", "onClick: " + id);
        initView(view);
        prsenter.hotShow(id, 2);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mRv = (RecyclerView) itemView.findViewById(R.id.rv_id);

    }

    @Override
    public void createPresenter() {
        prsenter = new HotPresenter(getActivity(), this);
    }

    @Override
    public void hot(HotBean hotBean) {
        final List<HotBean.ListBean> list = hotBean.getList();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(manager);
        HotAdapter adapter = new HotAdapter(getActivity(), list);
        mRv.setAdapter(adapter);
    }

}
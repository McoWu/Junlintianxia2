package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by dell on 2017/12/27.
 */

public class Fragment_sales extends Fragment {
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Sales extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_cart,null);
        return view;
    }
}

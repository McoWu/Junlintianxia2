package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyq.mcowu.junlintianxia.R;

/**
 * Created by dell on 2017/12/27.
 */

public class BlankFragment extends Fragment{
    private TextView textView;
    public BlankFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_blank,null);
        initView(view);
        return view;
    }
    private void initView(View view) {
        String title= (String) getArguments().get("title");
        textView= (TextView) view.findViewById(R.id.txt_title);
        textView.setText(title);
    }

}

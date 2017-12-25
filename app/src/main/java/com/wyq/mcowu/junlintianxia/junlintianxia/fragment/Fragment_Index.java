package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Adapter.SYAdapter1;
import com.wyq.mcowu.junlintianxia.junlintianxia.Bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.Presenter.SYPresentr;
import com.wyq.mcowu.junlintianxia.junlintianxia.myapp.Imgloder;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Index extends Fragment implements MyView{

    Banner ban;
    RecyclerView recy1;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.fragment_index,null);
        //初始化控件
        ban= (Banner) view.findViewById(R.id.ban);
        recy1= (RecyclerView) view.findViewById(R.id.recy1);

        OkUrl();
        //首页 SYPresentr
        SYPresentr syPresentr=new SYPresentr(this);
        syPresentr.add();


        return view;
    }
    //首页banner轮播图
    private void OkUrl() {
        list=new ArrayList<>();
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg");
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg");
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608b7cdN218fb48f.jpg");
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560b5a7eN214306c8.jpg");
        list.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560a409eN35e252de.jpg");

        ban.isAutoPlay(true);
        ban.setImageLoader(new Imgloder());
        ban.setImages(list);
        ban.start();
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


}


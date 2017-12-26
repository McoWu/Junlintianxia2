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
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.SYPresentr;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.activity.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Index extends Fragment implements MyView,XBanner.XBannerAdapter{

   XBanner  xBanner;
    Unbinder unbinder;
    RecyclerView recy1;
    private List<String> imgesUrl;
    private List<String> wenzi;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.fragment_index,null);
        //初始化控件
        xBanner= (XBanner) view.findViewById(R.id.ban);
        xBanner.setmAdapter(this);
        initBanner();
        recy1= (RecyclerView) view.findViewById(R.id.recy1);
        //初始化XBanner轮播图


        //首页 SYPresentr
        SYPresentr syPresentr=new SYPresentr(this);
        syPresentr.add();


        return view;
    }

    //首页banner轮播图
    private void  initBanner() {
        //直接加图片的xbanner
        wenzi = new ArrayList<>();
        imgesUrl = new ArrayList<>();
        wenzi.add("音箱狂欢");
        wenzi.add("手机国庆礼");
        wenzi.add("IT生活");
        wenzi.add("母婴萌宝");
        wenzi.add("国庆大礼包");
        wenzi.add("手机大放假");

        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608b7cdN218fb48f.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560b5a7eN214306c8.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560a409eN35e252de.jpg");
        xBanner.setData(imgesUrl, wenzi);
        xBanner.setmAutoPalyTime(2000);
        xBanner.setPageTransformer(Transformer.Rotate);    //立体旋转
        xBanner.setPageChangeDuration(1500);
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

    //xbanner立体旋转
    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(imgesUrl.get(position)).into((ImageView) view);
    }
}


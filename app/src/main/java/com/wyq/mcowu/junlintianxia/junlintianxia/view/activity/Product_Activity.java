package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Default;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Price;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表
 */
public class Product_Activity extends AppCompatActivity implements View.OnClickListener {
    TabLayout tab;
    ViewPager vp2;
    List<Fragment> lists;
    //设置自定义标题
    String[] title = {"默认", "价格", "销量"};
    private ImageView mImg;
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        tab = (TabLayout) findViewById(R.id.tab);
        vp2 = (ViewPager) findViewById(R.id.vp2);

        //沉浸式
        Immersives.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        addFragments();
        //创建ViewPager适配器
        MyViewPager adapters = new MyViewPager(getSupportFragmentManager());
        vp2.setAdapter(adapters);
        // 关联TabLayout和ViewPager
        tab.setupWithViewPager(vp2);

    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mImg.setOnClickListener(this);
    }

    //添加Fragment
    private void addFragments() {
        lists = new ArrayList<>();
        lists.add(new Fragment_Default());
        lists.add(new Fragment_Price());
        lists.add(new Fragment_Sales());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:

                break;
            default:
                break;
        }
    }

    // ViewPager适配器
    class MyViewPager extends FragmentPagerAdapter {


        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        //重写getPageTitle
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }


}



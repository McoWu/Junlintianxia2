package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Default;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Price;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表
 */
public class Product_Activity extends FragmentActivity {
      TabLayout tab;
      ViewPager vp2;
      private List<Fragment> lists;
    //设置自定义标题
    String[] title={"默认","价格","销量"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tab=(TabLayout)findViewById(R.id.tab);
         vp2=(ViewPager)findViewById(R.id.vp2);

        //隐藏标题栏
//        ActionBar actionBar=getSupportActionBar();
//        actionBar.hide();

        addFragments();
        //创建ViewPager适配器
        MyViewPager adapters=new  MyViewPager (getSupportFragmentManager());
        vp2.setAdapter(adapters);

        //设置可以滑动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 关联TabLayout和ViewPager
        tab.setupWithViewPager(vp2);

    }
    //添加Fragment
    private void addFragments() {
        lists = new ArrayList<>();
        lists.add(new Fragment_Default());
        lists.add(new Fragment_Price());
        lists.add(new Fragment_Sales());
    }

    // ViewPager适配器
    class  MyViewPager extends FragmentPagerAdapter {


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



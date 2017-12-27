package com.wyq.mcowu.junlintianxia.junlintianxia.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.BlankFragment;

public class ShopListActivity extends AppCompatActivity implements View.OnClickListener,TabLayout.OnTabSelectedListener{

    private Fragment[] fragments;
    private TabLayout mLayoutTab;
    private ImageView mImg;
    private String[] titles = {"默认", "价格", "销量"};
    FragmentManager fragmentManager;//获取fragment管理器
    FragmentTransaction fragmentTransaction;//获取事务
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        //沉浸式
        Immersives.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initView();
        initData();
    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();//获取fragment管理器
        //        fragments = new Fragment[titles.length];
        for (int i = 0; i <titles.length ; i++) {
            TabLayout.Tab tab = mLayoutTab.newTab();
            tab.setText(titles[i]);
            //tab.setIcon(R.mipmap.ic_launcher);
            mLayoutTab.addTab(tab,i,i==position);
        }
    }

    private void initView() {
        mLayoutTab = (TabLayout) findViewById(R.id.tab_layout);
        mImg = (ImageView) findViewById(R.id.img);
        mImg.setOnClickListener(this);
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

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //刚进来没有执行
        Fragment fragmentFrom = fragments[position];//获取当前显示的fragment
        Fragment fragmentTo = (Fragment) tab.getTag();
        if (fragmentTo == null) {
            fragmentTo = getItem(tab.getPosition());
            tab.setTag(fragmentTo);
        }
        position = tab.getPosition();//给position赋新值
        switchFragment(fragmentFrom, fragmentTo);
    }

    /**
     * 切换显示fragment
     *
     * @param fragmentFrom
     * @param fragmentTo
     */
    private void switchFragment(Fragment fragmentFrom, Fragment fragmentTo) {
        fragmentTransaction = fragmentManager.beginTransaction();//获取事务
        //隐藏from
        if (fragmentFrom != null) {
            fragmentTransaction.hide(fragmentFrom);
        }
        //先查找fragmentTo是否已经被装载
        Fragment fragment = fragmentManager.findFragmentByTag(fragmentTo.getClass().getName());
        //如果fragmentTo不存在就装载，存在就显示
        if (fragment == null) {
            fragmentTransaction.add(R.id.shop_fl, fragmentTo);
        } else {
            fragmentTransaction.show(fragmentTo);
        }
        fragmentTransaction.commit();
    }

    /**
     * 创建fragment
     *
     * @param position
     * @return
     */
    private Fragment getItem(int position) {
        Fragment fragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", titles[position]);
        fragment.setArguments(bundle);
        fragments[position] = fragment;
        return fragment;
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}



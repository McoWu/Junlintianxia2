package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Cart;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Find;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Index;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Mine;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private Fragment_Index fragment_index;
    private Fragment_Category fragment_category;
    private Fragment_Find fragment_find;
    private Fragment_Cart fragment_cart;
    private Fragment_Mine fragment_mine;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFrag();
        showFrag(R.id.fl, fragment_index, "fragment_index");
        mRg.check(R.id.rb_index);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_index:
                        showFrag(R.id.fl, fragment_index, "fragment_index");
                        break;
                    case R.id.rb_category:
                        showFrag(R.id.fl, fragment_category, "fragment_category");
                        break;
                    case R.id.rb_find:
                        showFrag(R.id.fl, fragment_find, "fragment_find");
                        break;
                    case R.id.rb_cart:
                        showFrag(R.id.fl, fragment_cart, "fragment_cart");
                        break;
                    case R.id.rb_mine:
                        showFrag(R.id.fl, fragment_mine, "fragment_mine");
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void initView() {
        mRg = (RadioGroup) findViewById(R.id.rg);
    }

    //初始化Fragment
    private void initFrag() {
        fragment_index = new Fragment_Index();
        fragment_category = new Fragment_Category();
        fragment_find = new Fragment_Find();
        fragment_cart = new Fragment_Cart();
        fragment_mine = new Fragment_Mine();
    }

    public void showFrag(int id, Fragment flag, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragmentByTag == null) {
            transaction.add(id, flag, tag);
        }
        List<Fragment> list = getSupportFragmentManager().getFragments();
        for (Fragment f : list) {
            transaction.hide(f);
        }
        transaction.show(flag);
        transaction.commit();
    }


}

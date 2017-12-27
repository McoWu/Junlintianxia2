package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Cart;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Find;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Index;
import com.wyq.mcowu.junlintianxia.junlintianxia.fragment.Fragment_Mine;

import java.util.HashMap;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivity extends AppCompatActivity {


    private Fragment_Index fragment_index;
    private Fragment_Category fragment_category;
    private Fragment_Find fragment_find;
    private Fragment_Cart fragment_cart;
    private Fragment_Mine fragment_mine;
    private RadioGroup mRg;
    EventHandler eventHandler;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------------------
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        //SMSSDK.setAskPermisionOnReadContact(true);
        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable)data;
                    msg = throwable.getMessage();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 这里是验证成功的回调，可以处理验证成功后您自己的逻辑，需要注意的是这里不是主线程
                    }
                }
            }
        };

//打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

// 提交用户信息（此方法可以不调用）
                   // registerUser(country, phone);
                }
            }
        });
        registerPage.show(this);

        //沉浸式
        Immersives.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

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

    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}

package com.wyq.mcowu.junlintianxia.junlintianxia.activity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;


public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mImg;
    private TextView mTitle;
    private TextView mPrice;
    private RadioButton mShareRb;
    private RadioButton mAddRb;
    private RadioButton mBuyRb;
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        //沉浸式
        Immersives.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initIntent();


    }

    private void initView() {
        mImg = (SimpleDraweeView) findViewById(R.id.img);
        mTitle = (TextView) findViewById(R.id.title);
        mPrice = (TextView) findViewById(R.id.price);
        mShareRb = (RadioButton) findViewById(R.id.rb_share);
        mShareRb.setOnClickListener(this);
        mAddRb = (RadioButton) findViewById(R.id.rb_add);
        mAddRb.setOnClickListener(this);
        mBuyRb = (RadioButton) findViewById(R.id.rb_buy);
        mBuyRb.setOnClickListener(this);
    }

    private void initIntent() {
        int id = getIntent().getIntExtra("id", 1);
        String img = getIntent().getStringExtra("img");
        String name = getIntent().getStringExtra("name");
        double price = getIntent().getDoubleExtra("price", 0);
        Log.i("====id=============", "onCreate: " + id + "" + img + name + price + "");
        mImg.setImageURI(Uri.parse(img));
        mTitle.setText(name);
        mPrice.setText("￥" + price + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_share:

                break;
            case R.id.rb_add:
                // TODO 17/12/26
                break;
            case R.id.rb_buy:
                // TODO 17/12/26
                break;
            default:
                break;
        }
    }

}


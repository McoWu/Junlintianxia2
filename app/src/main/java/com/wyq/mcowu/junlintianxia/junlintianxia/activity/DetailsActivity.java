package com.wyq.mcowu.junlintianxia.junlintianxia.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;
import com.wyq.mcowu.junlintianxia.junlintianxia.utils.Defaultcontent;
import com.wyq.mcowu.junlintianxia.junlintianxia.utils.ShareUtils;

import java.util.Map;


public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = this.getClass().getSimpleName();

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
        Log.i(TAG, "onCreate: " + id + "" + img + name + price + "");
        mImg.setImageURI(Uri.parse(img));
        mTitle.setText(name);
        mPrice.setText("￥" + price + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_share:
                PopupWindow();
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

    private void PopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 200);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.LEFT, 0,
                0);
    }

    public void qq(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QQ
        );
    }

    public void weiXin(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN
        );
    }

    public void weixinCircle(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN_CIRCLE
        );
    }

    public void sina(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.SINA
        );
    }

    public void Qzone(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QZONE
        );
    }


    public void qqLogin(View view) {
        authorization(SHARE_MEDIA.QQ);
    }

    public void weiXinLogin(View view) {
        authorization(SHARE_MEDIA.WEIXIN);
    }

    public void sinaLogin(View view) {
        authorization(SHARE_MEDIA.SINA);
    }
    //授权
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(this).getPlatformInfo(this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.d(TAG, "onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.d(TAG, "onComplete " + "授权完成");

                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");

                Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();

                //拿到信息去请求登录接口。。。
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.d(TAG, "onError " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.d(TAG, "onCancel " + "授权取消");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}


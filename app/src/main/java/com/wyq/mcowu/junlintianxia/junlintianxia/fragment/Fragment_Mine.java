package com.wyq.mcowu.junlintianxia.junlintianxia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.LoginBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.RegisterBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.LoginPresent;
import com.wyq.mcowu.junlintianxia.junlintianxia.presenter.RegisterPresent;
import com.wyq.mcowu.junlintianxia.junlintianxia.utils.DESUtils;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.MindView;

/**
 * Created by dell on 2017/12/25.
 */

public class Fragment_Mine extends Fragment implements MindView{

    private View view;
    private EditText etPhone,etPwd;
    private TextView tvName;
    private ImageView imgHead;
    private Button butLogin,butRegister;
    private RegisterPresent registerPresent;
    private LoginPresent loginPresent;
    private String encodePhone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getContext(), R.layout.fragment_mine, null);

        initView();
        registerPresent = new RegisterPresent(this);
        loginPresent = new LoginPresent(this);


        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = "Cniao5_123456";
                String text = etPwd.getText().toString();
                encodePhone = DESUtils.encode(key,text);
                Log.i("DES encode text is ", encodePhone);
                Log.i("wangjinlei", "onClick: phone" + etPhone.getText().toString());
                Log.i("wangjinlei", "onClick: pwd" + text);
                //登录
                Login(etPhone.getText().toString(),encodePhone);
            }
        });


        butRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = "Cniao5_123456";
                String text = etPwd.getText().toString();
                encodePhone = DESUtils.encode(key,text);
                Log.i("DES encode text is ", encodePhone);
                Log.i("wangjinlei", "onClick: phone" + etPhone.getText().toString());
                Log.i("wangjinlei", "onClick: pwd" + text);
                //注册
                Register(etPhone.getText().toString(),encodePhone);
            }
        });

        return view;
    }

    private void initView() {
        etPhone = view.findViewById(R.id.etPhone);
        etPwd = view.findViewById(R.id.etPwd);
        butLogin = view.findViewById(R.id.butLogin);
        butRegister = view.findViewById(R.id.butRegister);
        tvName = view.findViewById(R.id.tvName);
        imgHead = view.findViewById(R.id.imgHead);

    }

    private void Login(String phone,String pwd){
        loginPresent.add(phone,pwd);
    }

    private void Register(String phone,String pwd){
        registerPresent.add(phone,pwd);
    }

    @Override
    public void ShowRegister(RegisterBean registerBean) {
        Log.i("wangjinlei", "ShowRegister: " + registerBean.getData().getUsername());
    }

    @Override
    public void ShowLogin(LoginBean loginBean) {
        int code = loginBean.getStatus();
        if(code == 1){
            Toast.makeText(getActivity(),"登陆成功",Toast.LENGTH_LONG).show();
            tvName.setText(loginBean.getData().getUsername());
            Glide.with(getActivity()).load(loginBean.getData().getLogo_url()).into(imgHead);
       }
    }
}

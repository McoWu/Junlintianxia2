package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.LoginBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.RegisterBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.MindModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.MindView;

/**
 * Created by 王磊 on 2017/12/26.
 */

public class LoginPresent implements MindModel.IModel{

    MindView mindView;
    MindModel mindModel;

    public LoginPresent(MindView mindView) {
        this.mindView = mindView;
        this.mindModel = new MindModel();
        mindModel.setiModel(this);
    }

    @Override
    public void RegisterCallBack(RegisterBean registerBean) {

    }

    @Override
    public void LoginCallBack(LoginBean loginBean) {
        mindView.ShowLogin(loginBean);
    }
    public void add(String phone,String pwd){
        mindModel.getLogin(phone,pwd);
    }
}

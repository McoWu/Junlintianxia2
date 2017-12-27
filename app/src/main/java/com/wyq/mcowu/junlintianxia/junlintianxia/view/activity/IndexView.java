package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.IndexBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ReMaiBean;

import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/21.
 * view层
 */

public interface IndexView {
    //首页view
    void  SYData(List<IndexBean> bean);
    //发现view
    void RMData(ReMaiBean reMaiBeen);

}

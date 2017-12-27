package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;


import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBanner;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.SYBean;

import java.util.List;

/**
 * Created by tangxiaoying on 2017/12/21.
 * view层
 */

public interface MyView {
    //首页view
    void  SYData(List<SYBean> bean);
    void  ShowSYBannerData(List<SYBanner> bean);


}

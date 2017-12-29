package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.HotBean;

/**
 * Created by dell on 2017/12/29.
 */

public interface IHotModel {
    //campaignId=10&orderBy=1&curPage=1&pageSize=20
    void hot(int campaignId,int orderBy,CallBack callBack);
    interface CallBack{
        void complete(HotBean hotBean);
    }
}

package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;

import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public interface ICategory_Model {
    void category(CallBack callBack);
    interface CallBack{
        void complete(List<Category> list);
    }
}

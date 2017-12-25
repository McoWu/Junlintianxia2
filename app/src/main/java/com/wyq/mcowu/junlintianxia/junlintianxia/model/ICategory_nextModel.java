package com.wyq.mcowu.junlintianxia.junlintianxia.model;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;

/**
 * Created by dell on 2017/12/25.
 */

public interface ICategory_nextModel {
    void category_next(int categoryId,int curPage,int pageSize,CallBack callBack);
    interface CallBack{
        void complete(Category_next  category_next);
    }
}

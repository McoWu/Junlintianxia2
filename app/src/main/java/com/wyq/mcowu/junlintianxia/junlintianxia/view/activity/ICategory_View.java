package com.wyq.mcowu.junlintianxia.junlintianxia.view.activity;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;

import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public interface ICategory_View {
    void show(List<Category> list);
    void showNext(Category_next category_next);
}

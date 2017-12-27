package com.wyq.mcowu.junlintianxia.junlintianxia.presenter;

import android.content.Context;

import com.wyq.mcowu.junlintianxia.junlintianxia.base.BasePresenter;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category;
import com.wyq.mcowu.junlintianxia.junlintianxia.bean.Category_next;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.Category_Model;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.Category_nextModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.ICategory_Model;
import com.wyq.mcowu.junlintianxia.junlintianxia.model.ICategory_nextModel;
import com.wyq.mcowu.junlintianxia.junlintianxia.view.view.ICategory_View;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by dell on 2017/12/25.
 */

public class CategoryPresenter implements BasePresenter<ICategory_View>{
    Context context;
    ICategory_Model model;
    WeakReference<ICategory_View> wefView;
    ICategory_nextModel modelNext;
    public CategoryPresenter(Context context, ICategory_View view) {
        this.context = context;
        this.model = new Category_Model();
        modelNext = new Category_nextModel();
        attch(view);
    }
    public void show(){
        model.category(new ICategory_Model.CallBack() {
            @Override
            public void complete(List<Category> list) {
                wefView.get().show(list);
            }
        });
    }
    public void show(int categoryId){
        modelNext.category_next(categoryId, 1, 20, new ICategory_nextModel.CallBack() {
            @Override
            public void complete(Category_next category_next) {
                wefView.get().showNext(category_next);
            }
        });

    }
    @Override
    public void attch(ICategory_View view) {
        wefView=new WeakReference<ICategory_View>(view);
    }

    @Override
    public void disattch() {
        wefView.clear();
    }
}

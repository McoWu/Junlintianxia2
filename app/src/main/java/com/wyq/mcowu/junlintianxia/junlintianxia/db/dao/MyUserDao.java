package com.wyq.mcowu.junlintianxia.junlintianxia.db.dao;

import android.content.Context;

import com.wyq.mcowu.junlintianxia.junlintianxia.bean.ShopBean;
import com.wyq.mcowu.junlintianxia.junlintianxia.db.dao.db.DaoMaster;
import com.wyq.mcowu.junlintianxia.junlintianxia.db.dao.db.DaoSession;
import com.wyq.mcowu.junlintianxia.junlintianxia.db.dao.db.ShopBeanDao;
import com.wyq.mcowu.junlintianxia.junlintianxia.db.db.DBManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


public class MyUserDao {
    Context context;
    public MyUserDao(Context context) {
        this.context = context;
    }

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insertUser(ShopBean user) {
        //DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWritableDatabase());
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWirteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        shopBeanDao.insert(user);
    }

    /**
     * 插入用户集合
     *
     * @param users
     */
    public void insertUserList(List<ShopBean> users) {
        if (users == null || users.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWirteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        shopBeanDao.insertInTx(users);
    }

    /**
     * 查询用户列表
     */
    public List<ShopBean> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        QueryBuilder<ShopBean> qb = shopBeanDao.queryBuilder();
        List<ShopBean> list = qb.list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<ShopBean> queryUserList(int age) {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        QueryBuilder<ShopBean> qb = shopBeanDao.queryBuilder();
        //qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        List<ShopBean> list = qb.list();
        return list;
    }
    public boolean queryUserByshopId(int shopId) {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        QueryBuilder<ShopBean> qb = shopBeanDao.queryBuilder();
        QueryBuilder<ShopBean> where = qb.where(ShopBeanDao.Properties.ShopId.eq(shopId));
        long count = where.count();
        if(count>0){
            return true;
        }
        return false;
    }
    /**
     * 更新一条记录
     *
     * @param user
     */
    public void updateUser(ShopBean user) {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWirteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        shopBeanDao.update(user);
    }

    /**
     * 删除一条记录
     *
     * @param user
     */
    public void deleteUser(ShopBean user) {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWirteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        shopBeanDao.delete(user);
    }

    /*
    * 修改数据
    * */
    public void update(int shopId,int num){
       DaoMaster daoMaster2 = new DaoMaster(DBManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession1 = daoMaster2.newSession();
        ShopBeanDao shopBeanDao1 = daoSession1.getShopBeanDao();
        QueryBuilder<ShopBean> qb = shopBeanDao1.queryBuilder();
        QueryBuilder<ShopBean> where = qb.where(ShopBeanDao.Properties.ShopId.eq(shopId));
        List<ShopBean> list = where.list();
        ShopBean shopBean = list.get(0);
        shopBean.setNum(num);
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(context).getWirteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShopBeanDao shopBeanDao = daoSession.getShopBeanDao();
        shopBeanDao.update(shopBean);

    }

}

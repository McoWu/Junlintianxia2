package com.wyq.mcowu.junlintianxia.junlintianxia.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 姓名：McoWu
 * 时间:2017/12/29 20:47.
 * 本类作用:
 */
@Entity
public class ShopBean {
    @Id(autoincrement = true)
    private Long id;
    @Index(unique = true)
    private int shopId;
    private String name;
    private String img;
    private double price;
    private int num;
    private boolean flag;
    public boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getShopId() {
        return this.shopId;
    }
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1397499092)
    public ShopBean(Long id, int shopId, String name, String img, double price,
            int num, boolean flag) {
        this.id = id;
        this.shopId = shopId;
        this.name = name;
        this.img = img;
        this.price = price;
        this.num = num;
        this.flag = flag;
    }
    @Generated(hash = 748345971)
    public ShopBean() {
    }

   

}

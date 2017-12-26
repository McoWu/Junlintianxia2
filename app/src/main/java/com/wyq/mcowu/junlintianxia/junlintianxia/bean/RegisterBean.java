package com.wyq.mcowu.junlintianxia.junlintianxia.bean;

/**
 * Created by 王磊 on 2017/12/26.
 */

public class RegisterBean {

    /**
     * token : 请到菜鸟窝官网注册后在调用登录接口获取token
     * data : {"id":-1,"username":"模拟注册成功","mobi":"13521755747"}
     * status : 1
     * message : 本接口已停止注册,请到菜鸟窝官网注册:http://wwww.cniao5.com/auth/reg.html
     */

    private String token;
    private DataBean data;
    private int status;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * id : -1
         * username : 模拟注册成功
         * mobi : 13521755747
         */

        private int id;
        private String username;
        private String mobi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobi() {
            return mobi;
        }

        public void setMobi(String mobi) {
            this.mobi = mobi;
        }
    }
}

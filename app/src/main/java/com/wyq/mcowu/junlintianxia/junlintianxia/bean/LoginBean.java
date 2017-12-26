package com.wyq.mcowu.junlintianxia.junlintianxia.bean;

/**
 * Created by 王磊 on 2017/12/26.
 */

public class LoginBean {

    /**
     * token : f56370f2-4ea4-42a2-a253-0d35a9af7b99
     * data : {"id":279689,"logo_url":"http://q.qlogo.cn/qqapp/101119327/72D9BF59F9A7C69107D4DDEB95B04012/100","username":"王磊","mobi":"13521755747"}
     * status : 1
     * message : success
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
         * id : 279689
         * logo_url : http://q.qlogo.cn/qqapp/101119327/72D9BF59F9A7C69107D4DDEB95B04012/100
         * username : 王磊
         * mobi : 13521755747
         */

        private int id;
        private String logo_url;
        private String username;
        private String mobi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
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

package com.thd.base.datasource;

/**
 * 数据源坐标
 *
 * @author TaoFaDeng@HF
 * @version 1.0
 * @since 2015年12月26日16:18:52
 */
public class DataSourceCoordinate {
    /**
     * 数据库驱动名
     */
    private String driverClassName;

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String userName;

    /**
     * 数据库用户密码
     */
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

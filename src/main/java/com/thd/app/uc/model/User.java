package com.thd.app.uc.model;

import com.thd.base.model.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 人员信息
 */
@Entity
@Table(name = "t_uc_user")
public class User extends BaseModel {
    /**
     * 用户性别类型
     */
    public enum GenderType {
        MAN("男"), WOMEN("女");
        private final String text;

        private GenderType(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 用户主键
     */
    @Id
    @Column(nullable = false, length = 32)
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    private String userId;

    /**
     * 登录账号
     */
    @Column(length = 50)
    private String loginName;

    /**
     * 用户名
     */
    @Column
    private String userName;

    /**
     * 工号
     */
    private String employeeCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}

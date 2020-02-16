package com.example.testapplication.Entity;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;


    /**
     * 账号
     */
    private String accountCode;

    /**
     * 密码
     */
    private String password;


    /**
     * 账号类型：0 用户；1 后台账号
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

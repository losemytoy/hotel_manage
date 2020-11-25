package com.yiming.hotel_manage.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

//重写UsernamePasswordToken添加loginType属性


public class LocalUsernamePasswordToken extends UsernamePasswordToken {

    private String loginType;

    public LocalUsernamePasswordToken() {
    }

    public LocalUsernamePasswordToken(final String username, final String password, final String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}

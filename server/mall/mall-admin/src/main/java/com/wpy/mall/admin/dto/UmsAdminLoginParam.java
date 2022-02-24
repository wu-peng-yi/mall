package com.wpy.mall.admin.dto;

/**
 * @author W
 * @date 2022-02-23
 */
public class UmsAdminLoginParam {

    private String username;

    private String password;

    public UmsAdminLoginParam() {
    }

    public UmsAdminLoginParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

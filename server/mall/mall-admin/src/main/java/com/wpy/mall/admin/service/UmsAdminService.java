package com.wpy.mall.admin.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author W
 * @date 2022-02-23
 */
public interface UmsAdminService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}

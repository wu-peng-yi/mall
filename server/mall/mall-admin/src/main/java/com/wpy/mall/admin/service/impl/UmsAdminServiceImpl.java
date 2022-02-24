package com.wpy.mall.admin.service.impl;

import com.example.mall.common.exception.Asserts;
import com.wpy.mall.admin.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author W
 * @date 2022-02-23
 */
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("账号或密码不正确");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("账号已被禁用");
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {

        }
        return null;
    }

    private UserDetails loadUserByUsername(String username) {
        return null;
    }
}

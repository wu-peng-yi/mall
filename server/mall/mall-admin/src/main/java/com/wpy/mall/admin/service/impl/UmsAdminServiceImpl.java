package com.wpy.mall.admin.service.impl;

import com.example.mall.common.exception.Asserts;
import com.wpy.mall.admin.service.UmsAdminService;
import com.wpy.mall.mbg.model.UmsAdmin;
import com.wpy.mall.mbg.model.UmsAdminExample;
import com.wpy.mall.mbg.model.UmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author W
 * @date 2022-02-23
 */
@Service
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
        //获取用户信息
        //UmsAdmin admin = getAdminByUsername(username);
        //if (admin != null) {
        //    List<UmsResource> resourceList = getResourceList(admin.getId());
        //    return new AdminUserDetails(admin,resourceList);
        //}
        //throw new UsernameNotFoundException("用户名或密码错误");
    }

    /*private UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if(admin!=null) return  admin;
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }*/
}

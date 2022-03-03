package com.wpy.mall.admin.service;

import com.wpy.mall.mbg.model.UmsAdmin;
import com.wpy.mall.mbg.model.UmsResource;

import java.util.List;

/**
 * @author W
 * @date 2022-03-02
 */
public interface UmsAdminCacheService {
    /**
     * 获取缓存后台用户信息
     * @param username
     * @return
     */
    UmsAdmin getAdmin(String username);

    void setAdmin(UmsAdmin admin);

    List<UmsResource> getResourceList(Long adminId);

    void setResourceList(Long adminId, List<UmsResource> resourceList);
}

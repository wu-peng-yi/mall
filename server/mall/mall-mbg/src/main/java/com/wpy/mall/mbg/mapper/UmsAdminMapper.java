package com.wpy.mall.mbg.mapper;

import com.wpy.mall.mbg.model.UmsAdmin;
import com.wpy.mall.mbg.model.UmsAdminExample;

import java.util.List;

/**
 * @author W
 * @date 2022-03-02
 */
public interface UmsAdminMapper {
    List<UmsAdmin> selectByExample(UmsAdminExample example);

}

package com.wpy.mall.admin.controller;

import com.example.mall.common.api.CommonResult;
import com.wpy.mall.admin.dto.UmsAdminLoginParam;
import com.wpy.mall.admin.service.UmsAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author W
 * @date 2022-02-23
 */
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam){
        String token = adminService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }

}

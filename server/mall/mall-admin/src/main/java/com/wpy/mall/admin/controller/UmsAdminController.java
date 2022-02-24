package com.wpy.mall.admin.controller;

import com.example.mall.common.api.CommonResult;
import com.wpy.mall.admin.dto.UmsAdminLoginParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author W
 * @date 2022-02-23
 */
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam){
        return CommonResult.success("sdadas");
    }

}

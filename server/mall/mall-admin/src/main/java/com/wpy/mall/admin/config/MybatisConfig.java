package com.wpy.mall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author W
 * @date 2022-03-03
 */
@Configuration
@MapperScan({"com.wpy.mall.mbg.mapper","com.wpy.mall.admin.dao"})
@EnableTransactionManagement
public class MybatisConfig {
}

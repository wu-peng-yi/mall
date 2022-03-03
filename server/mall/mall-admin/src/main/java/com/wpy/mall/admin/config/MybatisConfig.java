package com.wpy.mall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author W
 * @date 2022-03-03
 */
@Configuration
@MapperScan({"com.wpy.mall.mapper","com.wpy.mall"})
@EnableTransactionManagement
public class MybatisConfig {
}

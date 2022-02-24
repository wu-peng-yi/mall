package com.wpy.mall.security.config;

import com.wpy.mall.security.component.JwtAuthenticationTokenFilter;
import com.wpy.mall.security.component.RestAuthenticationEntryPoint;
import com.wpy.mall.security.component.RestfulAccessDeniedHandler;
import com.wpy.mall.security.util.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author W
 * @date 2022-02-24
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();

        //配置不需要保护的路径
        for (String url : ignoreUrlsConfig().getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        //OPTIONS请求不拦截
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        //其他请求都需要验证
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                //关不跨站保护，关闭session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //自定义权限拒绝处理
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                //自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint(){
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }
}

package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 * Created By ChengHao On 2020/2/11
 */
@Configuration
public class CorsConfig {


    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        //是否支持cookie跨域
        config.setAllowCredentials(true);
        //原始域
        config.setAllowedOrigins(Arrays.asList("*"));
        //允许的头
        config.setAllowedHeaders(Arrays.asList("*"));
        //允许的方法
        config.setAllowedMethods(Arrays.asList("*"));
        //缓存时间
        config.setMaxAge(300l);

        //注册跨域配置
        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);
    }
}

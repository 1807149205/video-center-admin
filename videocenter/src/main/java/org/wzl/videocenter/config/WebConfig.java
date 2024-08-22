package org.wzl.videocenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");  // 允许所有的域
        config.addAllowedHeader("*");  // 允许所有的请求头
        config.addAllowedMethod("*");  // 允许所有的请求方法
        config.setAllowCredentials(true);  // 允许发送Cookie信息

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // 配置路径

        return new CorsFilter(source);
    }
}

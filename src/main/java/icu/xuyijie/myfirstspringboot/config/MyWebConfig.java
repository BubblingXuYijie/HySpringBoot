package icu.xuyijie.myfirstspringboot.config;

import icu.xuyijie.myfirstspringboot.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 徐一杰
 * @date 2024/11/11 8:47
 * @description Web 自定义配置
 */
// 代表这个类是 springboot 的配置类
@SpringBootConfiguration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                // 添加拦截器
                .addInterceptor(new LoginInterceptor())
                // 要拦截的 url，/** 代表全部 url
                .addPathPatterns("/**")
                // 不需要拦截的 url
                .excludePathPatterns(
                        // 登录界面
                        "/",
                        // 登录接口
                        "/user/login",
                        // 注册接口
                        "/user/register",
                        // 静态资源
                        "/*.jpg",
                        "/error"
                );
    }
}

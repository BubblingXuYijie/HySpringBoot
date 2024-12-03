package icu.xuyijie.myfirstspringboot.config;

import icu.xuyijie.myfirstspringboot.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 徐一杰
 * @date 2024/11/11 8:47
 * @description Web 自定义配置
 */
// 代表这个类是 springboot 的配置类
@SpringBootConfiguration
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * 静态资源映射
     * @param registry 映射关系
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:E:/uploadFiles/");
    }

    /**
     * 配置拦截器
     * @param registry 拦截器内容
     */
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
                        "/file/*.png",
                        "/error",
                        "/favicon.ico"
                );
    }
}

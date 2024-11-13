package icu.xuyijie.myfirstspringboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 徐一杰
 * @date 2024/11/11 8:42
 * @description 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入登录拦截器，url：{}", request.getRequestURI());
        // 获取 session
        HttpSession session = request.getSession();
        Object isLogin = session.getAttribute("isLogin");

        if (isLogin == null) {
            log.error("未登录");
            // 重定向到登录界面
            response.sendRedirect("/");
            return false;
        }

        log.info("登录拦截器放行");
        return true;
    }
}

package icu.xuyijie.myfirstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 徐一杰
 * @date 2024/10/29 13:53
 * @description
 */
@RequestMapping("/page")
// 访问 127.0.0.1:8080/page/print 会跳转到以返回值命名的页面，也就是 hello-world.html 页面
@Controller
public class PageController {
    @RequestMapping("/print")
    public String helloWorld() {
        return "hello-world";
    }
}

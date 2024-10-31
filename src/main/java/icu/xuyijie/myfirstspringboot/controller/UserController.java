package icu.xuyijie.myfirstspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 徐一杰
 * @date 2024/10/31 15:29
 * @description
 */
@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {
    //private final Logger log = LoggerFactory.getLogger(UserController.class)

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        log.info("前端输入的用户名是：{},前端输入的密码是：{}", username, password);

        if ("1".equals(username) && "1".equals(password)) {
            log.info("登录成功");
        } else {
            log.error("登录失败");
            model.addAttribute("msg", "登录失败");
        }

        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "index";
    }

}

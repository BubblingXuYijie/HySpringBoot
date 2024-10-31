package icu.xuyijie.myfirstspringboot.controller;

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
public class UserController {
    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        System.out.println(username);
        System.out.println(password);

        if ("1".equals(username) && "1".equals(password)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
            model.addAttribute("msg", "登录失败");
        }

        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "index";
    }

}

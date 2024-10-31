package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.User;
import icu.xuyijie.myfirstspringboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    /**
     * 注入 UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);

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

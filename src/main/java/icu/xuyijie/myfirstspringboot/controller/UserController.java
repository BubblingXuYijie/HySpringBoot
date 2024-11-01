package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.User;
import icu.xuyijie.myfirstspringboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

/**
 * @author 徐一杰
 * @date 2024/10/31 15:29
 * @description
 */
// url 映射
@RequestMapping("/user")
// 表明这是一个 spring boot 控制器
@Controller
// 自动生成日志打印器代码
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
        log.info("前端输入的用户名是：{}，前端输入的密码是：{}", username, password);

        // 根据用户名和密码查询用户
        List<User> userList = userMapper.findUserByUsernameAndPassword(username, password);

        // 如果查询不到对应用户，登录失败
        if (userList.isEmpty()) {
            log.error("登录失败");
            model.addAttribute("msg", "登录失败");
        } else {
            log.info("登录成功");
        }

        // 保持页面处在登录页
        return "index";
    }

    @RequestMapping("/register")
    public String register(String username, String password, String rePassword, Model model) {
        log.info("前端传来参数：{} - {} - {}", username, password, rePassword);


        // 两次输入密码不一致的情况
        if (!Objects.equals(password, rePassword)) {
            model.addAttribute("registerMsg", "两次输入密码不一致");
            return "index";
        }

        // 用户名已注册的情况

        // 把数据塞入数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertUser(user);

        model.addAttribute("msg", "注册成功，请登录");

        return "index";
    }

}

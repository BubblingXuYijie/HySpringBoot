package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.User;
import icu.xuyijie.myfirstspringboot.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

/**
 * @author 徐一杰
 * @date 2024/10/31 15:29
 * @description 用户相关的请求
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

    // RequestMapping 可以接收 GET 何 POST 请求
    //@RequestMapping("/login")
    // 只接收 GET 请求
    //@GetMapping("/login")
    // 只接收 POST 请求
    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        // 根据用户名和密码查询用户
        List<User> userList = userMapper.findUserByUsernameAndPassword(username, password);

        // 如果查询不到对应用户，登录失败
        if (userList.isEmpty()) {
            log.error("登录失败");
            model.addAttribute("msg", "登录失败");
            return "index";
        }

        log.info("登录成功");
        // 设置标识，已登录
        session.setAttribute("isLogin", true);
        // 重定向到 /student/getStudentList
        return "redirect:/student/getStudentList";
    }

    @PostMapping("/register")
    public String register(String username, String password, String rePassword, Model model) {
        // 两次输入密码不一致的情况
        if (!Objects.equals(password, rePassword)) {
            model.addAttribute("registerMsg", "两次输入密码不一致");
            return "index";
        }

        // 用户名已注册的情况：从数据库中查询前端传来的 username 是否已经被注册，被注册的话提示用户
        List<User> repeatUserList = userMapper.findUserByUsername(username);
        if (!repeatUserList.isEmpty()) {
            model.addAttribute("registerMsg", "用户名已注册，请更换");
            return "index";
        }

        // 把数据塞入数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertUser(user);

        // 提示用户注册成功
        model.addAttribute("msg", "注册成功，请登录");

        return "index";
    }

}

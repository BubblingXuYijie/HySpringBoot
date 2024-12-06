package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Test;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 徐一杰
 * @date 2024/12/5 15:50
 * @description
 */
@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @GetMapping("/a")
    public String a(String name) {
        return name;
    }

    @GetMapping("/b")
    public String b(@RequestParam String name) {
        return name;
    }

    @GetMapping("/c")
    public String c(@RequestParam(defaultValue = "xyj") String name) {
        return name;
    }

    @GetMapping("/d")
    public String d(@RequestParam(required = false) String name) {
        return name;
    }

    @GetMapping("/e")
    public String e(@RequestParam(name = "aaaaa") String name) {
        return name;
    }

    @GetMapping("/f/{name}")
    public String f(@PathVariable String name) {
        return name;
    }

    @GetMapping("/g")
    public String g(
            @NotNull(message = "姓名不能为空") String name,
            @Email(message = "邮件格式不正确") @NotNull String email,
            @Range(min = 0, max = 10, message = "数据范围超出") Integer count) {
        return name;
    }

    @GetMapping("/h")
    public Test h(@Validated Test test) {
        return test;
    }

}

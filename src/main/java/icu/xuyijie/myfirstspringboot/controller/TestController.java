package icu.xuyijie.myfirstspringboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author 徐一杰
 * @date 2024/12/5 15:50
 * @description
 */
@RestController
@RequestMapping("/test")
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

}

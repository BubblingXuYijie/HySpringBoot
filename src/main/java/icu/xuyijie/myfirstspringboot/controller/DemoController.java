package icu.xuyijie.myfirstspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 徐一杰
 * @date 2024/10/28 14:48
 * @description
 */
@RequestMapping("/demo")
// 代表下面方法的返回值是数据本身，返回类型不限于 string
@RestController
public class DemoController {
    @RequestMapping("/print")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/print2")
    public List<Integer> print2() {
        return List.of(1, 21, 3);
    }

    @RequestMapping("/print3")
    public Map<String, String> print3() {
        return Map.of("key1", "value1", "key2", "value2");
    }
}

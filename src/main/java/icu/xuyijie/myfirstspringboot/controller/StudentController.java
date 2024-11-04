package icu.xuyijie.myfirstspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 徐一杰
 * @date 2024/11/4 13:45
 * @description 学生相关操作
 */
@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @RequestMapping("/getStudentList")
    public String getStudentList() {
        // 查询学生数据，赋值给页面展示

        return "studentList";
    }
}

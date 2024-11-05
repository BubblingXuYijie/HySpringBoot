package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Student;
import icu.xuyijie.myfirstspringboot.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/11/4 13:45
 * @description 学生相关操作
 */
@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/getStudentList")
    public String getStudentList(Model model) {
        // 1 查询学生数据
        List<Student> studentList = studentMapper.getStuentList();

        // 2 赋值给页面展示
        model.addAttribute("dataList", studentList);

        return "studentList";
    }
}

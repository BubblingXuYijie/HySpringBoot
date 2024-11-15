package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Student;
import icu.xuyijie.myfirstspringboot.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/getStudentList")
    public String getStudentList(Model model, String name, @RequestParam(name = "class", required = false) String className) {
        log.info("查询参数：{}--{}", name, className);

        // 1 查询学生数据
        List<Student> studentList = studentMapper.getStuentList(name, className);

        // 2 赋值给页面展示
        model.addAttribute("dataList", studentList);

        // 3 跳转到 studentList.html 页面
        return "studentList";
    }

    @GetMapping("/delStudent")
    public String delStudent(Integer id1) {
        log.info("前端传来id：{}", id1);

        // 1、删除数据
        studentMapper.deleteStudent(id1);

        // 2、重新加载页面
        return "redirect:/student/getStudentList";
    }

    @GetMapping("/goEditStudent")
    public String goEditStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @GetMapping("/saveStudent")
    public String saveStudent() {

    }

}

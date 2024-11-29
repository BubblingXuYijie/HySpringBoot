package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Student;
import icu.xuyijie.myfirstspringboot.entity.Teacher;
import icu.xuyijie.myfirstspringboot.mapper.StudentMapper;
import icu.xuyijie.myfirstspringboot.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/getStudentList")
    public String getStudentList(Model model, String name, @RequestParam(name = "class", required = false) String className) {
        log.info("查询参数：{}--{}", name, className);

        // 1 查询学生数据
        List<Student> studentList = studentMapper.getStudentList(name, className);

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
    public String goEditStudent(Model model, Student student) {
        log.info("前端传来学生数据：{}", student);
        model.addAttribute("student", student);

        // 查询所以教师数据
        List<Teacher> teacherList = teacherMapper.findAll(null);
        // model 给前端页面
        model.addAttribute("teacherList", teacherList);

        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        // 参数接收
        log.info("表单参数：{}", student);

        // 新增操作
        if (student.getId() == null) {
            // 保存到数据库
            studentMapper.addStudent(student);
        } else {
            // 更新操作
            studentMapper.updateStudent(student);
        }

        // 刷新列表页
        return "redirect:/student/getStudentList";
    }

}

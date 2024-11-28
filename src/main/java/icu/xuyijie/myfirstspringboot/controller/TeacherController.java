package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Teacher;
import icu.xuyijie.myfirstspringboot.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/11/19 13:39
 * @description
 */
@Controller
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/getTeachList")
    public String getTeachList(Model model, String searchString){
        log.info("教师列表，查询参数：{}", searchString);

        // 查询数据库教师信息并给到前端页面
        List<Teacher> teacherList = teacherMapper.findAll(searchString);
        model.addAttribute("dataList", teacherList);

        return "teacherList";
    }

    @GetMapping("/goEditTeacher")
    public String goEditTeacher(Model model, Teacher teacher){
        log.info("前端传来教师数据：{}", teacher);
        model.addAttribute("tc", teacher);
        return "addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(Integer id, String name, String sex){
        // 新增操作
        if (id == null) {
            // 保存到数据库
            teacherMapper.addTeacher(name, sex, new Date());
        } else {
            // 更新操作
            teacherMapper.updateTeacher(id, name, sex);
        }

        // 刷新列表页
        return "redirect:/teacher/getTeachList";
    }

}

package icu.xuyijie.myfirstspringboot.controller;

import icu.xuyijie.myfirstspringboot.entity.Teacher;
import icu.xuyijie.myfirstspringboot.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getTeachList(Model model){
        log.info("教师列表");

        // 查询数据库教师信息并给到前端页面
        List<Teacher> teacherList = teacherMapper.findAll();
        model.addAttribute("dataList", teacherList);

        return "teacherList";
    }

}

package icu.xuyijie.myfirstspringboot.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import icu.xuyijie.myfirstspringboot.entity.Student;
import icu.xuyijie.myfirstspringboot.entity.Teacher;
import icu.xuyijie.myfirstspringboot.mapper.StudentMapper;
import icu.xuyijie.myfirstspringboot.mapper.TeacherMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    public String getStudentList(Model model, String name, String className, @RequestParam(defaultValue = "1") Integer pageNo) {
        // 这一行会自动拦截 studentMapper 的所有查询，为查询添加上分页函数
        try (Page<Student> page = PageMethod.startPage(pageNo, 5)) {
            // 箭头函数，lambda表达式
            page.doSelectPage(() -> studentMapper.getStudentList(name, className));

            // 获取分页查询所需参数值
            PageInfo<Student> pageInfo = new PageInfo<>(page);
            // 获取查询到学生数据
            List<Student> dataList = pageInfo.getList();

            // 2 赋值给页面展示
            model.addAttribute("dataList", dataList);
            // 获取当前页面
            model.addAttribute("pageNo", pageInfo.getPageNum());
            // 获取一共分为多少页
            int pages = pageInfo.getPages();
            model.addAttribute("pageTotal", pages);

            // 页码列表，里面是 1，2，3，4。。。
            List<Long> pageList = new ArrayList<>();
            for (long i = 0; i < pages; i++) {
                pageList.add(i + 1);
            }
            model.addAttribute("pageList", pageList);

            // 3 跳转到 studentList.html 页面
            return "studentList";
        }
    }

    @GetMapping("/delStudent")
    public String delStudent(Integer id1) {
        // 1、删除数据
        studentMapper.deleteStudent(id1);

        // 2、重新加载页面
        return "redirect:/student/getStudentList";
    }

    @GetMapping("/goEditStudent")
    public String goEditStudent(Model model, Student student) {
        model.addAttribute("student", student);

        // 查询所以教师数据
        List<Teacher> teacherList = teacherMapper.findAll(null);
        // model 给前端页面
        model.addAttribute("teacherList", teacherList);

        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
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

    @PostMapping("/upload")
    @Transactional(rollbackFor = Exception.class)
    public String upload(MultipartFile multipartFile, Integer id) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        log.info("上传文件：{}--id：{}", filename, id);

        Student student = new Student();
        student.setId(id);
        student.setImgUrl("http://127.0.0.1:8080/file/" + filename);
        studentMapper.updateStudent(student);

        // 保存前端上传的文件
        File saveFile = new File("E:/uploadFiles/" + filename);
        multipartFile.transferTo(saveFile);

        // 刷新列表页
        return "redirect:/student/getStudentList";
    }

    @GetMapping("/outputData")
    public void outputData(HttpServletResponse resp) throws IOException {
        // 查询要导出的学生数据
        List<Student> studentList = studentMapper.getStudentList(null, null);

        // 告诉浏览器，我要给你什么格式的数据
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        resp.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("学生数据excel", StandardCharsets.UTF_8);
        // 设置下载的文件名
        resp.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcelFactory
                // resp.getOutputStream 是让浏览器直接下载
                .write(resp.getOutputStream(), Student.class)
                .sheet("学生信息1")
                .doWrite(studentList);
    }

}

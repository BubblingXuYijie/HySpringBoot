package icu.xuyijie.myfirstspringboot.mapper;

import icu.xuyijie.myfirstspringboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/11/4 13:43
 * @description
 */
@Mapper
public interface StudentMapper {
    /**
     * 查询学生列表
     * @return 学生列表
     */
    @Select("SELECT s.id,s.name,s.age,s.sex,s.teacher,s.img_url,s.stu_id,s.create_time,s.is_graduate,s.class AS className,t.name AS teacherName FROM `student` s LEFT JOIN teacher t ON t.id = s.teacher;")
    List<Student> getStuentList();
}

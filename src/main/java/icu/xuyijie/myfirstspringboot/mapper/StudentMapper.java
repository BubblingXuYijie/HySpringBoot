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
    @Select("SELECT s.*,t.name as teacherName FROM `student` s LEFT JOIN teacher t ON t.id = s.teacher;")
    List<Student> getStuentList();
}

package icu.xuyijie.myfirstspringboot.mapper;

import icu.xuyijie.myfirstspringboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/11/19 13:45
 * @description
 */
@Mapper
public interface TeacherMapper {

    //@Select("SELECT * FROM teacher WHERE name LIKE CONCAT('%', #{searchString}, '%')")
    List<Teacher> findAll(String searchString);

    int addTeacher(String name, String sex, Date createTime);

    int updateTeacher(Integer id, String name, String sex);

}

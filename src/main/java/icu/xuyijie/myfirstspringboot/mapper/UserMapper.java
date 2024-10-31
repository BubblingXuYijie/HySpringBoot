package icu.xuyijie.myfirstspringboot.mapper;

import icu.xuyijie.myfirstspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/10/31 16:27
 * @description
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();
}

package icu.xuyijie.myfirstspringboot.mapper;

import icu.xuyijie.myfirstspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 徐一杰
 * @date 2024/10/31 16:27
 * @description user 表 mapper
 */
@Mapper
public interface UserMapper {
    /**
     * 查询全部用户
     * @return 全部用户列表
     */
    @Select("SELECT * FROM user")
    List<User> findAll();
}

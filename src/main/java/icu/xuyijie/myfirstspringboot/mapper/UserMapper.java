package icu.xuyijie.myfirstspringboot.mapper;

import icu.xuyijie.myfirstspringboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     * 根据用户名和密码查询用户
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @return 用户列表
     */
    @Select("SELECT * FROM user WHERE username = #{username11} AND password = #{password}")
    List<User> findUserByUsernameAndPassword(@Param("username11") String username, String password);

    /**
     * 插入数据
     * @param user user 对象
     * @return 插入的条数
     */
    @Insert("INSERT INTO user (username, password, create_time) VALUES (#{username}, #{password}, CURRENT_TIMESTAMP)")
    int insertUser(User user);
}

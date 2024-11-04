package icu.xuyijie.myfirstspringboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/10/31 16:24
 * @description 与数据库 user 表映射
 */
// 自动生成 getter 和 setter 还有 toString
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
}

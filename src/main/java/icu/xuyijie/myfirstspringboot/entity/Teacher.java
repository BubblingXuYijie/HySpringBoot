package icu.xuyijie.myfirstspringboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/11/19 13:42
 * @description 教师实体类，对应 MySQL 的 teacher 教师表
 */
@Data
public class Teacher {
    private Integer id;
    private String name;
    private String sex;
    private Date createTime;
}

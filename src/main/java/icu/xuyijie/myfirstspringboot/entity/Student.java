package icu.xuyijie.myfirstspringboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/11/4 13:40
 * @description 映射 student 数据库表
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private String imgUrl;
    private Integer age;
    private String sex;
    private String stuId;
    private String className;
    private Integer teacher;
    private Boolean isGraduate;
    private Date createTime;

    private Teacher teacherInfo;
}

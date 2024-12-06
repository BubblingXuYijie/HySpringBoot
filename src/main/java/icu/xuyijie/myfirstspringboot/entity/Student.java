package icu.xuyijie.myfirstspringboot.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/11/4 13:40
 * @description 映射 student 数据库表
 */
@Data
@ColumnWidth(12)
public class Student {
    private Integer id;

    @ExcelProperty("姓名")
    private String name;

    @ColumnWidth(50)
    @ExcelProperty("图片URL")
    private String imgUrl;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("学号")
    @ColumnWidth(15)
    private String stuId;

    @ExcelProperty("班级")
    private String className;

    @ExcelProperty("辅导员ID")
    private Integer teacher;

    @ExcelProperty("是否毕业")
    private Boolean isGraduate;

    @ColumnWidth(20)
    @ExcelProperty("入学时间")
    private Date createTime;

    @ExcelIgnore
    private Teacher teacherInfo;
}

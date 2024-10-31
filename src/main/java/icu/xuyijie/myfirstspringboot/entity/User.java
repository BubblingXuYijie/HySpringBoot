package icu.xuyijie.myfirstspringboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/10/31 16:24
 * @description
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
}

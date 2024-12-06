package icu.xuyijie.myfirstspringboot.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author 徐一杰
 * @date 2024/12/6 8:50
 * @description
 */
@Data
public class Test {
    @NotEmpty(message = "姓名不能为空字符串")
    private String name;
}

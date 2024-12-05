package icu.xuyijie.myfirstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 徐一杰
 * @date 2024/10/29 13:41
 * @description 主启动类
 */
@SpringBootApplication
@EnableTransactionManagement
public class MyFirstSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringBootApplication.class, args);
    }

}

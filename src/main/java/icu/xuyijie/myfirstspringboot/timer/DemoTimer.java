package icu.xuyijie.myfirstspringboot.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 徐一杰
 * @date 2024/12/12 10:36
 * @description 定时任务
 */
@Component
public class DemoTimer {
    @Scheduled(fixedRate = 3000)
    public void timer() {
        System.out.println(new Date());
    }
}

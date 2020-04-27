package com.candymanage.candy.service.task;


import cn.hutool.core.date.DateUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@Configuration   //主要用户标记配置列，兼备Component的效果
@EnableScheduling  // 开启定时任务
public class ScheduledTask {
    //添加定时任务
    @Scheduled(cron ="0/59 * * * * ?")
    private  void configureTasks(){
        Thread thread = new Thread();

        System.out.println(" thread-" +thread.getName()+ DateUtil.now());
    }


}

package org.example.springboot.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.scheduled.config.ScheduledConfiguration;
import org.example.springboot.scheduled.model.Danmuk;
import org.example.springboot.scheduled.service.ScheduledService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Component
public class ScheduledTask {

    @Resource
    ScheduledService scheduledService;

    @Resource
    ScheduledConfiguration configuration;

    @Scheduled(cron = "*/2 * * * * *")
    public void myTask() {
        // 定时任务逻辑...
        Danmuk danmuk = scheduledService.findById(configuration.getId());
        log.info("task: {}", danmuk);
        if (Objects.isNull(danmuk)){
            configuration.setId("0");
        } else {
            configuration.setId(String.valueOf(Integer.parseInt(configuration.getId()) + 1));
        }
    }

}

package org.example.springboot.scheduled.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Slf4j
@Validated
@Component
@Configuration
@ConfigurationProperties(
        prefix = "springboot"
)
public class ScheduledConfiguration {

    private String id;

    @NotNull(message = "缺少属性配置：springboot.id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        log.info("springboot.id:{}", this.id);
    }
}

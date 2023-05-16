package org.example.springboot.scheduled;

import org.example.springboot.RootApplication;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static java.lang.System.setProperty;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RootApplication.class)
public class ScheduledTaskTest {

    @BeforeClass
    public static void beforeClass(){
        setProperty("spring.config.additional-location", "classpath:/config/*/");
    }

    @Resource
    ScheduledTask task;

    @Test
    public void demo(){
        task.myTask();
    }
}

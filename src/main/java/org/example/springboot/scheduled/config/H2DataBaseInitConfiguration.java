package org.example.springboot.scheduled.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.RunScript;
import org.h2.tools.Script;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;

@Slf4j
@Component
@DependsOn("dataSource")
public class H2DataBaseInitConfiguration {

    @Resource
    DataSource dataSource;

    @PostConstruct
    public void initDataBase() {
        log.info("H2DataBaseInitConfiguration init.");
        try (Connection conn = dataSource.getConnection()) {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource("database/database-init-timestamp.sql");
            URL initData = classLoader.getResource("database/database-init-data.sql");
            RunScript.execute(conn, new FileReader(new File(resource.toURI())));
            RunScript.execute(conn, new FileReader(new File(initData.toURI())));
            //Script.main("-url","jdbc:h2:mem:activiti", "-user", "sa", "-script", "test.zip", "-options", "compression", "zip");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        log.info("H2DataBaseInitConfiguration finished.");
    }

}

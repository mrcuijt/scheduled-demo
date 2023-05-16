package org.example.springboot.scheduled.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.scheduled.config.ScheduledConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("action")
public class ActionController {

    @Resource
    ScheduledConfiguration configuration;

    @RequestMapping("id/{id}")
    @ResponseBody
    public Map id(@PathVariable String id){
        configuration.setId(id);
        return success();
    }

    public Map<String, Object> success(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("code", 200);
        dataMap.put("msg", "success");
        return dataMap;
    }
}

package org.example.springboot.scheduled.service.impl;

import org.example.springboot.scheduled.model.Danmuk;
import org.example.springboot.scheduled.service.ScheduledService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    private static final String LOAN_SYS_DANMUK_MAPPER = "danmukmanager.DanmukMapper.";

    @Resource
    private SqlSessionTemplate template;

    @Override
    public Danmuk findById(String id) {
        return template.selectOne(LOAN_SYS_DANMUK_MAPPER + "findById", id);
    }
}

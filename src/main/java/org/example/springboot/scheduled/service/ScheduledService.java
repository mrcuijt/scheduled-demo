package org.example.springboot.scheduled.service;

import org.example.springboot.scheduled.model.Danmuk;

public interface ScheduledService {

    Danmuk findById(String id);
}

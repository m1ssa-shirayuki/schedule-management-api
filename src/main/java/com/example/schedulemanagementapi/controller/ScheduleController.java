package com.example.schedulemanagementapi.controller;

import com.example.schedulemanagementapi.dto.Schedule;
import com.example.schedulemanagementapi.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 全件取得
    @GetMapping
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

    @PostMapping
    public Schedule insert(@RequestBody Schedule schedule) {
        scheduleService.insert(schedule);
        return schedule;
    }
}
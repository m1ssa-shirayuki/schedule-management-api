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

    // 1件取得
    @GetMapping("/{id}")
    public Schedule findById(@PathVariable Integer id) {
        return scheduleService.findById(id);
    }

    // スケジュール削除
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        int result = scheduleService.deleteById(id);

        if (result == 0) {
            return "指定されたスケジュールが見つかりません";
        }

        return "スケジュールを削除しました";
    }

    // スケジュール更新
    @PutMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @RequestBody Schedule schedule) {

        schedule.setId(id);

        int result = scheduleService.update(schedule);

        if (result == 0) {
            return "指定されたスケジュールが見つかりません";
        }

        return "スケジュールを更新しました";
    }
}
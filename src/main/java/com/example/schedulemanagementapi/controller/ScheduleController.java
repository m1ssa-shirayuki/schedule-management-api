package com.example.schedulemanagementapi.controller;

import com.example.schedulemanagementapi.dto.Schedule;
import com.example.schedulemanagementapi.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Schedule>> findAll() {
        return ResponseEntity.ok(scheduleService.findAll());
    }

    // スケジュール登録
    @PostMapping
    public ResponseEntity<Schedule> insert(@Valid @RequestBody Schedule schedule) {
        scheduleService.insert(schedule);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(schedule);
    }

    // 1件取得
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> findById(@PathVariable Integer id) {
        Schedule schedule = scheduleService.findById(id);

        if (schedule == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(schedule);
    }

    // スケジュール削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        int result = scheduleService.deleteById(id);

        if (result == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }

    // スケジュール更新
    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Integer id,
            @Valid @RequestBody Schedule schedule) {

        schedule.setId(id);

        int result = scheduleService.update(schedule);

        if (result == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("スケジュールを更新しました");
    }
}
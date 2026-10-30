package com.example.schedulemanagementapi.service;

import com.example.schedulemanagementapi.dto.Schedule;
import com.example.schedulemanagementapi.repoisitory.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // スケジュール全件取得
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    // スケジュール登録
    public int insert(Schedule schedule) {
        return scheduleRepository.insert(schedule);
    }

    // スケジュール1件取得
    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }

    // スケジュール削除
    public int deleteById(int id) {
        return scheduleRepository.deleteById(id);
    }

    // スケジュール更新
    public int update(Schedule schedule) {
        return scheduleRepository.update(schedule);
    }
}
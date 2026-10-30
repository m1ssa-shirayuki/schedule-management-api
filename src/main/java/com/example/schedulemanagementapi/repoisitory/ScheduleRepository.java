package com.example.schedulemanagementapi.repoisitory;

import com.example.schedulemanagementapi.dto.Schedule;
import com.example.schedulemanagementapi.mapper.ScheduleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    private final ScheduleMapper scheduleMapper;
    public ScheduleRepository(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public List<Schedule> findAll() {
        return scheduleMapper.findAll();
    }

    public int insert(Schedule schedule) {
        return scheduleMapper.insert(schedule);
    }

    public Schedule findById(int id) {
        return scheduleMapper.findById(id);
    }

    public int deleteById(int id) {
        return scheduleMapper.deleteById(id);
    }

    // スケジュール更新
    public int update(Schedule schedule) {
        return scheduleMapper.update(schedule);
    }
}

package com.example.schedulemanagementapi.service;

import com.example.schedulemanagementapi.dto.Schedule;
import com.example.schedulemanagementapi.reoisitory.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public int insert(Schedule schedule) {
        return scheduleRepository.insert(schedule);
    }

    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }
}

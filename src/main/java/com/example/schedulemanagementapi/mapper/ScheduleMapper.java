package com.example.schedulemanagementapi.mapper;

import com.example.schedulemanagementapi.dto.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    @Select("SELECT id, title, description, date, start_time AS \"startTime\", end_time AS \"endTime\", category, completed FROM schedules ORDER BY date, start_time")
    List<Schedule> findAll();

    @Insert("INSERT INTO schedules (title, description, date, start_time, end_time, category, completed) VALUES (#{title}, #{description}, #{date}, #{startTime}, #{endTime}, #{category}, COALESCE(#{completed}, FALSE))")

    @Options(useGeneratedKeys = true, keyProperty = "id") int insert(Schedule schedule);

    @Select("SELECT id, titlem description, date,start_time AS \"startTime\", end_time AS \"endTime\", category, completed FROM schedules WHERE id = #{id}")
    Schedule findById(Integer id);
}

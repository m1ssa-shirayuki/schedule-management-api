package com.example.schedulemanagementapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Schedule {

    private Integer id;

    @NotBlank(message = "タイトルは必須です")
    private String title;

    private String description;

    @NotNull(message = "日付は必須です")
    private LocalDate date;

    @NotNull(message = "開始時刻は必須です")
    private LocalTime startTime;

    @NotNull(message = "終了時刻は必須です")
    private LocalTime endTime;

    private String category;

    private Boolean completed;
}
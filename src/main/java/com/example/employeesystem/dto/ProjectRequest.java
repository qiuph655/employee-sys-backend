package com.example.employeesystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


public class ProjectRequest {
    @NotBlank(message = "名字不能爲空")
    private String name;

    @NotBlank(message = "狀態碼不能爲空")
    private String status;  // ACTIVE, COMPLETED

    @NotNull(message = "開始日期不能爲空")
    private LocalDate startDate;

    private LocalDate endDate;

    @Size(max = 200,message = "描述不能大於200字")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
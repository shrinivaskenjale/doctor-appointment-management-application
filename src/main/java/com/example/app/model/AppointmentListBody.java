package com.example.app.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentListBody {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

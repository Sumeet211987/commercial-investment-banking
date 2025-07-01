package com.cib.portfolio.entity.Dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PortfolioHistoryDto {
    private LocalDate date;
    private double value;

    public PortfolioHistoryDto(LocalDate date, double value) {
        this.date = date;
        this.value = value;
    }

    
}

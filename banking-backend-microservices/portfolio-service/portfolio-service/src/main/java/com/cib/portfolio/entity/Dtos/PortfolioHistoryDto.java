package com.cib.portfolio.entity.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PortfolioHistoryDto {

    private String BusinessName;
    private double amount;
    private LocalDate dateInvested;
    public LocalDate startdate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LocalDate enddate;

    public PortfolioHistoryDto(String businessName, double amount, LocalDate dateInvested, LocalDate startdate, LocalDate enddate) {
        BusinessName = businessName;
        this.amount = amount;
        this.dateInvested = dateInvested;
        this.startdate = startdate;
        this.enddate = enddate;
    }
}

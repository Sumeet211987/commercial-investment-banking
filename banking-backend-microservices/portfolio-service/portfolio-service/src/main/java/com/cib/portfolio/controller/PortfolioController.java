package com.cib.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cib.portfolio.entity.Portfolio;
import com.cib.portfolio.entity.Dtos.PortfolioHistoryDto;
import com.cib.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Portfolio>> getPortfolio(@PathVariable Long userId) {
    	List<Portfolio> portfolios =portfolioService.getPortfolioSummary(userId);
    	return ResponseEntity.ok(portfolios);
    }

    @GetMapping("/{userId}/history")
    public ResponseEntity<List<PortfolioHistoryDto>> getHistory(@PathVariable Long userId) {
    	List<PortfolioHistoryDto> history = portfolioService.getPortfolioHistory(userId);
    
    	return ResponseEntity.ok(history);
    }
}
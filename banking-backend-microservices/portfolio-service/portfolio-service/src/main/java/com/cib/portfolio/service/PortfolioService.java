package com.cib.portfolio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cib.portfolio.Exception.ResoureNotFoundException;
import com.cib.portfolio.entity.Portfolio;
import com.cib.portfolio.entity.Dtos.PortfolioHistoryDto;
import com.cib.portfolio.repository.PortfolioRepository;

@Service
public class PortfolioService {
	@Autowired
	private PortfolioRepository portfolioRepository;

	public List<Portfolio> getPortfolioSummary(Long userId) {
		List<Portfolio> portfolios = portfolioRepository.findAllByUserId(userId);
		if (portfolios == null || portfolios.isEmpty()) {
			throw new ResoureNotFoundException("Portfolio not found for user ID: " + userId);
		}
		return portfolios;
	}

	public List<PortfolioHistoryDto> getPortfolioHistory(Long userId) {
		return List.of(new PortfolioHistoryDto(LocalDate.now().minusDays(1), 50000),
                new PortfolioHistoryDto(LocalDate.now(), 52000));
	}
	
	
	
	
    
}
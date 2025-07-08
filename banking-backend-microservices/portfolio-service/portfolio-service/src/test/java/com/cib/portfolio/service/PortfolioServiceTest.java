package com.cib.portfolio.service;

import com.cib.portfolio.Exception.ResoureNotFoundException;
import com.cib.portfolio.entity.Dtos.PortfolioHistoryDto;
import com.cib.portfolio.entity.Portfolio;
import com.cib.portfolio.entity.PortfolioStatus;
import com.cib.portfolio.entity.User;
import com.cib.portfolio.repository.PortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PortfolioServiceTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private PortfolioService portfolioService;

    private User mockUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock User setup
        mockUser = new User();
        mockUser.setId(1L);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        mockUser.setEmailId("john.doe@example.com");
        mockUser.setRole("INVESTOR");
        mockUser.setStartdate(LocalDate.now().minusYears(1));
    }

    // ✅ Test case: getPortfolioSummary with valid user ID
    @Test
    void testGetPortfolioSummary_Success() {
        Long userId = 1L;

        Portfolio portfolio1 = new Portfolio();
        portfolio1.setId(101L);
        portfolio1.setPortfolioNumber("P1001");
        portfolio1.setPortfolioType("EQUITY");
        portfolio1.setStatus(PortfolioStatus.ACTIVE);
        portfolio1.setStartdate(LocalDate.now().minusDays(30));
        portfolio1.setUser(mockUser);

        Portfolio portfolio2 = new Portfolio();
        portfolio2.setId(102L);
        portfolio2.setPortfolioNumber("P1002");
        portfolio2.setPortfolioType("BONDS");
        portfolio2.setStatus(PortfolioStatus.ACTIVE);
        portfolio2.setStartdate(LocalDate.now().minusDays(60));
        portfolio2.setUser(mockUser);

        when(portfolioRepository.findAllByUserId(userId)).thenReturn(List.of(portfolio1, portfolio2));

        List<Portfolio> result = portfolioService.getPortfolioSummary(userId);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("EQUITY", result.get(0).getPortfolioType());
        assertEquals("BONDS", result.get(1).getPortfolioType());
    }

    // ✅ Test case: getPortfolioSummary throws exception when user has no portfolios
    @Test
    void testGetPortfolioSummary_ThrowsException_WhenEmpty() {
        Long userId = 99L;
        when(portfolioRepository.findAllByUserId(userId)).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(ResoureNotFoundException.class, () -> {
            portfolioService.getPortfolioSummary(userId);
        });

        assertTrue(exception.getMessage().contains("Portfolio not found for user ID: " + userId));
    }

    // ✅ Test case: getPortfolioHistory returns hardcoded values
    @Test
    void testGetPortfolioHistory_ReturnsHardcodedData() {
        Long userId = 1L;

        List<PortfolioHistoryDto> result = portfolioService.getPortfolioHistory(userId);

        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("Agro", result.get(0).getBusinessName());
        assertEquals(50000.00, result.get(0).getAmount());
        assertEquals("Virtusa", result.get(1).getBusinessName());
        assertNull(result.get(1).getEnddate());
    }
}

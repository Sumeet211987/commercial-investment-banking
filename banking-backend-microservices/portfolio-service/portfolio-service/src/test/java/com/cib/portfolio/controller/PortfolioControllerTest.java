package com.cib.portfolio.controller;

import com.cib.portfolio.entity.Dtos.PortfolioHistoryDto;
import com.cib.portfolio.entity.Portfolio;
import com.cib.portfolio.entity.PortfolioStatus;
import com.cib.portfolio.entity.User;
import com.cib.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortfolioService portfolioService;

    // ✅ Test for /api/portfolio/{userId}
    @Test
    void testGetPortfolioSummary() throws Exception {
        Long userId = 1L;

        User user = new User();
        user.setId(userId);
        user.setFirstName("John");

        Portfolio portfolio = new Portfolio();
        portfolio.setId(101L);
        portfolio.setPortfolioNumber("P1001");
        portfolio.setPortfolioType("EQUITY");
        portfolio.setStatus(PortfolioStatus.ACTIVE);
        portfolio.setStartdate(LocalDate.now().minusDays(10));
        portfolio.setUser(user);

        when(portfolioService.getPortfolioSummary(userId)).thenReturn(List.of(portfolio));

        mockMvc.perform(get("/api/portfolio/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].portfolioNumber", is("P1001")))
                .andExpect(jsonPath("$[0].portfolioType", is("EQUITY")));
    }

    // ✅ Test for /api/portfolio/{userId}/history
    @Test
    void testGetPortfolioHistory() throws Exception {
        Long userId = 1L;

        PortfolioHistoryDto dto1 = new PortfolioHistoryDto(
                "Agro", 50000.0,
                LocalDate.now().minusDays(2),
                LocalDate.now().minusDays(1),
                LocalDate.now());

        PortfolioHistoryDto dto2 = new PortfolioHistoryDto(
                "Virtusa", 10000.0,
                LocalDate.now().minusDays(3),
                LocalDate.now().minusDays(2),
                null);

        when(portfolioService.getPortfolioHistory(userId)).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/portfolio/{userId}/history", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].businessName", is("Agro")))
                .andExpect(jsonPath("$[1].businessName", is("Virtusa")));
    }
}


--
-- Funds Table
--

CREATE TABLE IF NOT EXISTS funds (
    id BIGSERIAL PRIMARY KEY,
    fund_name VARCHAR(255) NOT NULL,
    performance VARCHAR(100) NOT NULL,
    return_rate VARCHAR(50) NOT NULL,
    risk_profile VARCHAR(50) NOT NULL,
    sector VARCHAR(100) NOT NULL
);


INSERT INTO funds VALUES (101, 'Technology Alpha', 'last 1 year 2 months', '+12.5%', 'Medium', 'Technology');
INSERT INTO funds VALUES (102, 'HealthCare Growth', 'last 30 days', '-8.9%', 'Low', 'HealthCare');
INSERT INTO funds VALUES (103, 'Green Energy Prime', 'last 6 months', '+15.2%', 'High', 'Energy');
INSERT INTO funds VALUES (104, 'Real Estate Income', 'last 1 year', '+6.8%', 'Moderate', 'Real Estate');
INSERT INTO funds VALUES (105, 'FinTech Future', 'last 2 years', '+10.0%', 'High', 'Finance');

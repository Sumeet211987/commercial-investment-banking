--
-- Portfolios Table
--

CREATE TABLE IF NOT EXISTS portfolios (
    id BIGSERIAL PRIMARY KEY,
    portfolio_number VARCHAR(255),
    portfolio_type VARCHAR(255),
    start_date DATE,
    end_date DATE,
    status VARCHAR(255),
    user_id INTEGER
);

INSERT INTO portfolios VALUES (1, 'PORT1001', 'SAVINGS', '2025-06-01', NULL, 'ACTIVE', 1);
INSERT INTO portfolios VALUES (2, 'PORT1002', 'CURRENT', '2025-06-02', NULL, 'ACTIVE', 1);
INSERT INTO portfolios VALUES (3, 'PORT1003', 'SAVINGS', '2025-06-03', NULL, 'ACTIVE', 2);
INSERT INTO portfolios VALUES (4, 'PORT1004', 'CURRENT', '2025-06-04', NULL, 'INACTIVE', 2);
INSERT INTO portfolios VALUES (5, 'PORT1005', 'SAVINGS', '2025-06-05', NULL, 'ACTIVE', 3);


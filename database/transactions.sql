--
-- PostgreSQL database dump
--

CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    comments VARCHAR(255),
    enddate DATE,
    referenceid VARCHAR(100) NOT NULL,
    startdate DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
    transactiondate DATE NOT NULL,
    transactiontype VARCHAR(50) NOT NULL,
    update_date TIMESTAMP(6) WITHOUT TIME ZONE,
    portfolioid BIGINT NOT NULL,
    amount DOUBLE PRECISION,
    end_date DATE,
    fund_id BIGINT,
    reference_id VARCHAR(100),
    start_date DATE,
    transaction_date DATE,
    transaction_type VARCHAR(50),
    user_id BIGINT,
    
    CONSTRAINT fk_portfolio FOREIGN KEY (portfolioid)
        REFERENCES portfoliotransaction (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    
    CONSTRAINT transactions_status_check CHECK (
        status IN ('PENDING', 'PROCESSING', 'COMPLETED', 'FAILED', 'CANCELLED', 'REVERSED')
    )
);


INSERT INTO transactions VALUES (1, 'Sample transaction for testing.', '2025-07-11', 'TXN123456', '2025-07-11', 'COMPLETED', '2025-07-11', 'INVESTMENT', '2025-07-11 12:26:50.125745', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO transactions VALUES (2, 'Another transaction for testing.', '2025-07-12', 'TXN123457', '2025-07-12', 'PENDING', '2025-07-12', 'WITHDRAWAL', '2025-07-12 14:30:00.000000', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO transactions VALUES (3, 'Transaction with no comments.', '2025-07-13', 'TXN123458', '2025-07-13', 'FAILED', '2025-07-13', 'TRANSFER', '2025-07-13 16:45:30.000000', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO transactions VALUES (4, 'Transaction with a long comment to test text handling in the database.', '2025-07-14', 'TXN123459', '2025-07-14', 'CANCELLED', '2025-07-14', 'DEPOSIT', '2025-07-14 18:00:00.000000', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO transactions VALUES (5, 'Final transaction for testing purposes.', '2025-07-15', 'TXN123460', '2025-07-15', 'REVERSED', '2025-07-15', 'REDEMPTION', '2025-07-15 20:15:00.000000', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);




-- 
-- INSERT INTO transactions VALUES (1, 'comment', '2025-07-14', 'TXN0001', '2025-07-14', 'FAILED', '2025-07-14', 'BUY', '2025-07-14 12:29:30.401273', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (2, 'Monthly SIP investment', '2025-07-31', 'TXN123458942234', '2025-07-01', 'COMPLETED', '2025-07-16', 'WITHDRAW', '2025-07-16 14:29:18.466337', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (3, 'Monthly SIP investment', '2025-07-31', 'TXN123458942234', '2025-07-01', 'COMPLETED', '2025-07-17', 'WITHDRAW', '2025-07-17 12:24:53.985658', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (4, 'Monthly SIP investment', '2025-07-31', 'TXN123458942234', '2025-07-01', 'FAILED', '2025-07-17', 'WITHDRAW', '2025-07-17 12:29:28.91813', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (5, 'Test', '2025-07-31', 'TXN999922242', '2025-07-01', 'COMPLETED', '2025-07-17', 'WITHDRAW', '2025-07-17 12:31:23.364736', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (6, 'Test', '2025-07-31', 'TXN999922242', '2025-07-01', 'COMPLETED', '2025-07-17', 'WITHDRAW', '2025-07-17 14:29:14.314245', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO transactions VALUES (7, 'Test', '2025-07-31', 'TXN999922242', '2025-07-01', 'COMPLETED', '2025-07-18', 'WITHDRAW', '2025-07-18 08:44:56.904459', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
-- 

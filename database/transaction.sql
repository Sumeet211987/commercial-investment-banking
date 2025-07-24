--
-- Transaction Table
--

CREATE TABLE IF NOT EXISTS transaction (
    id BIGSERIAL PRIMARY KEY,
    comments TEXT,
    end_date DATE NOT NULL,
    reference_id VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    transaction_date DATE NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    update_date TIMESTAMP(6) WITHOUT TIME ZONE,
    portfolioid BIGINT,
    
    CONSTRAINT fk_portfolio FOREIGN KEY (portfolioid)
        REFERENCES portfolio (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
        
    CONSTRAINT transaction_status_check CHECK (
        status IN ('PENDING', 'PROCESSING', 'COMPLETED', 'FAILED', 'CANCELLED', 'REVERSED')
    )
);


INSERT INTO transaction VALUES (1, 'Sample transaction for testing.', '2025-07-11', 'TXN123456', '2025-07-11', 'COMPLETED', '2025-07-11', 'INVESTMENT', '2025-07-11 12:26:50.125745', 1);
INSERT INTO transaction VALUES (2, 'Another transaction for testing.', '2025-07-12', 'TXN123457', '2025-07-12', 'PENDING', '2025-07-12', 'WITHDRAWAL', '2025-07-12 14:30:00.000000', 2);
INSERT INTO transaction VALUES (3, 'Transaction with no comments.', '2025-07-13', 'TXN123458', '2025-07-13', 'FAILED', '2025-07-13', 'TRANSFER', '2025-07-13 16:45:30.000000', 3);
INSERT INTO transaction VALUES (4, 'Transaction with a long comment to test text handling in the database.', '2025-07-14', 'TXN123459', '2025-07-14', 'CANCELLED', '2025-07-14', 'DEPOSIT', '2025-07-14 18:00:00.000000', 4);
INSERT INTO transaction VALUES (5, 'Final transaction for testing purposes.', '2025-07-15', 'TXN123460', '2025-07-15', 'REVERSED', '2025-07-15', 'REDEMPTION', '2025-07-15 20:15:00.000000', 5);


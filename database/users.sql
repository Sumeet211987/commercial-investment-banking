--
-- Users Table
--

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    emailid VARCHAR(255) NOT NULL UNIQUE,
    phonenumber VARCHAR(20),
    address_id BIGINT,
    identitynumber VARCHAR(50) UNIQUE,
    role VARCHAR(50) NOT NULL,
    portfolio_id BIGINT,
    startdate DATE NOT NULL,
    updateddate TIMESTAMP(6) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    enddate DATE,
    username VARCHAR(255),
    password VARCHAR(255),

    CONSTRAINT fk_address_id FOREIGN KEY (address_id)
        REFERENCES addresses(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


INSERT INTO users VALUES (1, 'Nithish', 'Kumar', 'nithish@example.com', '9876543210', 1, 'ID1001', 'USER', 1, '2025-06-01', NULL, NULL, 'raamu', '$2a$12$bTPy6qWHHMb1kUQQrcwsv./K/T8ecMUZy8oo21suGWFTp7sYkW7mC');
INSERT INTO users VALUES (2, 'Priya', 'R', 'priya@example.com', '9876543211', 2, 'ID1002', 'USER', 2, '2025-06-02', NULL, NULL, 'sachin', '$2a$12$LSZUebcpbpWxjcqSSflktelQ8atHkcVloUybYmuPowVXNIF0oZ4vC');
INSERT INTO users VALUES (3, 'Rahul', 'Sharma', 'rahul@example.com', '9876543212', 3, 'ID1003', 'ADMIN', 3, '2025-06-03', NULL, NULL, 'subha', '$2a$12$/mMll2Pc7VdSBIhLXLmh1O9.4nXOvlDvFfYxN9gSpC3n51uFVbdP.');
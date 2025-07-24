--
-- Addresses Table
--

CREATE TABLE IF NOT EXISTS addresses (
    id BIGSERIAL PRIMARY KEY,
    address1 VARCHAR(255) NOT NULL,
    address2 VARCHAR(255),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100),
    pincode VARCHAR(20),
    country VARCHAR(100) NOT NULL,
    startdate DATE NOT NULL,
    updateddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enddate DATE
);


INSERT INTO addresses VALUES (1, '456 Ring Road', 'Sector 10', 'New Delhi', 'Delhi', '110001', 'India', '2025-06-05', NULL, NULL);
INSERT INTO addresses VALUES (2, '789 Marine Drive', 'Opp. Gateway', 'Mumbai', 'Maharashtra', '400001', 'India', '2025-06-10', NULL, NULL);
INSERT INTO addresses VALUES (3, '321 Park Street', 'Next to Mall', 'Kolkata', 'West Bengal', '700001', 'India', '2025-06-12', NULL, NULL);
INSERT INTO addresses VALUES (4, '987 MG Road', 'Near Metro', 'Bangalore', 'Karnataka', '560001', 'India', '2025-06-18', NULL, NULL);
INSERT INTO addresses VALUES (5, '147 Gandhi Road', 'Opp. Museum', 'Ahmedabad', 'Gujarat', '380001', 'India', '2025-06-20', NULL, NULL);
--
-- Portfolio Tansaction Table
--

CREATE TABLE IF NOT EXISTS portfoliotransaction (
    id BIGSERIAL PRIMARY KEY,
    portfolionumber VARCHAR(255),
    portfoliotype VARCHAR(255),
    startdate DATE,
    enddate DATE,
    updateddate DATE,
    status VARCHAR(255),
    userid INTEGER
);


INSERT INTO portfoliotransaction VALUES (1, 'PORT1001', 'Equity', '2025-06-01', NULL, NULL, 'ACTIVE', 1);
INSERT INTO portfoliotransaction VALUES (2, 'PORT1002', 'Equity', '2025-06-02', NULL, NULL, 'ACTIVE', 1);
INSERT INTO portfoliotransaction VALUES (3, 'PORT1003', 'Savings', '2025-06-03', NULL, NULL, 'ACTIVE', 2);
INSERT INTO portfoliotransaction VALUES (4, 'PORT1004', 'Current', '2025-06-04', NULL, NULL, 'INACTIVE', 2);
INSERT INTO portfoliotransaction VALUES (5, 'PORT1005', 'Savngs', '2025-06-05', NULL, NULL, 'ACTIVE', 3);


-- 
-- INSERT INTO public.portfoliotransaction VALUES (1, '2025-07-14', 'PF1001', 'Equity', '2025-07-14', 'ACTIVE', '2025-07-14 00:00:00', 1);
-- INSERT INTO public.portfoliotransaction VALUES (2, '2025-07-16', 'PF2001', 'Equity', '2025-07-10', 'ACTIVE', '2025-07-16 00:00:00', 2);
-- 

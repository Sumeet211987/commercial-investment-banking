--
-- Customers Table
--

CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    address VARCHAR(255),
    email_id VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(100),
    identity_number INTEGER UNIQUE,
    last_name VARCHAR(100),
    password TEXT NOT NULL,
    phone_number VARCHAR(20),
    user_name VARCHAR(100) UNIQUE NOT NULL,
    user_type VARCHAR(50)
);


INSERT INTO public.customers VALUES (1, true, 'IND-MUMBAI', 'abc@gmail.com', 'sachin', 1, 'kumar', 'sachin123', '3', 'sachin1', 'Individual');
INSERT INTO public.customers VALUES (2, false, 'IND-MUMBAI', 'cde@gmail.com', 'sachin', 2, 'kumar', 'sachin123', '3', 'sachin2', 'Individual');
INSERT INTO public.customers VALUES (3, true, 'IND-MUMBAI', 'xys@gmail.com', 'sachin', 3, 'kumar', 'sachin123', '3', 'sachin3', 'Individual');
INSERT INTO public.customers VALUES (4, true, 'IND-MUMBAI', 'test@gmail.com', 'sachin', 4, 'kumar', 'sachin123', '3', 'sachin4', 'Company');
INSERT INTO public.customers VALUES (5, true, 'IND-MUMBAI', 'cib@gmail.com', 'sachin', 5, 'kumar', 'sachin123', '3', 'sachin5', 'Company');


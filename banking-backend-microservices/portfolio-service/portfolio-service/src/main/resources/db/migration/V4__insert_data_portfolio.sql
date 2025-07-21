ALTER TABLE public.portfolio
ALTER COLUMN user_id DROP NOT NULL;


-- Insert into portfolio table
INSERT INTO public.portfolio(enddate, startdate, id, updateddate, portfoliotype, status, portfolionumber)
VALUES 
  (NULL, '2025-06-01', 1, NULL,  'SAVINGS', 'ACTIVE', 'PORT1001'),
  (NULL, '2025-06-02', 2, NULL,  'CURRENT', 'ACTIVE', 'PORT1002'),
  (NULL, '2025-06-03', 3, NULL,  'SAVINGS', 'ACTIVE', 'PORT1003'),
  (NULL, '2025-06-04', 4, NULL,  'CURRENT', 'INACTIVE', 'PORT1004'),
  (NULL, '2025-06-05', 5, NULL, 'SAVINGS', 'ACTIVE', 'PORT1005'),
  (NULL, '2025-06-06', 6, NULL,  'CURRENT', 'ACTIVE', 'PORT1006'),
  (NULL, '2025-06-07', 7, NULL,  'SAVINGS', 'ACTIVE', 'PORT1007'),
  (NULL, '2025-06-08', 8, NULL,  'CURRENT', 'ACTIVE', 'PORT1008'),
  (NULL, '2025-06-09', 9, NULL,  'SAVINGS', 'INACTIVE', 'PORT1009'),
  (NULL, '2025-06-10', 10, NULL, 'CURRENT', 'ACTIVE', 'PORT1010');


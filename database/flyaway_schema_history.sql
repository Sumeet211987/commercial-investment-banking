--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9 (Debian 16.9-1.pgdg120+1)
-- Dumped by pg_dump version 16.9

-- Started on 2025-07-22 20:34:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3399 (class 0 OID 16385)
-- Dependencies: 215
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.flyway_schema_history VALUES (1, '1', 'table creation', 'SQL', 'V1__table_creation.sql', 675865268, 'postgres', '2025-07-10 14:22:41.20317', 159, true);
INSERT INTO public.flyway_schema_history VALUES (2, '2', 'foreignkey update', 'SQL', 'V2__foreignkey_update.sql', -1156606373, 'postgres', '2025-07-10 14:22:41.480511', 14, true);
INSERT INTO public.flyway_schema_history VALUES (3, '3', 'insert data address', 'SQL', 'V3__insert_data_address.sql', 1869855082, 'postgres', '2025-07-10 14:22:41.543811', 11, true);
INSERT INTO public.flyway_schema_history VALUES (4, '4', 'insert data portfolio', 'SQL', 'V4__insert_data_portfolio.sql', 716308224, 'postgres', '2025-07-10 14:22:41.591428', 16, true);
INSERT INTO public.flyway_schema_history VALUES (5, '5', 'insert data users', 'SQL', 'V5__insert_data_users.sql', -1934179731, 'postgres', '2025-07-10 14:22:41.664818', 13, true);
INSERT INTO public.flyway_schema_history VALUES (6, '6', 'update portfolio id', 'SQL', 'V6__update_portfolio_id.sql', 2064916093, 'postgres', '2025-07-10 14:22:41.710793', 29, true);


-- Completed on 2025-07-22 20:34:05

--
-- PostgreSQL database dump complete
--


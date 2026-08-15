--
-- PostgreSQL database cluster dump
--

-- Started on 2026-08-05 15:37:03

\restrict PPbgJuYKJMQJupIo4JDZ2pmAosrO4wkkF2P5lpRCe4EmOXGhbk3QS93kMqjdDBb

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:ugQFNMTueWjhtucJJfzl8Q==$H5tphcjiewO8Np1sl7xuK9y/eofqyOxRIndkypTeks0=:4hltlQLb+BlleDE+xhh+hMIR70J+E2eniVMoXmsA9zI=';

--
-- User Configurations
--








\unrestrict PPbgJuYKJMQJupIo4JDZ2pmAosrO4wkkF2P5lpRCe4EmOXGhbk3QS93kMqjdDBb

--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

\restrict So1QCkCPcYJPc76QqoNIfved1i18t0AZ2kccbIrpackI7CguBvWlkuZ38H9iQws

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-08-05 15:37:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2026-08-05 15:37:04

--
-- PostgreSQL database dump complete
--

\unrestrict So1QCkCPcYJPc76QqoNIfved1i18t0AZ2kccbIrpackI7CguBvWlkuZ38H9iQws

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

\restrict 4GPxbReoSpKapHKdBd4deRG7Qr5DrHbbUJEQruFRBccbNlv9kJTIyofd48CDmLh

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-08-05 15:37:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 24599)
-- Name: prefectures; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prefectures (
    code character(2) NOT NULL,
    "地域" character varying(10),
    "都道府県名" character varying(10),
    "県庁所在地" character varying(20),
    "面積" integer
);


ALTER TABLE public.prefectures OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24605)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    name character varying(20),
    grade integer
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 4860 (class 2606 OID 24604)
-- Name: prefectures prefectures_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prefectures
    ADD CONSTRAINT prefectures_pkey PRIMARY KEY (code);


-- Completed on 2026-08-05 15:37:04

--
-- PostgreSQL database dump complete
--

\unrestrict 4GPxbReoSpKapHKdBd4deRG7Qr5DrHbbUJEQruFRBccbNlv9kJTIyofd48CDmLh

-- Completed on 2026-08-05 15:37:04

--
-- PostgreSQL database cluster dump complete
--


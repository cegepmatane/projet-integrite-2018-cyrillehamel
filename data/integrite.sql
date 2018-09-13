--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: integrite; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE integrite WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE integrite OWNER TO postgres;

\connect integrite

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: famille; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE famille (
    id integer NOT NULL,
    nom text,
    nationalite text,
    adresse text,
    "classeSociale" text
);


ALTER TABLE famille OWNER TO postgres;

--
-- Name: famille_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE famille_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE famille_id_seq OWNER TO postgres;

--
-- Name: famille_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE famille_id_seq OWNED BY famille.id;


--
-- Name: personne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE personne (
    id integer NOT NULL,
    prenom text,
    naissance text,
    mail text,
    famille integer
);


ALTER TABLE personne OWNER TO postgres;

--
-- Name: personne_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personne_id_seq OWNER TO postgres;

--
-- Name: personne_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personne_id_seq OWNED BY personne.id;


--
-- Name: famille id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY famille ALTER COLUMN id SET DEFAULT nextval('famille_id_seq'::regclass);


--
-- Name: personne id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personne ALTER COLUMN id SET DEFAULT nextval('personne_id_seq'::regclass);


--
-- Data for Name: famille; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO famille VALUES (2, 'doe', 'etatuniens', '45 becker avenu,  new york', 'bourgoise');
INSERT INTO famille VALUES (1, 'dupont', 'francais', '14 rue du 6 juin , renne', 'moyenne');
INSERT INTO famille VALUES (4, 'smet', 'belge', '48 rue bist , namur', 'moyenne');
INSERT INTO famille VALUES (3, 'tremblay', 'quebecois', '612 avenu saint redempteur ,matane', 'moyenne');
INSERT INTO famille VALUES (5, 'hamel', 'francaise', '845 boulevard dunoix rouen ', 'pauvre');


--
-- Name: famille_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('famille_id_seq', 9, true);


--
-- Data for Name: personne; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO personne VALUES (1, 'toto', '01/0/1994', 'toto@toto.com', 2);
INSERT INTO personne VALUES (2, 'jean', '10/12/1998', 'jean@gmail.com', 1);
INSERT INTO personne VALUES (3, 'michel', '15/11/1989', 'michelTremblay@tutanota.org', 3);
INSERT INTO personne VALUES (4, 'hefring', '26/06/1992', NULL, 4);


--
-- Name: personne_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personne_id_seq', 4, true);


--
-- Name: famille famille_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY famille
    ADD CONSTRAINT famille_pkey PRIMARY KEY (id);


--
-- Name: personne personne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);


--
-- Name: personne onefamille_to_manypersonne; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personne
    ADD CONSTRAINT onefamille_to_manypersonne FOREIGN KEY (famille) REFERENCES famille(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--


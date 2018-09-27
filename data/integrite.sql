--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.10
-- Dumped by pg_dump version 9.6.10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
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
SELECT pg_catalog.set_config('search_path', '', false);
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


--
-- Name: journaliser(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.journaliser() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 
	description text;
    objetAvant text;
    objetApres text;
    operation text;
BEGIN
	objetAvant := '';
	objetApres := '';

	IF TG_OP = 'UPDATE' THEN
    	objetAvant := '{'||OLD.nom||','||OLD.nationalite||','||OLD.adresse||','||OLD.classesociale||'}';
   		objetApres := '{'||NEW.nom||','||NEW.nationalite||','||NEW.adresse||','||NEW.classesociale||'}';
        operation := 'MODIFIER';
    END IF;
	IF TG_OP = 'INSERT' THEN
    	objetAvant := '{}';
   		objetApres := '{'||NEW.nom||','||NEW.nationalite||','||NEW.adresse||','||NEW.classeSociale||'}';
        operation := 'AJOUTER';
    END IF;
	IF TG_OP = 'DELETE' THEN
    	objetAvant := '{'||OLD.nom||','||OLD.nationalite||','||OLD.adresse||','||OLD.classeSociale||'}';
    	objetApres := '{}';
        operation := 'EFFACER';
    END IF;

	description := objetAvant || ' -> ' || objetApres;
    -- https://www.postgresql.org/docs/9.1/static/plpgsql-trigger.html
	INSERT into journal(moment, operation, objet, description) VALUES(NOW(), operation, 'famille', description);
    
	IF TG_OP = 'DELETE' THEN
		return OLD;
	END IF; 
    return NEW;
END

$$;


ALTER FUNCTION public.journaliser() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: famille; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.famille (
    id integer NOT NULL,
    nom text,
    nationalite text,
    adresse text,
    classesociale text
);


ALTER TABLE public.famille OWNER TO postgres;

--
-- Name: famille_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.famille_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.famille_id_seq OWNER TO postgres;

--
-- Name: famille_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.famille_id_seq OWNED BY public.famille.id;


--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.journal (
    id integer NOT NULL,
    moment timestamp with time zone NOT NULL,
    operation text,
    description text,
    objet text NOT NULL
);


ALTER TABLE public.journal OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.journal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.journal_id_seq OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.journal_id_seq OWNED BY public.journal.id;


--
-- Name: personne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personne (
    id integer NOT NULL,
    prenom text,
    naissance text,
    mail text,
    famille integer
);


ALTER TABLE public.personne OWNER TO postgres;

--
-- Name: personne_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personne_id_seq OWNER TO postgres;

--
-- Name: personne_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.personne_id_seq OWNED BY public.personne.id;


--
-- Name: famille id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.famille ALTER COLUMN id SET DEFAULT nextval('public.famille_id_seq'::regclass);


--
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal ALTER COLUMN id SET DEFAULT nextval('public.journal_id_seq'::regclass);


--
-- Name: personne id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personne ALTER COLUMN id SET DEFAULT nextval('public.personne_id_seq'::regclass);


--
-- Data for Name: famille; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.famille VALUES (4, 'smet', 'belge', '48 rue bist , namur', 'moyenne');
INSERT INTO public.famille VALUES (3, 'tremblay', 'quebecois', '612 avenu saint redempteur ,matane', 'moyenne');
INSERT INTO public.famille VALUES (5, 'hamel', 'francaise', '845 boulevard dunoix rouen ', 'pauvre');
INSERT INTO public.famille VALUES (1, 'duponts', 'francaise', '14 rue du 6 juin , rennes', 'moyennes');


--
-- Name: famille_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.famille_id_seq', 12, true);


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.journal VALUES (1, '2018-09-27 13:49:26.235821-04', 'MODIFIER', '{doe,etatuniens,45 becker avenu,  new york,bourgoise} -> {doe,etatuniens,45 becker avenu,  new york,bourgoise}', 'famille');
INSERT INTO public.journal VALUES (2, '2018-09-27 14:05:39.575826-04', 'MODIFIER', '{dupont,francais,14 rue du 6 juin , renne,moyenne} -> {duponts,francaise,14 rue du 6 juin , rennes,moyennes}', 'famille');
INSERT INTO public.journal VALUES (3, '2018-09-27 14:06:23.24003-04', 'AJOUTER', '{} -> {test,test,test,test}', 'famille');
INSERT INTO public.journal VALUES (4, '2018-09-27 14:13:01.679974-04', 'EFFACER', '{test,test,test,test} -> {}', 'famille');
INSERT INTO public.journal VALUES (5, '2018-09-27 14:35:19.397851-04', 'EFFACER', '{doe,etatuniens,45 becker avenu,  new york,bourgoise} -> {}', 'famille');


--
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.journal_id_seq', 5, true);


--
-- Data for Name: personne; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.personne VALUES (2, 'jean', '10/12/1998', 'jean@gmail.com', 1);
INSERT INTO public.personne VALUES (3, 'michel', '15/11/1989', 'michelTremblay@tutanota.org', 3);
INSERT INTO public.personne VALUES (4, 'hefring', '26/06/1992', NULL, 4);


--
-- Name: personne_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personne_id_seq', 5, true);


--
-- Name: famille famille_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.famille
    ADD CONSTRAINT famille_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: personne personne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);


--
-- Name: famille evenementajoutfamille; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementajoutfamille BEFORE INSERT ON public.famille FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: famille evenementeffacerfamille; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementeffacerfamille BEFORE DELETE ON public.famille FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: famille evenementmodifierfamille; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementmodifierfamille BEFORE UPDATE ON public.famille FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: personne onefamille_to_manypersonne; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personne
    ADD CONSTRAINT onefamille_to_manypersonne FOREIGN KEY (famille) REFERENCES public.famille(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--


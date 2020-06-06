CREATE SEQUENCE public.singer_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.singer_id_seq
    OWNER TO task;

CREATE TABLE public.singer
(
    id integer NOT NULL DEFAULT nextval('singer_id_seq'::regclass),
    first_name character varying(60) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    birth_date date,
    CONSTRAINT singer_pkey PRIMARY KEY (id),
    CONSTRAINT "UQ_SINGER_1" UNIQUE (first_name, last_name)

)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.singer
    OWNER to task;


CREATE SEQUENCE public.album_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.album_id_seq
    OWNER TO task;

CREATE TABLE public.album
(
    id integer NOT NULL DEFAULT nextval('album_id_seq'::regclass),
    singer_id integer NOT NULL,
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    release_date date,
    CONSTRAINT album_pkey PRIMARY KEY (id),
    CONSTRAINT "UQ_SINGER_ALBUM_1" UNIQUE (singer_id, title)
    ,
    CONSTRAINT "FK_ALBUM" FOREIGN KEY (singer_id)
        REFERENCES public.singer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.album
    OWNER to task;

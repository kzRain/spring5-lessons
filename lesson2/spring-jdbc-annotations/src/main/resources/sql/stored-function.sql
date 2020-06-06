
CREATE OR REPLACE FUNCTION public.getfirstnamebyid(
    in_id integer)
    RETURNS character varying(60)
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE
AS $BODY$


DECLARE
    res character varying(60);
BEGIN
    -- get the rate based on film_id
    SELECT INTO res first_name FROM singer WHERE id = in_id;

    RETURN res;
END;  $BODY$;

ALTER FUNCTION public.getfirstnamebyid(integer)
    OWNER TO task;

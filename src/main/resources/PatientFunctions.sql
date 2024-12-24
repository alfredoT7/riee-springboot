CREATE OR REPLACE FUNCTION getAllPatient()
RETURNS TABLE(
    ci_paciente INTEGER,
    id_estado_civil INTEGER,
    fecha_nacimiento DATE,
    direccion VARCHAR,
    ocupacion VARCHAR,
    persona_de_referencia VARCHAR,
    numero_persona_ref INTEGER,
    imagen VARCHAR,
    nombre VARCHAR,
    apellido VARCHAR
) AS
$$
BEGIN
RETURN QUERY
SELECT *
FROM paciente p;
END;
$$ LANGUAGE plpgsql;

SELECT * from getAllPatient();


-----------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION getPatientByCI(p_ci INTEGER)
RETURNS TABLE(
    ci_paciente INTEGER,
    id_estado_civil INTEGER,
    fecha_nacimiento DATE,
    direccion VARCHAR,
    ocupacion VARCHAR,
    persona_de_referencia VARCHAR,
    numero_persona_ref INTEGER,
    imagen VARCHAR,
    nombre VARCHAR,
    apellido VARCHAR
) AS
$$
BEGIN
RETURN QUERY
SELECT
    *
FROM paciente p
WHERE p.ci_paciente = p_ci;
END;
$$ LANGUAGE plpgsql;


SELECT * FROM getPatientByCI(12345678);

-----------------------------------------------------------------------------------------------------------------------



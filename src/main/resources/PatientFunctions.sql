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
CREATE OR REPLACE FUNCTION insertPatient(
    p_ci_paciente INTEGER,
    p_id_estado_civil INTEGER,
    p_fecha_nacimiento DATE,
    p_direccion VARCHAR,
    p_ocupacion VARCHAR,
    p_persona_de_referencia VARCHAR,
    p_numero_persona_ref INTEGER,
    p_imagen VARCHAR,
    p_nombre VARCHAR,
    p_apellido VARCHAR
)
RETURNS VOID AS
$$
BEGIN
INSERT INTO paciente (
    ci_paciente,
    id_estado_civil,
    fecha_nacimiento,
    direccion,
    ocupacion,
    persona_de_referencia,
    numero_persona_ref,
    imagen,
    nombre,
    apellido
)
VALUES (
           p_ci_paciente,
           p_id_estado_civil,
           p_fecha_nacimiento,
           p_direccion,
           p_ocupacion,
           p_persona_de_referencia,
           p_numero_persona_ref,
           p_imagen,
           p_nombre,
           p_apellido
       );
END;
$$ LANGUAGE plpgsql;

SELECT insertPatient(
               12445678,
               1,
               '1990-01-01',
               'Calle Falsa 123',
               'Ingeniero',
               'Florentino Perez',
               987654321,
               'foto.jpg',
               'Juan',
               'Perez'
       );

-----------------------------------------------------------------------------------------------------------------------

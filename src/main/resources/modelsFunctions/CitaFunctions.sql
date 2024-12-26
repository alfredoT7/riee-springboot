CREATE OR REPLACE FUNCTION insertar_cita(
    p_ci_paciente INT,
    p_fecha_cita DATE,
    p_hora TIME,
    p_duracion_estimada INT,
    p_descripcion_cita VARCHAR
)
    RETURNS BOOLEAN AS
$$
BEGIN
    BEGIN
        INSERT INTO CITA (CI_PACIENTE, FECHA_CITA, HORA, DURACION_ESTIMADA, DESCRIPCION_CITA)
        VALUES (p_ci_paciente, p_fecha_cita, p_hora, p_duracion_estimada, p_descripcion_cita);
        RETURN TRUE;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN FALSE;
    END;
END;
$$ LANGUAGE plpgsql;

SELECT insertar_cita(12345678, '2024-12-26', '10:00:00', 30, 'Revisión tercer molar');

SELECT * FROM CITA;
-------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION obtener_citas_por_paciente(
    p_ci_paciente INT
)
    RETURNS TABLE (
                      CI_PACIENTE INT,
                      ID_CITA INT,
                      FECHA_CITA DATE,
                      HORA TIME,
                      DURACION_ESTIMADA INT,
                      DESCRIPCION_CITA VARCHAR
                  ) AS
$$
BEGIN
    RETURN QUERY
        SELECT c.ci_paciente ,C.ID_CITA, C.FECHA_CITA, C.HORA, C.DURACION_ESTIMADA, C.DESCRIPCION_CITA
        FROM CITA C
        WHERE C.CI_PACIENTE = p_ci_paciente;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM obtener_citas_por_paciente(12345678);
-------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION obtener_cita(
    p_ci_paciente INT,
    p_id_cita INT
)
    RETURNS TABLE (
                      FECHA_CITA DATE,
                      HORA TIME,
                      DURACION_ESTIMADA INT,
                      DESCRIPCION_CITA VARCHAR
                  ) AS
$$
BEGIN
    RETURN QUERY
        SELECT C.FECHA_CITA, C.HORA, C.DURACION_ESTIMADA, C.DESCRIPCION_CITA
        FROM CITA C
        WHERE C.CI_PACIENTE = p_ci_paciente AND C.ID_CITA = p_id_cita;
END;
$$ LANGUAGE plpgsql;
SELECT * FROM obtener_cita(12345678, 1);

-------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION actualizar_cita(
    p_ci_paciente INT,
    p_id_cita INT,
    p_fecha_cita DATE,
    p_hora TIME,
    p_duracion_estimada INT,
    p_descripcion_cita VARCHAR
)
    RETURNS BOOLEAN AS
$$
BEGIN
    BEGIN
        -- Intentamos actualizar la cita
        UPDATE CITA
        SET FECHA_CITA = p_fecha_cita,
            HORA = p_hora,
            DURACION_ESTIMADA = p_duracion_estimada,
            DESCRIPCION_CITA = p_descripcion_cita
        WHERE CI_PACIENTE = p_ci_paciente AND ID_CITA = p_id_cita;
        IF FOUND THEN
            RETURN TRUE;
        ELSE
            RETURN FALSE;
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN FALSE;
    END;
END;
$$ LANGUAGE plpgsql;
SELECT actualizar_cita(12345678, 1, '2024-12-27', '11:00:00', 45, 'Revisión general');

-------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION eliminar_cita(
    p_ci_paciente INT,
    p_id_cita INT
)
    RETURNS BOOLEAN AS
$$
BEGIN
    BEGIN
        DELETE FROM CITA
        WHERE CI_PACIENTE = p_ci_paciente AND ID_CITA = p_id_cita;
        IF FOUND THEN
            RETURN TRUE;
        ELSE
            RETURN FALSE;
        END IF;

    EXCEPTION
        WHEN OTHERS THEN
            RETURN FALSE;
    END;
END;
$$ LANGUAGE plpgsql;

SELECT eliminar_cita(12345678, 1);

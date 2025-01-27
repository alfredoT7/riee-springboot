CREATE OR REPLACE FUNCTION insertTreatment(
    p_id_tipo_tratamiento INT,
    p_pieza_dental INT,
    p_descripcion_historial VARCHAR,
    p_inicio_tratamiento DATE,
    p_fin_tratamiento DATE,
    p_precio_total DOUBLE PRECISION,
    p_saldo DOUBLE PRECISION,
    p_tratamiento_terminado BOOLEAN
)
RETURNS VOID AS
    $$
        BEGIN
            insert into tratamiento(
                id_tipo_tratamiento,
                pieza_dental,
                descripcion_historial,
                inicio_tratamiento,
                fin_tratamiento,
                precio_total,
                saldo,
                tratamiento_terminado
            )
            VALUES (
                          p_id_tipo_tratamiento,
                          p_pieza_dental,
                          p_descripcion_historial,
                          p_inicio_tratamiento,
                          p_fin_tratamiento,
                          p_precio_total,
                          p_saldo,
                          p_tratamiento_terminado
                     );

        end;
    $$ LANGUAGE plpgsql;
select insertTreatment(3,1, 'Descripcion', '2021-01-01', '2021-01-01', 100.0, 0.0, false);


CREATE OR REPLACE FUNCTION insertTreatment(
    p_id_tipo_tratamiento INT,
    p_pieza_dental INT,
    p_descripcion_historial VARCHAR,
    p_inicio_tratamiento DATE,
    p_fin_tratamiento DATE,
    p_precio_total DOUBLE PRECISION,
    p_saldo DOUBLE PRECISION,
    p_tratamiento_terminado BOOLEAN
)
    RETURNS BOOLEAN AS
$$
BEGIN
    BEGIN
        INSERT INTO tratamiento(
            id_tipo_tratamiento,
            pieza_dental,
            descripcion_historial,
            inicio_tratamiento,
            fin_tratamiento,
            precio_total,
            saldo,
            tratamiento_terminado
        )
        VALUES (
                   p_id_tipo_tratamiento,
                   p_pieza_dental,
                   p_descripcion_historial,
                   p_inicio_tratamiento,
                   p_fin_tratamiento,
                   p_precio_total,
                   p_saldo,
                   p_tratamiento_terminado
               );
        RETURN TRUE;
    EXCEPTION
        WHEN unique_violation THEN
            RETURN FALSE;
    END;
END;
$$ LANGUAGE plpgsql;

select insertTreatment(3,1, 'Descripcion', '2021-01-01', '2021-01-01', 100.0, 0.0, false);

select * from tratamiento;




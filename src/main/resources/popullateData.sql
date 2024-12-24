INSERT INTO CIVIL_STATUS (ID_ESTADO_CIVIL, ESTADO_CIVIL)
VALUES
    (1, 'Soltero'),
    (2, 'Casado'),
    (3, 'Divorciado'),
    (4, 'Viudo'),
    (5, 'Unión Libre');
select * from civil_status;

INSERT INTO DENTISTA (CI_DENTISTA, FECHA_NACIMIENTO_DENTISTA, UNIVERSIDAD, ANIO_TITULACION, IMAGEN_DENTISTA, CONTRASENIA, NOMBRE, APELLIDO)
VALUES
    (1, '1985-03-15', 'Universidad Mayor de San Simon', 2010, 'imagen1.jpg', 'contraseña123','Luzgarda','Garcia Zambrana'),
    (2, '1990-07-20', 'Universidad Mayor de San Simon', 2015, 'imagen2.jpg', 'contraseña456','Laura Poleth','Torrico Garcia');
select * from dentista;

INSERT INTO ESPECIALIDAD (ID_ESPECIALIDAD, ESPECIALIDAD)
VALUES
    (1, 'Ortodoncia'),
    (2, 'Endodoncia'),
    (3, 'Implantes Dentales'),
    (4, 'Cirugía Oral'),
    (5, 'Estética Dental');
select * from especialidad;

INSERT INTO TIPO_TRATAMIENTO (ID_TIPO_TRATAMIENTO, TRATAMIENTO, DESCRIPCION, PROCEDIMIENTO)
VALUES
    (1, 'Ortodoncia', 'Tratamiento para alinear los dientes', 'Uso de brackets para corregir la alineación dental'),
    (2, 'Limpieza Dental', 'Eliminación de placa y sarro', 'Procedimiento con ultrasonido y limpieza manual'),
    (3, 'Endodoncia', 'Tratamiento de conductos radiculares', 'Limpieza y sellado del conducto radicular'),
    (4, 'Implantes Dentales', 'Colocación de implantes en la mandíbula o maxilar', 'Procedimiento quirúrgico para colocar tornillos de titanio en el hueso'),
    (5, 'Blanqueamiento Dental', 'Blanqueo de los dientes', 'Uso de geles blanqueadores aplicados a los dientes');
select * from tipo_tratamiento;

INSERT INTO PACIENTE (CI_PACIENTE, ID_ESTADO_CIVIL, FECHA_NACIMIENTO, DIRECCION, OCUPACION, PERSONA_DE_REFERENCIA, NUMERO_PERSONA_REF, IMAGEN)
VALUES
    (12345678, 1, '1990-01-01', 'Calle Ficticia 123, Ciudad', 'Ingeniero', 'Juan Pérez', 987654321, 'paciente1.jpg'),
    (23456789, 2, '1985-04-20', 'Avenida Real 456, Ciudad', 'Doctor', 'Ana Gómez', 987654322, 'paciente2.jpg'),
    (34567890, 3, '1980-08-15', 'Calle Nueva 789, Ciudad', 'Abogado', 'Carlos Martínez', 987654323, 'paciente3.jpg'),
    (45678901, 4, '1995-09-30', 'Calle del Sol 101, Ciudad', 'Profesor', 'Laura Fernández', 987654324, 'paciente4.jpg'),
    (56789012, 5, '2000-12-25', 'Avenida Libertad 202, Ciudad', 'Estudiante', 'Ricardo López', 987654325, 'paciente5.jpg');
select * from paciente;

INSERT INTO TIPO_PAGO (ID_TIPO_PAGO, TIPO_PAGO)
VALUES
    (1, 'Efectivo'),
    (2, 'Tarjeta de Crédito'),
    (3, 'Transferencia Bancaria'),
    (4, 'Cheque'),
    (5, 'Pago en línea');
select * from tipo_pago;

INSERT INTO NUMERO_TELEFONO (CI_PACIENTE, NUMERO)
VALUES
    (12345678, 987654321),
    (23456789, 987654322),
    (34567890, 987654323),
    (45678901, 987654324),
    (56789012, 987654325);
select * from numero_telefono;

INSERT INTO TRATAMIENTO (ID_TRATAMIENTO, ID_TIPO_TRATAMIENTO, PIEZA_DENTAL, DESCRIPCION_HISTORIAL, INICIO_TRATAMIENTO, FIN_TRATAMIENTO, PRECIO_TOTAL, SALDO, TRATAMIENTO_TERMINADO)
VALUES
    (1, 1, 15, 'Alineación de dientes superiores', '2024-01-01', '2024-06-01', 1200.50, 600.00, FALSE),
    (2, 2, 5, 'Limpieza general de dientes', '2024-05-01', '2024-05-01', 100.00, 0.00, TRUE),
    (3, 3, 12, 'Tratamiento de conductos radiculares', '2024-03-10', '2024-04-10', 800.00, 400.00, FALSE),
    (4, 4, 8, 'Colocación de implantes dentales en la mandíbula', '2024-02-15', '2024-02-25', 3000.00, 1500.00, TRUE),
    (5, 5, 18, 'Blanqueamiento dental', '2024-06-10', '2024-06-10', 250.00, 0.00, TRUE);
select * from tratamiento;

INSERT INTO IMAGEN_TRATAMIENTO (ID_TRATAMIENTO, ID_IMAGEN, IMAGEN_TRATAMIENTO)
VALUES
    (1, 1, 'tratamiento1.jpg'),
    (2, 1, 'tratamiento2.jpg'),
    (3, 1, 'tratamiento3.jpg'),
    (4, 1, 'tratamiento4.jpg'),
    (5, 1, 'tratamiento5.jpg');
select * from imagen_tratamiento;
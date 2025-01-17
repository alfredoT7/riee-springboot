create table CITA (
   CI_PACIENTE          INT4                 not null,
   ID_CITA              SERIAL               not null,
   FECHA_CITA           DATE                 not null,
   HORA                 TIME                 not null,
   DURACION_ESTIMADA    INT4                 not null,
   DESCRIPCION_CITA     VARCHAR(300)         null,
   constraint PK_CITA primary key (CI_PACIENTE, ID_CITA)
);
create unique index CITA_PK on CITA (
CI_PACIENTE,
ID_CITA
);
create  index RELATIONSHIP_14_FK on CITA (
CI_PACIENTE
);
create table CIVIL_STATUS (
   ID_ESTADO_CIVIL      INT4                 not null,
   ESTADO_CIVIL         VARCHAR(40)          not null,
   constraint PK_CIVIL_STATUS primary key (ID_ESTADO_CIVIL)
);
create unique index CIVIL_STATUS_PK on CIVIL_STATUS (
ID_ESTADO_CIVIL
);
create table DENTISTA (
   CI_DENTISTA          SERIAL               not null,
   FECHA_NACIMIENTO_DENTISTA DATE                 not null,
   UNIVERSIDAD          VARCHAR(100)         not null,
   ANIO_TITULACION      INT4                 not null,
   IMAGEN_DENTISTA      VARCHAR(1024)        not null,
   CONTRASENIA          VARCHAR(1024)        not null,
   constraint PK_DENTISTA primary key (CI_DENTISTA)
);
create unique index DENTISTA_PK on DENTISTA (
CI_DENTISTA
);
create table DENTISTA_ESPECIALIDAD (
   ID_ESPECIALIDAD      INT4                 not null,
   CI_DENTISTA          INT4                 not null,
   CASA_ESTUDIO         VARCHAR(300)         not null,
   constraint PK_DENTISTA_ESPECIALIDAD primary key (ID_ESPECIALIDAD, CI_DENTISTA)
);
create unique index DENTISTA_ESPECIALIDAD_PK on DENTISTA_ESPECIALIDAD (
ID_ESPECIALIDAD,
CI_DENTISTA
);
create  index RELATIONSHIP_6_FK on DENTISTA_ESPECIALIDAD (
CI_DENTISTA
);
create  index RELATIONSHIP_7_FK on DENTISTA_ESPECIALIDAD (
ID_ESPECIALIDAD
);
create table DENTISTA_TRATAMIENTO (
   ID_TRATAMIENTO       INT4                 not null,
   CI_DENTISTA          INT4                 not null,
   OBSERVACIONES_TRATAMIENTO VARCHAR(300)         null,
   constraint PK_DENTISTA_TRATAMIENTO primary key (ID_TRATAMIENTO, CI_DENTISTA)
);
create unique index DENTISTA_TRATAMIENTO_PK on DENTISTA_TRATAMIENTO (
ID_TRATAMIENTO,
CI_DENTISTA
);
create  index RELATIONSHIP_8_FK on DENTISTA_TRATAMIENTO (
CI_DENTISTA
);
create  index RELATIONSHIP_9_FK on DENTISTA_TRATAMIENTO (
ID_TRATAMIENTO
);
create table ESPECIALIDAD (
   ID_ESPECIALIDAD      SERIAL               not null,
   ESPECIALIDAD         VARCHAR(100)         not null,
   constraint PK_ESPECIALIDAD primary key (ID_ESPECIALIDAD)
);
create unique index ESPECIALIDAD_PK on ESPECIALIDAD (
ID_ESPECIALIDAD
);
create table IMAGEN_TRATAMIENTO (
   ID_TRATAMIENTO       INT4                 not null,
   ID_IMAGEN            SERIAL               not null,
   IMAGEN_TRATAMIENTO   VARCHAR(1024)        not null,
   constraint PK_IMAGEN_TRATAMIENTO primary key (ID_TRATAMIENTO, ID_IMAGEN)
);
create unique index IMAGEN_TRATAMIENTO_PK on IMAGEN_TRATAMIENTO (
ID_TRATAMIENTO,
ID_IMAGEN
);
create  index RELATIONSHIP_17_FK on IMAGEN_TRATAMIENTO (
ID_TRATAMIENTO
);
create table NUMERO_TELEFONO (
   CI_PACIENTE          INT4                 not null,
   NUMERO               INT4                 not null,
   constraint PK_NUMERO_TELEFONO primary key (CI_PACIENTE, NUMERO)
);
create unique index NUMERO_TELEFONO_PK on NUMERO_TELEFONO (
CI_PACIENTE,
NUMERO
);
create  index RELATIONSHIP_2_FK on NUMERO_TELEFONO (
CI_PACIENTE
);
create table PACIENTE (
   CI_PACIENTE          INT4                 not null,
   ID_ESTADO_CIVIL      INT4                 null,
   FECHA_NACIMIENTO     DATE                 not null,
   DIRECCION            VARCHAR(1024)        not null,
   OCUPACION            VARCHAR(30)          not null,
   PERSONA_DE_REFERENCIA VARCHAR(80)          not null,
   NUMERO_PERSONA_REF   INT4                 not null,
   IMAGEN               VARCHAR(1024)        not null,
   NOMBRE               VARCHAR(30)          not null,
   APELLIDO             VARCHAR(30)          not null,
   NUMERO_TELEFONO      BIGINT               null,
   constraint PK_PACIENTE primary key (CI_PACIENTE)
);
create unique index PACIENTE_PK on PACIENTE (
CI_PACIENTE
);
create  index RELATIONSHIP_13_FK on PACIENTE (
ID_ESTADO_CIVIL
);
create table PACIENTE_TRATAMIENTO (
   ID_TRATAMIENTO       INT4                 not null,
   CI_PACIENTE          INT4                 not null,
   PRESCRIPCION_TRATAMIENTO VARCHAR(300)         null,
   CUIDADOS             VARCHAR(300)         null,
   constraint PK_PACIENTE_TRATAMIENTO primary key (ID_TRATAMIENTO, CI_PACIENTE)
);
create unique index PACIENTE_TRATAMIENTO_PK on PACIENTE_TRATAMIENTO (
ID_TRATAMIENTO,
CI_PACIENTE
);
create  index RELATIONSHIP_4_FK on PACIENTE_TRATAMIENTO (
CI_PACIENTE
);
create  index RELATIONSHIP_5_FK on PACIENTE_TRATAMIENTO (
ID_TRATAMIENTO
);
create table PAGO (
   ID_PAGO              SERIAL               not null,
   ID_TIPO_PAGO         INT4                 null,
   PAGO                 FLOAT8               not null,
   COMPROBANTE          VARCHAR(1024)        not null,
   constraint PK_PAGO primary key (ID_PAGO)
);
create unique index PAGO_PK on PAGO (
ID_PAGO
);
create  index RELATIONSHIP_15_FK on PAGO (
ID_TIPO_PAGO
);
create table PAGO_TRATAMIENTO (
   ID_TRATAMIENTO       INT4                 not null,
   ID_PAGO              INT4                 not null,
   FECHA_PAGO           DATE                 not null,
   constraint PK_PAGO_TRATAMIENTO primary key (ID_TRATAMIENTO, ID_PAGO)
);
create unique index PAGO_TRATAMIENTO_PK on PAGO_TRATAMIENTO (
ID_TRATAMIENTO,
ID_PAGO
);
create  index RELATIONSHIP_11_FK on PAGO_TRATAMIENTO (
ID_PAGO
);
create  index RELATIONSHIP_12_FK on PAGO_TRATAMIENTO (
ID_TRATAMIENTO
);
create table TIPO_PAGO (
   ID_TIPO_PAGO         SERIAL               not null,
   TIPO_PAGO            VARCHAR(100)         not null,
   constraint PK_TIPO_PAGO primary key (ID_TIPO_PAGO)
);
create unique index TIPO_PAGO_PK on TIPO_PAGO (
ID_TIPO_PAGO
);
create table TIPO_TRATAMIENTO (
   ID_TIPO_TRATAMIENTO  SERIAL               not null,
   TRATAMIENTO          VARCHAR(300)         not null,
   DESCRIPCION          VARCHAR(300)         not null,
   PROCEDIMIENTO        VARCHAR(1024)        not null,
   constraint PK_TIPO_TRATAMIENTO primary key (ID_TIPO_TRATAMIENTO)
);
create unique index TIPO_TRATAMIENTO_PK on TIPO_TRATAMIENTO (
ID_TIPO_TRATAMIENTO
);
create table TRATAMIENTO (
   ID_TRATAMIENTO       SERIAL               not null,
   ID_TIPO_TRATAMIENTO  INT4                 null,
   PIEZA_DENTAL         INT4                 not null,
   DESCRIPCION_HISTORIAL VARCHAR(200)         null,
   INICIO_TRATAMIENTO   DATE                 not null,
   FIN_TRATAMIENTO      DATE                 not null,
   PRECIO_TOTAL         FLOAT8               not null,
   SALDO                FLOAT8               not null,
   TRATAMIENTO_TERMINADO BOOL                 not null,
   constraint PK_TRATAMIENTO primary key (ID_TRATAMIENTO)
);
create unique index TRATAMIENTO_PK on TRATAMIENTO (
ID_TRATAMIENTO
);
create  index RELATIONSHIP_16_FK on TRATAMIENTO (
ID_TIPO_TRATAMIENTO
);
alter table CITA
   add constraint FK_CITA_RELATIONS_PACIENTE foreign key (CI_PACIENTE)
      references PACIENTE (CI_PACIENTE)
      on delete restrict on update restrict;

alter table DENTISTA_ESPECIALIDAD
   add constraint FK_DENTISTA_RELATIONS_DENTISTA foreign key (CI_DENTISTA)
      references DENTISTA (CI_DENTISTA)
      on delete restrict on update restrict;

alter table DENTISTA_ESPECIALIDAD
   add constraint FK_DENTISTA_RELATIONS_ESPECIAL foreign key (ID_ESPECIALIDAD)
      references ESPECIALIDAD (ID_ESPECIALIDAD)
      on delete restrict on update restrict;

alter table DENTISTA_TRATAMIENTO
   add constraint FK_DENTISTA_RELATIONS_DENTISTA foreign key (CI_DENTISTA)
      references DENTISTA (CI_DENTISTA)
      on delete restrict on update restrict;

alter table DENTISTA_TRATAMIENTO
   add constraint FK_DENTISTA_RELATIONS_TRATAMIE foreign key (ID_TRATAMIENTO)
      references TRATAMIENTO (ID_TRATAMIENTO)
      on delete restrict on update restrict;

alter table IMAGEN_TRATAMIENTO
   add constraint FK_IMAGEN_T_RELATIONS_TRATAMIE foreign key (ID_TRATAMIENTO)
      references TRATAMIENTO (ID_TRATAMIENTO)
      on delete restrict on update restrict;

alter table NUMERO_TELEFONO
   add constraint FK_NUMERO_T_RELATIONS_PACIENTE foreign key (CI_PACIENTE)
      references PACIENTE (CI_PACIENTE)
      on delete restrict on update restrict;

alter table PACIENTE
   add constraint FK_PACIENTE_RELATIONS_CIVIL_ST foreign key (ID_ESTADO_CIVIL)
      references CIVIL_STATUS (ID_ESTADO_CIVIL)
      on delete restrict on update restrict;

alter table PACIENTE_TRATAMIENTO
   add constraint FK_PACIENTE_RELATIONS_PACIENTE foreign key (CI_PACIENTE)
      references PACIENTE (CI_PACIENTE)
      on delete restrict on update restrict;

alter table PACIENTE_TRATAMIENTO
   add constraint FK_PACIENTE_RELATIONS_TRATAMIE foreign key (ID_TRATAMIENTO)
      references TRATAMIENTO (ID_TRATAMIENTO)
      on delete restrict on update restrict;

alter table PAGO
   add constraint FK_PAGO_RELATIONS_TIPO_PAG foreign key (ID_TIPO_PAGO)
      references TIPO_PAGO (ID_TIPO_PAGO)
      on delete restrict on update restrict;

alter table PAGO_TRATAMIENTO
   add constraint FK_PAGO_TRA_RELATIONS_PAGO foreign key (ID_PAGO)
      references PAGO (ID_PAGO)
      on delete restrict on update restrict;

alter table PAGO_TRATAMIENTO
   add constraint FK_PAGO_TRA_RELATIONS_TRATAMIE foreign key (ID_TRATAMIENTO)
      references TRATAMIENTO (ID_TRATAMIENTO)
      on delete restrict on update restrict;

alter table TRATAMIENTO
   add constraint FK_TRATAMIE_RELATIONS_TIPO_TRA foreign key (ID_TIPO_TRATAMIENTO)
      references TIPO_TRATAMIENTO (ID_TIPO_TRATAMIENTO)
      on delete restrict on update restrict;

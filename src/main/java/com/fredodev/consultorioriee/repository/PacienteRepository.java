package com.fredodev.consultorioriee.repository;

import com.fredodev.consultorioriee.model.Paciente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Paciente paciente) {
        String sql = "INSERT INTO PACIENTE (CI_PACIENTE, ID_ESTADO_CIVIL, FECHA_NACIMIENTO, DIRECCION, OCUPACION, PERSONA_DE_REFERENCIA, NUMERO_PERSONA_REF, IMAGEN, NOMBRE, APELLIDO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                paciente.getCiPaciente(),
                paciente.getIdEstadoCivil(),
                paciente.getFechaNacimiento(),
                paciente.getDireccion(),
                paciente.getOcupacion(),
                paciente.getPersonaDeReferencia(),
                paciente.getNumeroPersonaRef(),
                paciente.getImagen(),
                paciente.getNombre(),
                paciente.getApellido());
    }
    public Paciente findByCiPaciente(int ciPaciente) {
        String sql = "SELECT * FROM getPatientByCI(?);";
        return jdbcTemplate.queryForObject(sql, new Object[]{ciPaciente}, (rs, rowNum) ->
                new Paciente(
                        rs.getInt("CI_PACIENTE"),
                        rs.getInt("ID_ESTADO_CIVIL"),
                        rs.getDate("FECHA_NACIMIENTO"),
                        rs.getString("DIRECCION"),
                        rs.getString("OCUPACION"),
                        rs.getString("PERSONA_DE_REFERENCIA"),
                        rs.getInt("NUMERO_PERSONA_REF"),
                        rs.getString("IMAGEN"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO")
                ));
    }
}

package com.fredodev.consultorioriee.repository;

import com.fredodev.consultorioriee.model.Paciente;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class PacienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Paciente paciente) {
        String sql = "SELECT insertPatient(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.execute((ConnectionCallback<Object>) (connection) -> {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setLong(1, paciente.getCiPaciente());
                ps.setInt(2, paciente.getIdEstadoCivil());
                ps.setDate(3, new Date(paciente.getFechaNacimiento().getTime()));
                ps.setString(4, paciente.getDireccion());
                ps.setString(5, paciente.getOcupacion());
                ps.setString(6, paciente.getPersonaDeReferencia());
                ps.setLong(7, paciente.getNumeroPersonaRef());
                ps.setString(8, paciente.getImagen());
                ps.setString(9, paciente.getNombre());
                ps.setString(10, paciente.getApellido());
                ps.setLong(11,paciente.getNumeroTelefono());
                ps.execute();
            }
            return null;
        });
    }
    public Paciente findByCiPaciente(int ciPaciente) {
        String sql = "SELECT * FROM getPatientByCI(?);";
        return jdbcTemplate.queryForObject(sql, new Object[]{ciPaciente}, (rs, rowNum) ->
                new Paciente(
                        rs.getLong("CI_PACIENTE"),
                        rs.getInt("ID_ESTADO_CIVIL"),
                        rs.getDate("FECHA_NACIMIENTO"),
                        rs.getString("DIRECCION"),
                        rs.getString("OCUPACION"),
                        rs.getString("PERSONA_DE_REFERENCIA"),
                        rs.getLong("NUMERO_PERSONA_REF"),
                        rs.getString("IMAGEN"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getLong("NUMERO_TELEFONO")
                ));
    }
    public List<Paciente> findAll(int pageNumber) {
        int pageSize = 15;
        int offset = (pageNumber - 1) * pageSize;
        String sql = "SELECT * FROM getAllPatient() LIMIT ? OFFSET ?;";
        return jdbcTemplate.query(sql, new Object[]{pageSize, offset}, (rs, rowNum) ->
                new Paciente(
                        rs.getLong("CI_PACIENTE"),
                        rs.getInt("ID_ESTADO_CIVIL"),
                        rs.getDate("FECHA_NACIMIENTO"),
                        rs.getString("DIRECCION"),
                        rs.getString("OCUPACION"),
                        rs.getString("PERSONA_DE_REFERENCIA"),
                        rs.getLong("NUMERO_PERSONA_REF"),
                        rs.getString("IMAGEN"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getLong("NUMERO_TELEFONO")
                ));
    }
    public List<Paciente> findAll() {
        String sql = "SELECT * from getAllPatient();";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Paciente(
                        rs.getLong("CI_PACIENTE"),
                        rs.getInt("ID_ESTADO_CIVIL"),
                        rs.getDate("FECHA_NACIMIENTO"),
                        rs.getString("DIRECCION"),
                        rs.getString("OCUPACION"),
                        rs.getString("PERSONA_DE_REFERENCIA"),
                        rs.getLong("NUMERO_PERSONA_REF"),
                        rs.getString("IMAGEN"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getLong("NUMERO_TELEFONO")
                ));
    }



    public boolean update(Paciente paciente) {
        String sql = "SELECT actualizar_paciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.queryForObject(sql, new Object[]{
                paciente.getCiPaciente(),
                paciente.getIdEstadoCivil(),
                new Date(paciente.getFechaNacimiento().getTime()),
                paciente.getDireccion(),
                paciente.getOcupacion(),
                paciente.getPersonaDeReferencia(),
                paciente.getNumeroPersonaRef(),
                paciente.getImagen(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getNumeroTelefono()
        }, Boolean.class);
    }
    public int contarPacientes() {
        String sql = "SELECT contar_pacientes();";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}

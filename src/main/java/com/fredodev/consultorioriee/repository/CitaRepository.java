package com.fredodev.consultorioriee.repository;

import com.fredodev.consultorioriee.model.Cita;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class CitaRepository {
    private final JdbcTemplate jdbcTemplate;

    public CitaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveCita(Cita cita) {
        String sql = "SELECT insertar_cita(?,?,?,?,?);";
        return Boolean.TRUE.equals(jdbcTemplate.execute((ConnectionCallback<Boolean>) connection -> {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cita.getIdPaciente());
                ps.setDate(2, cita.getFechaCita());
                ps.setTime(3, cita.getHora());
                ps.setInt(4, cita.getDuracionEstimada());
                ps.setString(5, cita.getDescripcionCita());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getBoolean(1);
                    }
                }
            }
            return false;
        }));
    }



}

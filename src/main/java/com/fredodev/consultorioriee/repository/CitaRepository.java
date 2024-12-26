package com.fredodev.consultorioriee.repository;

import com.fredodev.consultorioriee.model.Cita;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
    public List<Cita> findCitasByPaciente(int idPaciente){
        String sql = "SELECT * FROM obtener_citas_por_paciente(?);";
        return jdbcTemplate.query(sql, new Object[]{idPaciente}, (rs, rowNum) ->
                new Cita(
                        rs.getInt("CI_PACIENTE"),
                        rs.getInt("ID_CITA"),
                        rs.getDate("FECHA_CITA"),
                        rs.getTime("HORA"),
                        rs.getInt("DURACION_ESTIMADA"),
                        rs.getString("DESCRIPCION_CITA")
                ));
    }
    public Cita findCitaDetail(int ciPaciente, int idCita){
        String sql = "Select * from obtener_cita(?, ?);";
        return jdbcTemplate.execute((ConnectionCallback<? extends Cita>) connection ->{
           try (PreparedStatement ps = connection.prepareStatement(sql)){
               ps.setInt(1, ciPaciente);
               ps.setInt(2,idCita);
               try(ResultSet rs = ps.executeQuery()){
                   if(rs.next()){
                       return new Cita(
                               ciPaciente,
                               idCita,
                               rs.getDate("FECHA_CITA"),
                               rs.getTime("HORA"),
                               rs.getInt("DURACION_ESTIMADA"),
                               rs.getString("DESCRIPCION_CITA")
                       );
                   }
               }
           }
           return null;
        });
    }



}

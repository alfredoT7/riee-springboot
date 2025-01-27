package com.fredodev.consultorioriee.repository;

import com.fredodev.consultorioriee.model.Tratamiento;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class TratamientoRepository {
    private final JdbcTemplate jdbcTemplate;
    public TratamientoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertarTratamiento(Tratamiento tratamiento){
        String sql = "SELECT insertTreatment(?,?,?,?,?,?,?,?);";
        return Boolean.TRUE.equals(jdbcTemplate.execute((ConnectionCallback<Boolean>) connection -> {
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, tratamiento.getIdTipoTratamiento());
                ps.setInt(2,tratamiento.getPiezaDental());
                ps.setString(3,tratamiento.getDescripcionHistorial());
                ps.setDate(4,tratamiento.getInicioTratamiento());
                ps.setDate(5,tratamiento.getFinTratamiento());
                ps.setDouble(6,tratamiento.getPrecioTotal());
                ps.setDouble(7, tratamiento.getSaldo());
                ps.setBoolean(8, tratamiento.isTratamientoTerminado());
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        return rs.getBoolean(1);
                    }
                }
            }
            return false;
        }));
    }

}

package com.fredodev.consultorioriee.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CitaRepository {
    private final JdbcTemplate jdbcTemplate;

    public CitaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

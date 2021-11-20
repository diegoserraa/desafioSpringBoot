package br.com.uvass.desafiosb.model.repository;
import br.com.uvass.desafiosb.model.entity.Installments;
import org.springframework.jdbc.core.JdbcTemplate;

public class InstallmentsRepository {

    private JdbcTemplate jdbcTemplate;

    public InstallmentsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Installments buscarInstallments(int id) {
        String sql = "select * from installments where id = ?";

        return jdbcTemplate.queryForObject(sql, new InstallmentsMapper(), id);
    }
}

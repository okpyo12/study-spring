package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.Optional;

public class JdbcTemplate {
    public JdbcTemplate(DataSource dataSource) {
    }

    public Optional<Member> query(String s, RowMapper memberRowMapper, Long id) {
        return null;
    }
}

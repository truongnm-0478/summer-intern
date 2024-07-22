package org.example.dao;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String username) {
        String sql = "INSERT INTO users (username, balance) VALUES (?, 0)";
        jdbcTemplate.update(sql, username);
    }

    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new UserRowMapper())
                .stream()
                .findFirst();
    }

    public void save(User user) {
        String sql = "UPDATE users SET username = ?, balance = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getBalance(), user.getId());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setBalance(rs.getDouble("balance"));
            return user;
        }
    }
}
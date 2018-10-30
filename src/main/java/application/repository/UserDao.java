package application.repository;

import application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) {
        String usersSql = "INSERT INTO users (user_name, password, enabled) VALUES (?, ?, ?)";
        String authoritiesSql = "INSERT INTO authorities (user_name, authority) VALUES (?, ?)";
        jdbcTemplate.update(usersSql, user.getName(), user.getPassword(), user.isEnabled());
        jdbcTemplate.update(authoritiesSql, user.getName(), "USER");
    }

    @Override
    public User getByName(String name) {
        String sql = "SELECT * FROM users WHERE user_name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper());
    }
}

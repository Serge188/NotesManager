package application.repository;

import application.entity.User;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public UserMapper() {
    }

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("user_name"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        return user;
    }
}

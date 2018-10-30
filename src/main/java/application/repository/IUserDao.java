package application.repository;

import application.entity.User;

public interface IUserDao {
    void create(User user);
    User getByName(String name);
}

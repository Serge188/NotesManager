package application.service;

import application.entity.User;

public interface IUserService {
//    User getUser(String login);
    void create(User user);
    User getUserByName(String name);
}

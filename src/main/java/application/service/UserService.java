package application.service;

import application.entity.User;
import application.repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    public void create(User user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        userDao.create(user);
    }

    public User getUserByName(String name) {
        return userDao.getByName(name);
    }

}

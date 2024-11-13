package spring.spring_boot.dao;

import spring.spring_boot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}

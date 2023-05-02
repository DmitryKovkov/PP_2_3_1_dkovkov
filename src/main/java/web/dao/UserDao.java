package web.dao;

import web.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void saveUser(User user);
    void deleteUser(Integer id);
    User findUser(int id);
    void updateUser(int id, User user);
}

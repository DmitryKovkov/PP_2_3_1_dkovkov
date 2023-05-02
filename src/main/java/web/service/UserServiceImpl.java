package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUser() {
        System.out.println("список пользователей");
        System.out.println(userDao.listUsers().toString());
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }
}

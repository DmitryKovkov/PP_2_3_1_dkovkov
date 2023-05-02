package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().find(User.class, id));
    }

    @Override
    public User findUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User userForUpdate = sessionFactory.getCurrentSession().get(User.class, id);
        userForUpdate.setName(user.getName());
        userForUpdate.setSurname(user.getSurname());
        userForUpdate.setAge(user.getAge());
        sessionFactory.getCurrentSession().update(userForUpdate);
    }
}

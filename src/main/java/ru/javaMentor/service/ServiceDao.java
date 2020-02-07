package ru.javaMentor.service;
/*
 *
 *@Data 02.02.2020
 *@autor Fedorov Yuri
 *@project CRUD_HIBERNATE
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javaMentor.Dao.UserDao;
import ru.javaMentor.model.User;
import ru.javaMentor.util.HDBConnection;

import java.util.List;

import static ru.javaMentor.util.HDBConnection.getSessionFactory;

public class ServiceDao {
    private static ServiceDao serviceDao;
    private SessionFactory sessionFactory;


    private ServiceDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static ServiceDao getInstance() {
        if (serviceDao == null) {
            serviceDao = new ServiceDao(getSessionFactory());
        }
        return serviceDao;
    }


    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> cars = new UserDao(session).findAll();
        session.close();
        return cars;
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        new UserDao(session).save(user);
        session.close();
    }

    public void removeUser(Long id) {
        Session session = sessionFactory.openSession();
        new UserDao(session).delete(id);
        session.close();
    }

    public User findUserAtId(Long id) {
        Session  session =sessionFactory.openSession();
        User user = new UserDao(session).find(id);
        session.close();
        return user;
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        new UserDao(session).update(user);
        session.close();

    }
}

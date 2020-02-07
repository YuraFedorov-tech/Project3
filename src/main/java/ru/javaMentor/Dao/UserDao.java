package ru.javaMentor.Dao;
/*
 *
 *@Data 02.02.2020
 *@autor Fedorov Yuri
 *@project CRUD_HIBERNATE
 *
 */

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.javaMentor.model.User;

import java.util.List;

public class UserDao implements CrudDao<User> {
    private Session session;
    //language=HQL
    private final String HQL_UPDATE = "update User set name=:name ,color=:color, age=:age where id = :id  ";

    public UserDao(Session session) {
        this.session = session;
    }

    @Override
    public User find(Long id) {
        Query query = session.createQuery("from User where id = '" + id + "' ");
        return (User) query.getSingleResult();
    }

    @Override
    public void save(User model) {
        session.save(model);
    }

    @Override
    public void update(User model) {
        Transaction transaction = session.beginTransaction();
        int age9 = model.getAge();
        Query query = session.createQuery(HQL_UPDATE);
        query.setParameter("name", model.getName());
        query.setParameter("color", model.getColor());
        query.setParameter("id", model.getId());
        query.setParameter("age", age9);
        int result = query.executeUpdate();
        transaction.commit();
    }

    @Override
    public void delete(Long id) {
        String hql = "DELETE User WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int rows = query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<User> findAll() {
        Query query = session.createQuery("FROM User");
        List<User> users = query.list();
        return users;
    }
}

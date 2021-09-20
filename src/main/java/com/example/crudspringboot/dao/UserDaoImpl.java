package com.example.crudspringboot.dao;

import com.example.crudspringboot.model.Role;
import com.example.crudspringboot.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public List<Role> listRoles(int id) {
        return entityManager.createQuery("FROM Role r WHERE r.id=:id ", Role.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("FROM User u WHERE u.email=:email", User.class)
                .setParameter("email", name)
                .getSingleResult();
    }
}

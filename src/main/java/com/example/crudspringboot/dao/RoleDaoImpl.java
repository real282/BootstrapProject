package com.example.crudspringboot.dao;

import com.example.crudspringboot.model.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRole() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("FROM Role r WHERE r.role=:role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}

package com.example.crudspringboot.dao;


import com.example.crudspringboot.model.Role;
import com.example.crudspringboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    List<Role> listRoles(int id);

    void update(User user);

    User getUserById(long id);

    void delete(long id);

    User getUserByName(String name);


}

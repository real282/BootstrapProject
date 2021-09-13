package com.example.crudspringboot.dao;



import com.example.crudspringboot.model.Role;

import java.util.List;

public interface RoleDao {

    void add(Role role);

    List<Role> listRole();

    Role getRoleById(int id);

    Role getRoleByName(String role);
}

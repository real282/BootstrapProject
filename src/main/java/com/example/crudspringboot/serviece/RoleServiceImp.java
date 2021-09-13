package com.example.crudspringboot.serviece;

import com.example.crudspringboot.dao.RoleDao;
import com.example.crudspringboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public List<Role> listRole() {
        return roleDao.listRole();
    }

    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }
}

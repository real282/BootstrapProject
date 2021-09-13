package com.example.crudspringboot.serviece;

import com.example.crudspringboot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;


public interface UserService extends UserDetailsService {
    void add(User user);

    List<User> listUsers();

    User getUserId(long id);

    void delete(long id);

    void update(User user);

}

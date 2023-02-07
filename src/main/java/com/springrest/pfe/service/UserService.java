package com.springrest.pfe.service;

import java.util.List;

import com.springrest.pfe.model.User;

public interface UserService {
 User inscrire(User user);
 boolean authentifier(String email,String password);
    void supprimer(Long ID);
    String notifier(Long ID);
    List<User> findall();
    User findbyid(Long id);
    User testeUser(String email,String password);
}

package com.in28minutes.rest.webservices.restfullwebservices.repository;

import com.in28minutes.rest.webservices.restfullwebservices.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findOne(long id);
    public User save(User user);
}

package com.in28minutes.rest.webservices.restfullwebservices.repository;

import com.in28minutes.rest.webservices.restfullwebservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L, "Adam", new Date()));
        users.add(new User(2L, "Eve", new Date()));
        users.add(new User(3L, "Noah", new Date()));
    }

    private long userCounter = 3;

    public List<User> findAll() {
        return users;
    }

    public User findOne(long id) {
        for (User user : users){
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user.getId()!= null)
            user.setId(++ userCounter);
        users.add(user);
        return user;
    }
}

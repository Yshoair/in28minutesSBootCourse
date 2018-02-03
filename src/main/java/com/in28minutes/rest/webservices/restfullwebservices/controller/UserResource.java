package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.model.User;
import com.in28minutes.rest.webservices.restfullwebservices.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserResource {

    @Autowired
    private UserDao userDaoImpl;

    @GetMapping("/users")
    public List<User>  retrieveAllUsers(){
        return userDaoImpl.findAll();
    }

    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable long userId){
        return userDaoImpl.findOne(userId);
    }

    //input - details of user
    //output - CREATED status code & return created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDaoImpl.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("{id}")
                .buildAndExpand(savedUser.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

}

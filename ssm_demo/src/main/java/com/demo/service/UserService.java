package com.demo.service;

import com.demo.domain.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public User findById(int id);

    public List<User> findAll();

}

package com.example.module4.service;

import com.example.module4.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void delete(Long id);
}

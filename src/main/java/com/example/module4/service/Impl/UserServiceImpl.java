package com.example.module4.service.Impl;

import com.example.module4.entity.User;
import com.example.module4.repository.UserRepository;
import com.example.module4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return  userRepository.findById(id);
    }

    @Override
    public void save(User user) {
            userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
            userRepository.deleteById(id);
    }

}

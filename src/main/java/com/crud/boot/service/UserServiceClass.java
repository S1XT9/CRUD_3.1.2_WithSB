package com.crud.boot.service;

import com.crud.boot.dao.UserRepository;
import com.crud.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceClass implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceClass(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void create(User user) {
        userRepository.create(user);

    }
    @Transactional(readOnly = true)
    @Override
    public User read(Long id) {
        return userRepository.read(id);
    }
    @Transactional
    @Override
    public void update(User user) {
        userRepository.update(user);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }
}

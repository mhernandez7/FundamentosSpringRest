package com.fundamentosRestSpring.fundamentosRestSpring.service;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.Post;
import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import com.fundamentosRestSpring.fundamentosRestSpring.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Log LOG = LogFactory.getLog(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<User> getAllUsers(){return userRepository.findAll();}


}

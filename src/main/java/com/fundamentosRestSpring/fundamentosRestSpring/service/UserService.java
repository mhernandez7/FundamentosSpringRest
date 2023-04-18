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

    //UserService inyecta a userRepository lo cual le permite hacer uso de los metodos de spring (Save)
    public User save (User newUser){
        return userRepository.save(newUser);
    }

    public void  delete(Long id){
         userRepository.delete(new User(id));
    }

    public User update(User user, Long id) {
        return userRepository.findById(id).map(user1 -> {
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setBirthDate(user.getBirthDate());
            return  userRepository.save(user);
        }).get();
    }
}

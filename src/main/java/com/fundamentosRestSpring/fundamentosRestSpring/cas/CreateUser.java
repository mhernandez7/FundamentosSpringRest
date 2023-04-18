package com.fundamentosRestSpring.fundamentosRestSpring.cas;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import com.fundamentosRestSpring.fundamentosRestSpring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser( UserService userService){
        this.userService= userService;
    }
    //Se hace creacion del metodoo save. Para este caso inyectamos la instancia de UserService

    public User save (User newUser){
        return userService.save(newUser);
    }

}

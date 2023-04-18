package com.fundamentosRestSpring.fundamentosRestSpring.cas;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import com.fundamentosRestSpring.fundamentosRestSpring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUSer {

    private UserService userService;
    public DeleteUSer(UserService userService){
        this.userService = userService;
    }

    //Se realiza creacion de metodo el cual inyect userService que implementa repository con metodos de spring
    public void remove(Long id){

         userService.delete(id);
    }
}

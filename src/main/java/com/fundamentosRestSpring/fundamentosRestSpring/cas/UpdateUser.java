package com.fundamentosRestSpring.fundamentosRestSpring.cas;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import com.fundamentosRestSpring.fundamentosRestSpring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;
    public UpdateUser(UserService userService){
        this.userService = userService;
    }

    public User update(User user, Long id) {

       return userService.update(user, id);
    }
}

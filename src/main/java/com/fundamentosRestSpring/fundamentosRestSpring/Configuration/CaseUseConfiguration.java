package com.fundamentosRestSpring.fundamentosRestSpring.Configuration;

import com.fundamentosRestSpring.fundamentosRestSpring.cas.GetUser;
import com.fundamentosRestSpring.fundamentosRestSpring.cas.GetUserImplement;
import com.fundamentosRestSpring.fundamentosRestSpring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){return new GetUserImplement(userService);
    }
}

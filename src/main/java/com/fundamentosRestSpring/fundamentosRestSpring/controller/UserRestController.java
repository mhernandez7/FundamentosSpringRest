package com.fundamentosRestSpring.fundamentosRestSpring.controller;

import com.fundamentosRestSpring.fundamentosRestSpring.cas.CreateUser;
import com.fundamentosRestSpring.fundamentosRestSpring.cas.DeleteUSer;
import com.fundamentosRestSpring.fundamentosRestSpring.cas.GetUser;
import com.fundamentosRestSpring.fundamentosRestSpring.cas.UpdateUser;
import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import com.fundamentosRestSpring.fundamentosRestSpring.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    //CRUD BAJO ARQUITECTURA REST
    //CREATE, READ, UPDATE, DELETE -> POST, GET, UPDATE, DELETE
    //Variable para caso de uso GET
    private GetUser getUser;
    //Variable para caso de uso POST
    private CreateUser createUser;

    private DeleteUSer deleteUSer;
    private UpdateUser updateUser;
    private UserRepository userRepository;

    //Como no se esta inyectando con anotacion sring, se crea constructor para hacer uso de las instancias
    public UserRestController(GetUser getUser, CreateUser createUser
            , DeleteUSer deleteUSer, UpdateUser updateUser, UserRepository userRepository) {

        this.getUser = getUser;
        this.createUser= createUser;
        this.deleteUSer =deleteUSer;
        this.updateUser = updateUser;
        this.userRepository =userRepository;
    }
    //R-> READ
    @GetMapping("/all")
    List<User> get(){
        return getUser.getAll();
    }


    //Post CREATE USER
    @PostMapping("/create")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUSer.remove(id);
       return new ResponseEntity( HttpStatus.NO_CONTENT) ;
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User user, @PathVariable Long id){

        return new ResponseEntity<>(updateUser.update(user,id), HttpStatus.OK);

    }

    // Se realiza paginacion de obtencion de informacion
    //se puede crear su propia clase en vez de utlizar direcmente la del repositorio
    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
        return  userRepository.findAll(PageRequest.of(page, size)).getContent();

    }

}

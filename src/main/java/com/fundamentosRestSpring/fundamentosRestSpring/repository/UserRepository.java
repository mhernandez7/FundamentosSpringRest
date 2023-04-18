package com.fundamentosRestSpring.fundamentosRestSpring.repository;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.Post;
import com.fundamentosRestSpring.fundamentosRestSpring.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository                             //Permite realizar la paginacion para el proyecto
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    //Sort es una implementacion de ordenamiento de data
    @Query("SELECT u from User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    //Query Methods
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    //Query methods con like
    List<User> findByNameLike(String name);

    //Query methods con like
    List<User> findByNameOrEmail(String name, String email);

    //Query methods con between por fecha
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    //Query methods con busqueda por nombre orden por id
    //Tambien se puede con Containing cambiando el nombre a findByNameContainingOrderByIdDesc
    //con lo que se evida traer en el metodo like las designaciones %%
    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findAll();

}

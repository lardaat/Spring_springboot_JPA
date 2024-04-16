package com.kodymskii.spring.springboot.spring_springboot_jpa.controller;


import com.kodymskii.spring.springboot.spring_springboot_jpa.model.User;
import com.kodymskii.spring.springboot.spring_springboot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers(){
        List<User> allUsers = userService.getList();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User GetUser(@PathVariable Long id){
        User user = userService.read(id);

       /* if(user==null){
            System.out.println("There is no user with ID = " + id + " in Database");
        }*/

        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user){

        userService.save(user);
        return user;

    }

    @PutMapping("/users")
    public User updateNewUser(@RequestBody User user){

        userService.save(user);
        return user;

    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "User with id " + id + " deleted successfully";
    }

    @GetMapping("/users/name/{name}")
    public List<User> showAllUsersByName(@PathVariable String name){
        List<User> users = userService.findAllByName(name);
        return users;
    }

//    @DeleteMapping("users/{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
//        try {
//            userService.deleteById(User.class, id);
//            return ResponseEntity.ok("User with id " + id + " deleted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to delete user with id " + id);
//        }
//    }
//
//
//    //Как у Трегулова
//    @DeleteMapping("users/{id}")
//    public String deleteUserTregulov(@PathVariable("id") Long id) {
//
//        User user = userService.read(id);
//        if(user==null){
//            throw new NoSuchUserException("There is not user with ID = " + id + " in Database");
//        }
//
//        userService.deleteById(User.class, id);
//        return "User with ID = " + id + " was deleted";
//
//    }
}

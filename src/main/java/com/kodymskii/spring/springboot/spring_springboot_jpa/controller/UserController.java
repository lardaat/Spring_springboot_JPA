package com.kodymskii.spring.springboot.spring_springboot_jpa.controller;

import com.kodymskii.spring.springboot.spring_springboot_jpa.model.User;
import com.kodymskii.spring.springboot.spring_springboot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getList();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/askDetails")
    public String askUserDetails(Model model) {
        model.addAttribute("user", new User());
        return "user-view";
    }

    @GetMapping("/viewUser")
    public String viewUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "show-user-view";
    }


    @PostMapping("/showDetails") // save
    public String showUserDetails(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/";
    }



    @RequestMapping("/viewDelete")
    public String viewDelete(@ModelAttribute("user") User user) {

        return "delete";
    }



    @GetMapping("/redirectHome")
    public String redirectHome() {
        return "redirect:/";
    }
//
//
//    @GetMapping
//    public List<User> getUsers() {
//        return userService.getList();
//    }
}
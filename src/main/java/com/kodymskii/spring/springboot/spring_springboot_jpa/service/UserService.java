package com.kodymskii.spring.springboot.spring_springboot_jpa.service;


import com.kodymskii.spring.springboot.spring_springboot_jpa.model.User;

import java.util.List;

public interface UserService {
//    void create(User user);
    User read(Long id);
    void save(User user);
    void delete(Long id);

//    void deleteById(Class<?> entityClass, Object id);
//
//    void deleteUserTregulov(Long id);
    List<User> getList();

    public List<User> findAllByName(String name);
}

package com.kodymskii.spring.springboot.spring_springboot_jpa.dao;





import com.kodymskii.spring.springboot.spring_springboot_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByName(String name);

}

package com.brainroot.common;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserRepository repository;

    HomeController(UserRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<User> all()
    {
        return repository.findAll();
    }

}

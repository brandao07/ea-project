package com.example.eaproject.user;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}

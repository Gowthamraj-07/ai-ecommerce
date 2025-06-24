package com.example.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public User registerUser(User s)
    {
        if(repo.findByEmail(s.getEmail()).isPresent())
        {
            return null;
        }
        return repo.save(s);
    }

    public User Login(User s)
    {
        Optional<User>exist=repo.findByEmail(s.getEmail());
        if(exist.isPresent())
        {
            if(exist.get().getPassword().equals(s.getPassword()))
            {
                return exist.get();
            }
        }
        return null;
        
    }
}

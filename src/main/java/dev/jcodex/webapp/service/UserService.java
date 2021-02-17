package dev.jcodex.webapp.service;

import dev.jcodex.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void getUser(int id) {
        repo.getOne(id);
    }
}

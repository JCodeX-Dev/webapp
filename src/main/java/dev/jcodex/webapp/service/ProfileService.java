package dev.jcodex.webapp.service;

import dev.jcodex.webapp.model.Profile;
import dev.jcodex.webapp.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo repo;

    public Profile getProfile() {
        return repo.getOne(1);
        //TODO will change later
    }
}

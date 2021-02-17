package dev.jcodex.webapp.service;

import dev.jcodex.webapp.model.Profile;
import dev.jcodex.webapp.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository repo;

    public Profile getProfile() {
//        Profile profile = repo.getOne(1);
//        System.out.println(profile);
        return repo.findById(1)
                .get();
        //TODO will change later and add .orElse(error page)
    }
}

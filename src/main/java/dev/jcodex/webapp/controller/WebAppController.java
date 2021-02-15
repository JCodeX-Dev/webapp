package dev.jcodex.webapp.controller;

import dev.jcodex.webapp.model.Profile;
import dev.jcodex.webapp.service.ProfileService;
import dev.jcodex.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAppController {
    //todo create services

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public Profile getProfile() {
        return profileService.getProfile();
    }

    @GetMapping("/api/user/{id}")
    public void getUser(@Param("id") int id) {

        userService.getUser(id);
    }
}

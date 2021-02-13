package dev.jcodex.webapp.controller;

import dev.jcodex.webapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAppController {
    //todo create services

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile")
    public void getProfile(){

    }
}

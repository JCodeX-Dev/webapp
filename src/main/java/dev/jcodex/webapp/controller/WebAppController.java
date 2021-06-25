package dev.jcodex.webapp.controller;


import dev.jcodex.webapp.model.*;
import dev.jcodex.webapp.service.FileService;
import dev.jcodex.webapp.service.MailService;
import dev.jcodex.webapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping("api/profile")
public class WebAppController {
    //todo create services

    @Autowired
    private FileService fileService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private MailService mailService;

//    @GetMapping("addfile")
//    public String addFile() throws IOException {
//        Path path = Paths.get("src/main/resources/static/Jeremy_s_Resume.pdf");
//        String mimeType = path.toFile().toURL().openConnection().getContentType();
//        MultipartFile multipartFile = new MockMultipartFile("Jeremy's Resume.pdf", path.getFileName().toString(), mimeType, Files.readAllBytes(path));
//
//        System.out.println("running");
//        return fileService.addFile("Resume", multipartFile);
//    }

    @GetMapping("/{id}/header")
    public Header getHeader(@PathVariable int id) {
        System.out.println("header");
        return profileService.getHeader(id);
    }

    @GetMapping("/{id}/home")
    public Home getHome(@PathVariable int id) {
        System.out.println("home");
        return profileService.getHome(id);
    }

    @GetMapping("/{id}/about")
    public About getAbout(@PathVariable int id) {
        System.out.println("about");
        return profileService.getAbout(id);
    }

    @GetMapping("/{id}/skills")
    public List<Skill> getSkills(@PathVariable int id) {
        System.out.println("skils");
        return profileService.getSkills(id);
    }

    @GetMapping("/{id}/qualifications")
    public Qualification getQualifications(@PathVariable int id) {
        System.out.println("qualifications");
        return profileService.getQualification(id);
    }

    @GetMapping("/{id}/projects")
    public List<Project> getProjects(@PathVariable int id) {
        System.out.println("projects");
        return profileService.getProjects(id);
    }

    @GetMapping("/{id}/blogs")
    public List<Blog> getBlogs(@PathVariable int id) {
        System.out.println("blogs");
        return profileService.getBlogs(id);
    }

    @GetMapping("/{id}/contact")
    public Contact getContact(@PathVariable int id) {
        System.out.println("contact");
        return profileService.getContact(id);
    }

    @GetMapping("/{id}/footer")
    public Footer getFooter(@PathVariable int id) {
        System.out.println("footer");
        return profileService.getFooter(id);
    }

    @GetMapping("/{id}/home/image")
    public ResponseEntity<byte[]> getFile(@PathVariable int id) throws IOException {
        System.out.println("file");
        return profileService.getHomeFile(id);
    }

    @GetMapping("/{id}/about/{type:resume|image}")
    public ResponseEntity<byte[]> getFile(@PathVariable int id, @PathVariable String type) throws IOException {
        System.out.println("file");
        return profileService.getAboutFile(id, type);
    }

    @PostMapping(value = "/{id}/contact/message")
    public ResponseEntity<?> sendMessage(@PathVariable int id, @RequestBody Mail mail) {
        System.out.println("mail");
        return mailService.sendMessage(mail) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

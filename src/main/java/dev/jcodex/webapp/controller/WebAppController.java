package dev.jcodex.webapp.controller;

//import dev.jcodex.webapp.model.Profile;
//import dev.jcodex.webapp.service.ProfileService;
//import dev.jcodex.webapp.service.UserService;

import dev.jcodex.webapp.model.*;
import dev.jcodex.webapp.service.FileService;
import dev.jcodex.webapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/profile")
//@CrossOrigin(origins = "http://localhost:4200")
public class WebAppController {
    //todo create services

    @Autowired
    private FileService fileService;

    @Autowired
    private ProfileService profileService;
//    @Autowired
//    private UserService userService;

//    @GetMapping("/profile")
//    public Profile getProfile() {
//        return profileService.getProfile();
//    }

//    @GetMapping("/api/user/{id}")
//    public void getUser(@RequestParam("id") int id) {
//
//        userService.getUser(id);
//    }


    //    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("addfile")
//    public String addFile() throws IOException {
//        Path path = Paths.get("src/main/resources/static/profile.png");
//        String mimeType = path.toFile().toURL().openConnection().getContentType();
//        MultipartFile multipartFile = new MockMultipartFile("profile.png", path.getFileName().toString(), mimeType, Files.readAllBytes(path));
//
//        System.out.println("running");
//        return fileService.addFile("Profile Image", multipartFile);
//    }

//    @GetMapping("getfile/cv")
//    public ResponseEntity<byte[]> getFile() throws IOException {
//
//        PFile file = fileService.getFile("60c1b20b6f29d14bbda969ed");
//        String fileName = "Jeremy.pdf";
//        System.out.println("file running");
//        HttpHeaders head = new HttpHeaders();
//        head.setContentType(MediaType.parseMediaType("application/pdf"));
//        head.add("content-disposition", "attachment; filename=" + fileName);
//        head.setContentDispositionFormData(fileName, fileName);
//        head.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(file.stream.readAllBytes(), head, HttpStatus.OK);
//        return responseEntity;
//    }

    @GetMapping("/{id}/header")
//    @ResponseBody
    public Header getHeader(@PathVariable int id) {
        System.out.println("header");
        return profileService.getHeader(id);
//        return "{\"navLogo\": \"Jeremy\"}";
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
}

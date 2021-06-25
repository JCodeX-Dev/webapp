package dev.jcodex.webapp.service;
//

import dev.jcodex.webapp.model.*;
import dev.jcodex.webapp.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository repo;

    @Autowired
    FileService fileService;

    public Profile getProfile(int user) {
        return repo.findByProfileId(user);
    }

    public Header getHeader(int user) {
        return getProfile(user).getHeader();
    }

    public Home getHome(int user) {
        return getProfile(user).getHome();
    }

    public About getAbout(int user) {
        return getProfile(user).getAbout();
    }

    public List<Skill> getSkills(int user) {
        return getProfile(user).getSkills();
    }

    public Qualification getQualification(int user) {
        return getProfile(user).getQualifications();
    }

    public List<Project> getProjects(int user) {
        return getProfile(user).getProjects();
    }

    public List<Blog> getBlogs(int user) {
        return getProfile(user).getBlogs();
    }

    public Contact getContact(int user) {
        return getProfile(user).getContact();
    }

    public Footer getFooter(int user) {
        return getProfile(user).getFooter();
    }

    public ResponseEntity<byte[]> getHomeFile(int profile_id) throws IOException {
        Home home = getProfile(profile_id).getHome();
        PFile file = home.getImage();
        byte[] bytes = fileService.getFile(file);
        HttpHeaders headers = fileService.getHeaders(file);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getAboutFile(int profile_id, String type) throws IOException {
        About about = getProfile(profile_id).getAbout();
        PFile file = type.equals("resume") ? about.getResume() : about.getImage();
        byte[] bytes = fileService.getFile(file);
        HttpHeaders headers = fileService.getHeaders(file);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }
}



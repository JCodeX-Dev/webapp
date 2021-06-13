package dev.jcodex.webapp.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

//@Entity(name = "profiles")
@Document(collection = "profiles")
public final class Profile {

    @Id
    private String id;

    @Field("profile_id")
    private int profileId;

    private Header header;

    private Home home;

    private About about;

    private List<Skill> skills;

//    private List<Qualification> qualifications;

    private List<Project> projects;

    private List<Blog> blogs;

    private Contact contact;

    private Footer footer;

    public Header getHeader() {
        return header;
    }

    public Home getHome() {
        return home;
    }

    public About getAbout() {
        return about;
    }

    public List<Skill> getSkills() {
        return skills;
    }

//    public List<Qualification> getQualification() {
//        return qualifications;
//    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public Contact getContact() {
        return contact;
    }

    public Footer getFooter() {
        return footer;
    }

}

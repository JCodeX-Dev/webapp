package dev.jcodex.webapp.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
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

    private Qualification qualifications;

    private List<Project> projects;

    private List<Blog> blogs;

    private Contact contact;

    private Footer footer;

}

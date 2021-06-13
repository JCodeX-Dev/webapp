package dev.jcodex.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Home {

    private String name;
    private String title;
    private String description;
    @DBRef
    @JsonIgnore
    private PFile image;
    private String twitter;
    private String linkedin;
    private String github;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public PFile getImage() {
        return image;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }
}

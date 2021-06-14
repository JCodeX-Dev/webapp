package dev.jcodex.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
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

}

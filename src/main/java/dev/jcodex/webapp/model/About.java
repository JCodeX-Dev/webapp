package dev.jcodex.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class About {

    private String description;

    @DBRef
    @JsonIgnore
    private PFile image;

    @DBRef
    @Field("cv")
    @JsonIgnore
    private PFile resume;

    public String getDescription() {
        return description;
    }

    public PFile getImage() {
        return image;
    }

    public PFile getResume() {
        return resume;
    }
}

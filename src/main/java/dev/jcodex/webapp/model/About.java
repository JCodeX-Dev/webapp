package dev.jcodex.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class About {

    private String description;

    @DBRef
    @JsonIgnore
    private PFile image;

    @DBRef
    @Field("cv")
    @JsonIgnore
    private PFile resume;

}

package dev.jcodex.webapp.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class FileMeta {

    @Field("_contentType")
    private String contentType;

    private String title;
}

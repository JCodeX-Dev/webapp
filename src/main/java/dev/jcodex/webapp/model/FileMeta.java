package dev.jcodex.webapp.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class FileMeta {

    @Field("_contentType")
    private String contentType;

    private String title;

    public String getContentType() {
        return contentType;
    }

    public String getTitle() {
        return title;
    }

}

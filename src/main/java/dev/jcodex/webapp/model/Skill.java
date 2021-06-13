package dev.jcodex.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class Skill {
    private String category;

    private List<String> technology;

    public String getCategory() {
        return category;
    }

    public List<String> getTechnology() {
        return technology;
    }
}

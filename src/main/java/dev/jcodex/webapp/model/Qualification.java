package dev.jcodex.webapp.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Qualification {

    List<QType> education;

    List<QType> work;
}

@Getter
class QType {
    private String title;

    private String location;

    private String duration;

}

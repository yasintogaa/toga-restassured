package entities.models;

import entities.enums.Status;

import java.util.List;

public class Pet {

    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;




}

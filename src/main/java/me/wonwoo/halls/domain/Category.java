package me.wonwoo.halls.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Category {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<Question> questions;

    Category() {

    }

    public Category(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
}

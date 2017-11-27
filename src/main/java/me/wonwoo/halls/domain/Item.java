package me.wonwoo.halls.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Item {

    @Id
    private String id;
    private String content;

    Item() {}

    public Item(String content) {
        this.content = content;
    }


}


package me.wonwoo.halls.domain;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Question {

    @Id
    private String id;

    private String question;

    private String answer;

    @DBRef
    private List<Item> items;

    Question() {

    }

    public Question(String question, String answer, List<Item> items) {
        this.question = question;
        this.answer = answer;
        this.items = items;
    }

    public List<Item> random() {
        Collections.shuffle(this.items);
        return this.items;
    }

    public int answerIndex() {
        int index = 1;
        for (Item item : items) {
            if (answer.equals(item.getContent())) {
                return index;
            }
            index++;
        }
        throw new IllegalStateException("answer index not found");
    }

}

package me.wonwoo.halls.web;

import java.util.List;

import lombok.Data;
import me.wonwoo.halls.domain.Item;

@Data
public class QuestionDto {

    private String question;

    private String answer;

    private List<Item> items;
    private Integer index;

    QuestionDto() {}

    public QuestionDto(String question, String answer, List<Item> items, Integer index) {
        this.question = question;
        this.answer = answer;
        this.items = items;
        this.index = index;
    }
}

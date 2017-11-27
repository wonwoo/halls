package me.wonwoo.halls.web;

import me.wonwoo.halls.domain.Question;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

//@RestController
@Controller
public class QuestionController {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public QuestionController(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    //    @GetMapping("/")
    //    public Flux<QuestionDto> getQuestion() {
    //        SampleOperation matchStage = Aggregation.sample(5);
    //        Aggregation aggregation = Aggregation.newAggregation(matchStage);
    //        Flux<Question> collectionName = reactiveMongoTemplate.aggregate(aggregation, "question", Question.class);
    //        return collectionName
    //                .map(question -> new QuestionDto(
    //                        question.getQuestion(),
    //                        question.getAnswer(),
    //                        question.random(),
    //                        question.answerIndex()));
    //    }

    @GetMapping("/")
    public Rendering getQuestion() {
        SampleOperation matchStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(matchStage);
        return Rendering.view("index")
                .modelAttribute("questions", reactiveMongoTemplate.aggregate(aggregation, "question", Question.class)
                        .map(q -> new QuestionDto(
                                q.getQuestion(),
                                q.getAnswer(),
                                q.random(),
                                q.answerIndex())).next())
                .build();
    }
}

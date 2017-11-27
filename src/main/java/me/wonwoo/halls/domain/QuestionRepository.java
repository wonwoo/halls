package me.wonwoo.halls.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
}

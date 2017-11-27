package me.wonwoo.halls;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.wonwoo.halls.domain.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final ItemRepository itemRepository;

    public DataInitializer(CategoryRepository categoryRepository, QuestionRepository questionRepository,
            ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Item> items = Arrays.asList(new Item("ConstructorInterceptor"), new Item("JmsGatewaySupport"),
                new Item("CachingConnectionFactory"), new Item("ByteToMessageDecoder"));

        Question question = new Question("this is a nothing", "ByteToMessageDecoder", items);

        List<Item> items1 = Arrays.asList(new Item("SimpleLog"), new Item("FlowControlHandler"), new Item("LocalVariableTableParameterNameDiscoverer"), new Item("SpringObjenesis"));

        Question question1 = new Question("this is a nothing1", "FlowControlHandler", items1);

        Question question2 = new Question("this is a nothing2", "FlowControlHandler", items1);

        Question question3 = new Question("this is a nothing3", "FlowControlHandler", items1);

        Question question4 = new Question("this is a nothing4", "FlowControlHandler", items1);

        Question question5 = new Question("this is a nothing5", "FlowControlHandler", items1);

        Question question6 = new Question("this is a nothing6", "FlowControlHandler", items1);

        Question question7 = new Question("this is a nothing7", "FlowControlHandler", items1);

        Question question8 = new Question("this is a nothing8", "FlowControlHandler", items1);

        List<Question> questions = Arrays.asList(question, question1, question2, question3, question4, question5, question6, question7, question8);
        Category category = new Category("spring boot", questions);

        categoryRepository.deleteAll()
                .thenMany(questionRepository.deleteAll())
                .thenMany(itemRepository.deleteAll())
                .thenMany(itemRepository.saveAll(items))
                .thenMany(itemRepository.saveAll(items1))
                .thenMany(questionRepository.saveAll(questions))
                .thenMany(categoryRepository.save(category))
                .subscribe(System.out::println);

    }
}

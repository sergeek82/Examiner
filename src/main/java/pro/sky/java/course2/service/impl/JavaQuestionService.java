package pro.sky.java.course2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();

    {
        questions.add(Question.builder().question("What is JAVA").answer("Programming language").build());
        questions.add(Question.builder().question("What is Heap").answer("It's a memory section").build());
        questions.add(Question.builder().question("What is JVM").answer("It's a Java Virtual Machine").build());
        questions.add(Question.builder().question("What is JRE").answer("It's a Java Runtime Environment").build());
        questions.add(Question.builder().question("Where Objects store").answer("In the heap").build());
    }

    @Override
    public Question add(String question, String answer) {
        Question questionObj = Question.builder().question(question).answer(answer).build();
        this.questions.add(questionObj);
        return questionObj;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }

    @Override
    public Question getRandomQuestion() {
        return this.questions.stream()
                .skip(new Random().nextInt(questions.size()))
                .findFirst()
                .orElse(Question.builder().build());
    }
}

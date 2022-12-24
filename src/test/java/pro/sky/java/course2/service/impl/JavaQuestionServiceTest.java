package pro.sky.java.course2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.java.course2.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private Question question;

    @BeforeEach
    void init() {
        javaQuestionService = new JavaQuestionService();
        question = Question.builder().question("What is JAVA").answer("Programming language").build();
    }

    @Test
    void add() {
        int size = javaQuestionService.questions.size();
        javaQuestionService.add(Question.builder().question("qwe").answer("ans").build());
        Assertions.assertEquals(size + 1, javaQuestionService.questions.size());
    }

    @Test
    void testAdd() {
        int size = javaQuestionService.questions.size();
        javaQuestionService.add("str", "ans");
        Assertions.assertEquals(size + 1, javaQuestionService.questions.size());
    }

    @Test
    void remove() {
        int size = javaQuestionService.questions.size();
        javaQuestionService.remove(question);
        Assertions.assertEquals(size - 1, javaQuestionService.questions.size());
    }

    @Test
    void getAll() {
        javaQuestionService.getAll();
        Assertions.assertEquals(5, javaQuestionService.questions.size());
    }

    @Test
    void getRandomQuestion() {
        JavaQuestionService service = Mockito.mock(JavaQuestionService.class);
        Mockito.when(service.getRandomQuestion()).thenReturn(question);
        assertEquals(question, service.getRandomQuestion());
    }
}
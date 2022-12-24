package pro.sky.java.course2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.exception.ImpossibleAmount;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Spy
    JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Collection<Question> questions = examinerService.getQuestions(3);
        assertEquals(3, questions.size());
        assertThrows(ImpossibleAmount.class, () -> examinerService.getQuestions(6));
    }
}
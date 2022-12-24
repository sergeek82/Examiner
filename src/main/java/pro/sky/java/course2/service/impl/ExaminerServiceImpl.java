package pro.sky.java.course2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.exception.ImpossibleAmount;
import pro.sky.java.course2.service.ExaminerService;
import pro.sky.java.course2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final JavaQuestionService javaQuestionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = javaQuestionService.getAll().size();
        if (size < amount) {
            throw new ImpossibleAmount();
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() != amount)
            questionSet.add(questionService.getRandomQuestion());
        return questionSet;
    }
}

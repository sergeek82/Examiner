package pro.sky.java.course2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.QuestionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    @PostMapping("/add")
    ResponseEntity<?> addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.add(question, answer));
    }

    @DeleteMapping("/remove")
    ResponseEntity<?> removeQuestion(@RequestParam String question, String answer) {
        return ResponseEntity.ok(questionService.remove(Question.builder().question(question).answer(answer).build()));
    }

    @GetMapping
    ResponseEntity<?> getAllQuestion() {
        return ResponseEntity.ok(questionService.getAll());
    }
}

package pro.sky.java.course2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.service.ExaminerService;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping("/exam")
    ResponseEntity<?>getQuestions(int amount){
        return ResponseEntity.ok(examinerService.getQuestions(amount));
    }
}

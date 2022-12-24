package pro.sky.java.course2.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private String question;
    private String answer;
}

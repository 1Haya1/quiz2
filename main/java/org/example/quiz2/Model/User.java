package org.example.quiz2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotNull(message = "should be not null")
    private Integer id;

    @NotEmpty(message = "should be not empty")
    private String name;

    @NotNull(message = "should be not null")
    @Positive(message = "should be positive")
    private Integer age;

    @NotNull(message = "should be not null")
    private Integer balance;
}

package org.example.quiz2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    @NotNull(message = "should be not empty")
    private Integer id;

    @NotNull(message = "should be not empty")
    private String name;


    @NotEmpty(message = "should be not empty")
    @Positive(message = "should be positive")
    private Integer numPage;

    @NotNull(message = "should be not empty")
    private Integer price;


}

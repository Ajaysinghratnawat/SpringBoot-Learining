package com.ajay.RestAndMVC.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

//    @NotNull
//    @NotEmpty
    @NotBlank(message = "Name cant blank")
    @Size(min = 3,max = 10,message = "Number of character in name")
    private String name;

    @Email(message = "email should a valid email")
    private String email;

    @Max(value = 80,message = "Age cant greater than 80")
    @Min(value = 18,message = "Age cant less than 18")
    @Positive(message = "Age should be positive")
    @Digits(integer = 2, fraction = 0,message = "Age should be two digit number only")
//    @PositiveOrZero(message = "Age should be positive or zero")
//    @Negative(message = "less than 0")
//    @NegativeOrZero
    private Integer age;

//    @NotBlank
//    @Pattern(regexp = "^(ADMIN|USER)",message = "This only ADMIN or USER only")
//    private String role;

    @Past(message = "Only past date not a present date")
//    @PastOrPresent(message = "Past date or present date")
//    @Future(message = "Future date only")
//    @FutureOrPresent(message = "Future date or present date")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private boolean isActive;
}

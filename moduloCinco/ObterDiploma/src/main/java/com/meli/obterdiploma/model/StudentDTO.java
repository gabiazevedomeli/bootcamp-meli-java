package com.meli.obterdiploma.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentDTO {
    @NotBlank(message = "O nome do aluno não pode ficar vazio.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ/s]+", message = "O nome do aluno deve começar com letra maiúscula.")
    @Size(min = 3, max = 50, message = "O comprimento do nome não pode exceder 50 caracteres.")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "A lista não pode estar vazia.")
    List<@Valid SubjectDTO> subjects;
}

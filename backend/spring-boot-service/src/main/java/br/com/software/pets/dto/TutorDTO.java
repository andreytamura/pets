package br.com.software.pets.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TutorDTO {

    private String id;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @NotEmpty
    @Size(min = 11, message = "user name should have at least 11 characters")
    private String cpf;

    @NotEmpty
    @Size(min = 11, message = "user name should have at least 11 characters")
    private String telephone;

    private Date createdAt;

    private Date updatedAt;
}

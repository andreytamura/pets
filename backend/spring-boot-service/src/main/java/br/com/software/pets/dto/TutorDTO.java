package br.com.software.pets.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TutorDTO {

    private String id;

    private String name;

    private String cpf;

    private String telephone;

    private Date createdAt;

    private Date updatedAt;
}

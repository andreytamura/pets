package br.com.software.pets.dto;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

@Builder
@Data
public class TutorDTO {

    private ObjectId id;

    private String name;

    private String cpf;

    private String telephone;
}

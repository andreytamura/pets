package br.com.software.pets.bd.mongo.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tutor")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tutor extends BaseModel {

    private String name;

    @Field(name = "CPF")
    private String cpf;

    private String telephone;
}

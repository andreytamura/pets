package br.com.software.pets.bd.mongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "tutor")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@SuperBuilder
@Builder
@Data
public class Tutor extends BaseModel {

    private String name;

    @Field(name = "CPF")
    private String cpf;

    private String telephone;

    public Tutor(String id, Date createdAt, Date updatedAt, String name, String cpf, String telephone) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
    }

    public Tutor(String cpf){
        super();
        this.cpf = cpf;
    }

    public Tutor(){
        super();
    }

}

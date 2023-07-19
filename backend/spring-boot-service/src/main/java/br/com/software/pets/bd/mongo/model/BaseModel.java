package br.com.software.pets.bd.mongo.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@SuperBuilder
public abstract class BaseModel {

    @MongoId(FieldType.OBJECT_ID)
    protected String id;

    protected Date createdAt;

    protected Date updatedAt;

    public BaseModel(String id, Date createdAt, Date updatedAt){
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseModel(){}
}

package br.com.software.pets.bd.mongo.repository.impl;

import br.com.software.pets.bd.mongo.model.Tutor;
import br.com.software.pets.bd.mongo.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class TutorRepositoryImpl implements TutorRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Tutor> getAllTutores() {
        return mongoTemplate.findAll(Tutor.class);
    }

}

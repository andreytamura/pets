package br.com.software.pets.bd.mongo.repository.impl;

import br.com.software.pets.bd.mongo.model.Tutor;
import br.com.software.pets.bd.mongo.repository.TutorRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorRepositoryImpl implements TutorRepository {
    private MongoTemplate mongoTemplate;

    public TutorRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Tutor> getAllTutores() {
        return mongoTemplate.findAll(Tutor.class);
    }

    @Override
    public Tutor addTutor(Tutor tutor) {
        return mongoTemplate.save(tutor);
    }

    @Override
    public Tutor getByCpf(String cpf) {
        Query query = new Query(Criteria.where("CPF").is(cpf));
        return mongoTemplate.findOne(query, Tutor.class);
    }

    @Override
    public Tutor updateTutor(Tutor Tutor) {
        return mongoTemplate.save(Tutor);
    }

    @Override
    public void deleteTutor(Tutor tutor) {
        mongoTemplate.remove(tutor);
    }
}

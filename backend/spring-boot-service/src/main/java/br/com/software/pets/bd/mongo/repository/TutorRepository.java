package br.com.software.pets.bd.mongo.repository;

import br.com.software.pets.bd.mongo.model.Tutor;

import java.util.List;

public interface TutorRepository {
    List<Tutor> getAllTutores();
}

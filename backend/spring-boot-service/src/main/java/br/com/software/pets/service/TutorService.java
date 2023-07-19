package br.com.software.pets.service;

import br.com.software.pets.dto.TutorDTO;

import java.util.List;

public interface TutorService {
    List<TutorDTO> getAllTutores();

    TutorDTO addTutor(TutorDTO tutorNewDTO);

    TutorDTO getByCpf(String cpf);

    TutorDTO updateTutor(TutorDTO tutorNewDTO);

    TutorDTO deleteTutor(TutorDTO tutorNewDTO);
}

package br.com.software.pets.service.impl;

import br.com.software.pets.bd.mongo.model.Tutor;
import br.com.software.pets.bd.mongo.repository.TutorRepository;
import br.com.software.pets.dto.TutorDTO;
import br.com.software.pets.mapper.TutorMapper;
import br.com.software.pets.service.TutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private TutorMapper tutorMapper;
    private TutorRepository tutorRepository;

    TutorServiceImpl(TutorRepository tutorRepository, TutorMapper tutorMapper) {
        this.tutorMapper = tutorMapper;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public List<TutorDTO> getAllTutores() {
        return tutorMapper.tutoresToTutoresDTO(tutorRepository.getAllTutores());
    }

    @Override
    public TutorDTO addTutor(TutorDTO tutorNewDTO) {
        return tutorMapper.tutorToTutorDTO(tutorRepository.addTutor(tutorMapper.tutorDTOToTutor(tutorNewDTO)));
    }

    @Override
    public TutorDTO getByCpf(String cpf) {
        return tutorMapper.tutorToTutorDTO(tutorRepository.getByCpf(cpf));
    }

    @Override
    public TutorDTO updateTutor(TutorDTO tutorNewDTO) {
        TutorDTO tutorBD = this.getByCpf(tutorNewDTO.getCpf());
        tutorBD.setName(tutorNewDTO.getName());
        tutorBD.setTelephone(tutorNewDTO.getTelephone());
        return this.addTutor(tutorBD);
    }

    @Override
    public TutorDTO deleteTutor(TutorDTO tutorNewDTO) {
        tutorRepository.deleteTutor(tutorMapper.tutorDTOToTutor(this.getByCpf(tutorNewDTO.getCpf())));
        return tutorNewDTO;
    }

}

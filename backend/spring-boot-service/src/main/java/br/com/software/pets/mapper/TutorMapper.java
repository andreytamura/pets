package br.com.software.pets.mapper;

import br.com.software.pets.bd.mongo.model.Tutor;
import br.com.software.pets.dto.TutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);
    TutorDTO tutorToTutorDTO(Tutor tutor);
    List<TutorDTO> tutoresToTutoresDTO(List<Tutor> tutor);
    Tutor tutorDTOToTutor(TutorDTO tutorDTO);
}

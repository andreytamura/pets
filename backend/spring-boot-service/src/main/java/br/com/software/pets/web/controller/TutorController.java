package br.com.software.pets.web.controller;

import br.com.software.pets.dto.TutorDTO;
import br.com.software.pets.service.TutorService;
import br.com.software.pets.web.response.ResponseHandler;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {
    private TutorService tutorService;

    TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<Object> get() {
        return ResponseHandler.generateResponse("Dados recuperados com sucesso!", HttpStatus.OK, tutorService.getAllTutores());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getByCpf(@PathVariable @NotEmpty String cpf) {
        return ResponseHandler.generateResponse("Dado recuperado com sucesso!", HttpStatus.OK, tutorService.getByCpf(cpf));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Valid TutorDTO tutorNewDTO){
        return ResponseHandler.generateResponse("Dado atualizado com sucesso!", HttpStatus.OK, tutorService.updateTutor(tutorNewDTO));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody @Valid TutorDTO tutorNewDTO) {
        return ResponseHandler.generateResponse("Dado inserido com sucesso!", HttpStatus.OK, tutorService.addTutor(tutorNewDTO));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> delete(@RequestBody @Valid TutorDTO tutorNewDTO) {
        return ResponseHandler.generateResponse("Dado removidos com sucesso!", HttpStatus.OK, tutorService.deleteTutor(tutorNewDTO));
    }

}

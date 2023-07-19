package br.com.software.pets.web.controller;

import br.com.software.pets.dto.TutorDTO;
import br.com.software.pets.service.TutorService;
import br.com.software.pets.web.response.ResponseHandler;
import jakarta.validation.Valid;
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
    public ResponseEntity<Object> getByCpf(@PathVariable String cpf) {
        return ResponseHandler.generateResponse("Dados recuperados com sucesso!", HttpStatus.OK, tutorService.getByCpf(cpf));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> addStudent(@RequestBody @Valid TutorDTO tutorNewDTO) {
        return ResponseHandler.generateResponse("Dados inserido com sucesso!", HttpStatus.OK, tutorService.addTutor(tutorNewDTO));
    }
}

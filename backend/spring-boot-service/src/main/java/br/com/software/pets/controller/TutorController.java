package br.com.software.pets.controller;

import br.com.software.pets.dto.TutorDTO;
import br.com.software.pets.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorController {
    private TutorService tutorService;

    TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/tutores")
    public ResponseEntity<Object> get() {
        try {
            List<TutorDTO> result = tutorService.getAllTutores();
            return ResponseHandler.generateResponse("Dados recuperados com sucesso!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}

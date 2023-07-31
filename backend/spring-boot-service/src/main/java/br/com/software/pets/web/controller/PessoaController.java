package br.com.software.pets.web.controller;

import br.com.software.pets.bd.mongo.model.Pessoa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaController {

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET, produces = "application/json")
    public List<Pessoa> Get() {
        return null;
    }
}
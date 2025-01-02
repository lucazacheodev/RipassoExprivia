package it.lucadev.people.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.lucadev.people.dto.PersonDto;
import it.lucadev.people.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public ResponseEntity<List<PersonDto>> getPeople() {
        
        List<PersonDto> dtoList = service.getPeople();
        return ResponseEntity.ok(dtoList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id) {

        PersonDto dto = service.getPerson(id);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){

        boolean res = service.deletePerson(id);

        if (res) {            
            return ResponseEntity.ok("Person deleted succesfully");
            // return new ResponseEntity<String>("Person deleted succesfully", HttpStatus.OK); alternativa
        } else {            
            return new ResponseEntity<String>("Person not found", HttpStatus.NOT_FOUND);         
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");  alternativa
        }
        
    }
    
    // addPerson non dovrebbe generare eccezioni poichè chiamate con dati errati non raggiungono il controller  
    @PostMapping("/")
    public ResponseEntity<?> addPerson(@RequestBody PersonDto dto) {

        PersonDto added = service.addPerson(dto);      
        
        return ResponseEntity.ok(added);
    }    

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody PersonDto inDto) {
        
       PersonDto outDto = service.updatePerson(inDto, id);

        if (outDto == null) {
            return new ResponseEntity<String>("Person not found", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(outDto);
        }
    }
    
}

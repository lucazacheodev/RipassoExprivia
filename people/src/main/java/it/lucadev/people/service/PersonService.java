package it.lucadev.people.service;

import java.util.List;

import it.lucadev.people.dto.PersonDto;

public interface PersonService {

    public List<PersonDto> getPeople();
    public PersonDto getPerson(Long id);
    public boolean deletePerson(Long id);
    public PersonDto addPerson(PersonDto dto);
    public PersonDto updatePerson(PersonDto dto, Long id);

}
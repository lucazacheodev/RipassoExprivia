package it.lucadev.people.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lucadev.people.dto.PersonDto;
import it.lucadev.people.entity.Person;
import it.lucadev.people.repository.PersonRepository;
import it.lucadev.people.service.PersonService;
import it.lucadev.people.utility.mapper.PersonMapper;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repo;

    @Autowired
    PersonMapper mapper;

    @Override
    public List<PersonDto> getPeople() {
        List<Person> entityList = repo.findAll();
        List<PersonDto> dtoList = mapper.entityToDtoList(entityList);
        return dtoList;

    }

    @Override
    public PersonDto getPerson(Long id) {
        Optional<Person> opt = repo.findById(id);

        if (!opt.isPresent()){
            return null;
        }

        Person entity = opt.get();
        PersonDto dto = mapper.entityToDto(entity);
        return dto;

    }

    @Override
    public boolean deletePerson(Long id) {

        if(!repo.existsById(id)){
            return false;
        }

        repo.deleteById(id);
        return true;
    }

    @Override
    public PersonDto addPerson(PersonDto dto) {
        
        Person entity = mapper.dtoToEntity(dto);
        Person saved = repo.save(entity);
        PersonDto outDto = mapper.entityToDto(saved);
        return outDto;

    }

    // Metodo aggiorna la vecchia entità
    @Override
    public PersonDto updatePerson(PersonDto dto, Long id) {

        if (!repo.existsById(id)) {
            return null;
        }

        Optional<Person> opt = repo.findById(id);
        Person old = opt.get();
        Person updated = mapper.dtoToEntity(dto, old);
        repo.save(updated);

        dto.setId(id);

        return dto;
    }

    // Metodo che sostituisce la vecchia entità con una nuova (stesso ID)
    // @Override
    // public PersonDto updatePerson(PersonDto dto, Long id) {

    //     if (!repo.existsById(id)) {
    //         return null;
    //     }

    //     repo.deleteById(id);

    //     Person entity = mapper.dtoToEntity(dto);
    //     entity.setId(id);
    //     repo.save(entity);

    //     return dto;
    // }

}

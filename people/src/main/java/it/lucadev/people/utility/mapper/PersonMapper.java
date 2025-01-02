package it.lucadev.people.utility.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
// import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import it.lucadev.people.dto.PersonDto;
import it.lucadev.people.entity.Person;

@Component
public class PersonMapper {

    public PersonDto entityToDto(Person entity){

        PersonDto dto = new PersonDto();

        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setId(entity.getId());
        dto.setMarried(entity.isMarried());
        dto.setName(entity.getName());
        dto.setId(entity.getId());

        return dto;
    }

    public List<PersonDto> entityToDtoList(List<Person> entityList){

        List<PersonDto> dtoList = new ArrayList<PersonDto>();

        for (Person x : entityList) {
            PersonDto dto = entityToDto(x);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public Person dtoToEntity(PersonDto dto, Person entity){

        entity.setBirthDate(dto.getBirthDate());
        entity.setGender(dto.getGender());
        entity.setMarried(dto.isMarried());
        entity.setName(dto.getName());
        entity.setAge(Period.between(dto.getBirthDate(), LocalDate.now()).getYears());      
        // entity.setAge(((int)ChronoUnit.YEARS.between(dto.getBirthDate(),LocalDate.now()))); alternativa
        return entity;
    }

    public Person dtoToEntity(PersonDto dto) {
        return dtoToEntity(dto, new Person());
    }
    
}

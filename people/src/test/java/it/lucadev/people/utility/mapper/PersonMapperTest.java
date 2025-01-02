package it.lucadev.people.utility.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;

import it.lucadev.people.dto.PersonDto;
import it.lucadev.people.entity.Person;

public class PersonMapperTest {

    @Test
    public void testDtoToEntity() {
        PersonDto dto = new PersonDto();
        dto.setName("Luca Zacheo");
        dto.setBirthDate(LocalDate.of(1994, 10, 17));
        dto.setGender('M');
        dto.setMarried(false);

        PersonMapper mapper = new PersonMapper();
        Person entity = mapper.dtoToEntity(dto);

        assertNotNull(entity, "L'oggetto Entity non dovrebbe essere null");
        assertEquals("Luca Zacheo", entity.getName(), "Il nome dovrebbe corrispondere");
        assertEquals(LocalDate.of(1994, 10, 17), entity.getBirthDate(), "La data di nascita dovrebbe corrispondere");
        assertEquals('M', entity.getGender(), "Il genere dovrebbe corrispondere");
        assertEquals(false, entity.isMarried(), "Lo stato civile dovrebbe corrispondere");
        assertEquals(Period.between(LocalDate.of(1994, 10, 17), LocalDate.now()).getYears(),
                entity.getAge(), "L'età dovrebbe essere calcolata correttamente");
    }
}


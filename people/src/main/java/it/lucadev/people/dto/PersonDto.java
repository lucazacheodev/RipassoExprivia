package it.lucadev.people.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PersonDto {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private char gender;
    private boolean married;


    public PersonDto() {
    }

    public PersonDto(String name, LocalDate birthDate, char gender, boolean married) {
        this.id = -1L;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.married = married;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isMarried() {
        return this.married;
    }

    public boolean getMarried() {
        return this.married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public PersonDto name(String name) {
        setName(name);
        return this;
    }

    public PersonDto birthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public PersonDto gender(char gender) {
        setGender(gender);
        return this;
    }

    public PersonDto married(boolean married) {
        setMarried(married);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonDto)) {
            return false;
        }
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(name, personDto.name) && Objects.equals(birthDate, personDto.birthDate) && gender == personDto.gender && married == personDto.married;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, gender, married);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", gender='" + getGender() + "'" +
            ", married='" + isMarried() + "'" +
            "}";
    }
    
}

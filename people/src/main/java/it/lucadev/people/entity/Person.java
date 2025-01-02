package it.lucadev.people.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private char gender;
    private boolean married;
    private int age;

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthDate, char gender, boolean married, int age) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.married = married;
        this.age = age;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return this.id;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person name(String name) {
        setName(name);
        return this;
    }

    public Person birthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public Person gender(char gender) {
        setGender(gender);
        return this;
    }

    public Person married(boolean married) {
        setMarried(married);
        return this;
    }

    public Person age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate) && gender == person.gender && married == person.married && age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, gender, married, age);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", gender='" + getGender() + "'" +
            ", married='" + isMarried() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

}

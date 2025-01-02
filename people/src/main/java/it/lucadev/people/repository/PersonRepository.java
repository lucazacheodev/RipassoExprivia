package it.lucadev.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lucadev.people.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}

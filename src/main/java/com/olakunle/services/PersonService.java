package com.olakunle.services;

import com.olakunle.entities.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    List<Person> fetchPersons();
    String addPerson(Person person);

    Person getPersonById(Long id);
    void deletePerson (Long id);
}

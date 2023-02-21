package com.olakunle.serviceImpls;

import com.olakunle.entities.Person;
import com.olakunle.repositories.PersonRepository;
import com.olakunle.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    @Override
    public List<Person> fetchPersons() {
        List<Person> persons = personRepository.findAll();
            return  persons;
    }

    @Override
    public String addPerson(Person person) {
        personRepository.save(person);
        return "Saved Successfully";
    }
}

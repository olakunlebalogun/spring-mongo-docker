package com.olakunle.serviceImpls;

import com.olakunle.entities.Person;
import com.olakunle.repositories.PersonRepository;
import com.olakunle.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        if(person.getId() == null) {
            personRepository.save(person);
        }
        else {
            Person fetchedPerson = personRepository.findById(person.getId()).get();
            fetchedPerson.setOccupation(person.getOccupation());
            fetchedPerson.setFirstName(person.getFirstName());
            fetchedPerson.setLastName(person.getLastName());
//            person.setId(fetchedPerson.getId());
            personRepository.save(fetchedPerson);

        }
//        personRepository.save(person);
        return "Saved Successfully";
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            return personOptional.get();
        }

        return null; //  I don't know if this will make  sense, I guess we will find out.
    }

    @Override
    public void deletePerson (Long id) {
        if (personRepository.existsById(id))
            personRepository.deleteById(id);
        else {
            throw new RuntimeException("Person with ID " + id + " does not exist");
        }
    }
}

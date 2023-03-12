package com.olakunle.controllers;


import com.olakunle.entities.Person;
import com.olakunle.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("index")
    public String testing () {
        return "index";
    }

    @GetMapping("/page")
    public String getAllPersons (Model model) {
        model.addAttribute("person", new Person());
        List<Person> personList = personService.fetchPersons();
        model.addAttribute("persons", personList);

        return "person_page";
    }


    @GetMapping ("/page/{id}/update")
    public String updatePerson(@PathVariable("id") String id, Model model){
        Person person = personService.getPersonById(Long.valueOf(id));
        List<Person> personList = personService.fetchPersons();
        model.addAttribute("persons", personList);

        model.addAttribute("person", person);
        return "person_page";
    }

    @GetMapping("/page/{id}/delete")
    public String deletePerson (@PathVariable("id") String id, Model model) {
        personService.deletePerson(Long.valueOf(id));

//        List<Person> personList = personService.fetchPersons();
//        model.addAttribute("persons", personList);
        return "redirect:/person/page";
    }




    @PostMapping("/page")
    public String addPerson(@ModelAttribute("person") Person person) {
        personService.addPerson(person);
        return "redirect:/person/page";
    }

}

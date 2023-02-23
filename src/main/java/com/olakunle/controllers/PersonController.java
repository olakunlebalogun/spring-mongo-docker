package com.olakunle.controllers;


import com.olakunle.entities.Person;
import com.olakunle.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Person> personList = personService.fetchPersons();
        model.addAttribute("persons", personList);
        return "person_page";
    }

    @PostMapping("/page")
    public String addPerson(@ModelAttribute("person") Person person) {
//        model.addAttribute("person", person);
        personService.addPerson(person);
        return "person_page";
    }
}

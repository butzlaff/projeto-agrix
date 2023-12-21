package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.farm.controller.dto.PersonDto;
import com.betrybe.agrix.farm.controller.dto.PersonDtoWithoutPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest Controller for Persons.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create a Person.
   */

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDtoWithoutPassword createPerson(@RequestBody PersonDto personDto) {
    Person person = personService.create(personDto.toEntity());
    return PersonDtoWithoutPassword.fromEntity(person);
  }
}
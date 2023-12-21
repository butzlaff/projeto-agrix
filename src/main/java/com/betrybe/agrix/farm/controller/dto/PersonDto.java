package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Create a Record for Persons.
 */
public record PersonDto(Long id, String username, String password, Role role) {
  /**
   * Transform a Person into a PersonDto.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getPassword(),
        person.getRole());
  }
  
  /**
   * Transform a PersonDto into a Person.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}

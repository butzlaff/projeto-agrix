package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Create a PersonDtoWithoutPassword record.
 */

public record PersonDtoWithoutPassword(Long id, String username, Role role) {
  /**
   * Create a Dto without password.
   */
  public static PersonDtoWithoutPassword fromEntity(Person person) {
    return new PersonDtoWithoutPassword(
      person.getId(),
      person.getUsername(),
      person.getRole()
    );
  }
}

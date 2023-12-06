package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.farm.entity.Farm;

/**
 * Record FarmDto.
 */
public record FarmDto(
    Long id,
    String name,
    Double size
) {

  /**
   * Transform a Farm into a FarmDto.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
      farm.getId(),
      farm.getName(),
      farm.getSize()
    );
  }

  /**
   * Transform a FarmDto into a Farm.
   * 
  */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}

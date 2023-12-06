package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.farm.entity.Fertilizer;

/**
 * Record for Fertilzer.
 */
public record FertilizerDto(
    Long id,
    String name,
    String brand,
    String composition) {
  
  
  /**
   * Transform a Feritilizers into a FertilizersDto.
  */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
      fertilizer.getId(),
      fertilizer.getName(),
      fertilizer.getBrand(),
      fertilizer.getComposition()
    );
  }

  /**
   * Transform a FertilizersDto into a Fertilizers.
   * 
  */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}

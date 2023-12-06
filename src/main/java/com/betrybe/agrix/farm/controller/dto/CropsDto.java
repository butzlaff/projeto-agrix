package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.farm.entity.Crops;
import java.time.LocalDate;

/**
 * Record CropsDto.
 */
public record CropsDto(Long id, String name, Double plantedArea, Long farmId, 
    LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Transform a Crops into a CropsDto.
   */
  public static CropsDto fromEntity(Crops crops) {
    return new CropsDto(
      crops.getId(),
      crops.getName(),
      crops.getPlantedArea(),
      crops.getFarm().getId(),
      crops.getPlantedDate(),
      crops.getHarvestDate()
    );
  }

  /**
   * Transform a CropsDto into a Crops.
   * 
  */
  public Crops toEntity() {
    Crops crops = new Crops();
    crops.setName(name);
    crops.setPlantedArea(plantedArea);
    crops.setHarvestDate(harvestDate);
    crops.setPlantedDate(plantedDate);
    return crops;
  }
}
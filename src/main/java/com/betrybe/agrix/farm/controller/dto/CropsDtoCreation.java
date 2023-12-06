package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.farm.entity.Crops;
import java.time.LocalDate;

/**
 * Crops Dto to creation.
 */
public record CropsDtoCreation(String name, Double plantedArea, 
    LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Generates an instance of the Crops entity without the associated Farm.
   *
   * @return          an instance of the Crops entity without the associated Farm.
   */
  public Crops toEntityWithoutFarm() {
    Crops crops = new Crops();
    crops.setName(name);
    crops.setPlantedArea(plantedArea);
    crops.setPlantedDate(plantedDate);
    crops.setHarvestDate(harvestDate);
    return crops;
  }
} 
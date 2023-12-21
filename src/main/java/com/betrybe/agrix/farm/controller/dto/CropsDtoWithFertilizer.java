package com.betrybe.agrix.farm.controller.dto;

import com.betrybe.agrix.farm.entity.Crops;
import com.betrybe.agrix.farm.entity.Fertilizer;
import java.time.LocalDate;
import java.util.List;

/**
 * Record CropsDtoWithFertilizer.
 */
public record CropsDtoWithFertilizer(Long id, String name, Double plantedArea, Long farmId, 
    LocalDate plantedDate, LocalDate harvestDate, List<FertilizerDto> fertilizer) {
  
  /**
   * Transform a Crops into a CropsDto with fertilizer.
   */
  public static CropsDtoWithFertilizer fromEntity(Crops crops) {
    return new CropsDtoWithFertilizer(
      crops.getId(),
      crops.getName(),
      crops.getPlantedArea(),
      crops.getFarm().getId(),
      crops.getPlantedDate(),
      crops.getHarvestDate(),
      crops.getFertilizers().stream().map(FertilizerDto::fromEntity).toList()
    );
  }
}

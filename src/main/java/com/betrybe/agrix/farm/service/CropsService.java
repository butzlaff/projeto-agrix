package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.entity.Crops;
import com.betrybe.agrix.farm.entity.Farm;
import com.betrybe.agrix.farm.entity.Fertilizer;
import com.betrybe.agrix.farm.repository.CropsRepository;
import com.betrybe.agrix.farm.service.exceptions.CropsNotFoundException;
import com.betrybe.agrix.farm.service.exceptions.FarmNotFoundException;
import com.betrybe.agrix.farm.service.exceptions.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Crops.
 */
@Service
public class CropsService {
  private final CropsRepository cropsRepository;
  private final FertilizerService fertilizerService;
  private final FarmService farmService;

  /**
   * Constructor.
   */
  @Autowired
  public CropsService(CropsRepository cropsRepository, 
      FarmService farmService, FertilizerService fertilizerService) {
    this.cropsRepository = cropsRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  public Crops create(Crops crops) {
    return cropsRepository.save(crops);
  }

  /**
   * Creates a new crops object for a given farm.
   *
   * @param  crops   the crops object to be created.
   * @param  farmId  the ID of the farm.
   * @return         the created crops object.
   * @throws FarmNotFoundException  if the farm with the given ID is not found.
   */
  public Crops createCrops(Crops crops, Long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    crops.setFarm(farm);
    return create(crops);
  }

  public Crops findCrops(Long id) throws CropsNotFoundException {
    return cropsRepository.findById(id)
      .orElseThrow(CropsNotFoundException::new);
  }

  public List<Crops> findAll() {
    return cropsRepository.findAll();
  }

  public List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end) {
    return cropsRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Associates a Fertilizer to a Crops.
   */
  public Crops associateFertilizer(Long id, Long fertilizerId)
      throws CropsNotFoundException, FertilizerNotFoundException {
    Crops crops = findCrops(id);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    crops.getFertilizers().add(fertilizer);
    return cropsRepository.save(crops);
  }
}

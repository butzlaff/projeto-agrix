package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.entity.Fertilizer;
import com.betrybe.agrix.farm.repository.FertilizerRepository;
import com.betrybe.agrix.farm.service.exceptions.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Fertilizar.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Save a fertilizer.
   */
  public Fertilizer saveFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  /**
   * Find a fertilizer by id.
   */
  public Fertilizer findById(Long id) throws FertilizerNotFoundException {
    return fertilizerRepository.findById(id).orElseThrow(FertilizerNotFoundException::new);
  }
  
  /**
   * Find and returns a list of all Fertiliziers.
   */
  public List<Fertilizer> findAllFertilizers() {
    return fertilizerRepository.findAll();
  }
}

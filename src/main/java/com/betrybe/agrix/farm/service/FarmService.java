package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.entity.Farm;
import com.betrybe.agrix.farm.repository.FarmRepository;
import com.betrybe.agrix.farm.service.exceptions.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Farm.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Get farm by id.
   */
  public Farm findById(long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
      .orElseThrow(FarmNotFoundException::new);
  }

  public List<Farm> findAll() {
    List<Farm> farm = farmRepository.findAll();
    return farm;
  }

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }
}

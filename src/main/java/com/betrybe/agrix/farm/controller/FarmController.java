package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.controller.dto.CropsDto;
import com.betrybe.agrix.farm.controller.dto.FarmDto;
import com.betrybe.agrix.farm.entity.Crops;
import com.betrybe.agrix.farm.entity.Farm;
import com.betrybe.agrix.farm.service.CropsService;
import com.betrybe.agrix.farm.service.FarmService;
import com.betrybe.agrix.farm.service.exceptions.CropsNotFoundException;
import com.betrybe.agrix.farm.service.exceptions.FarmNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for /farms.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;
  private final CropsService cropsService;

  @Autowired
  public FarmController(FarmService farmService, CropsService cropsService) {
    this.farmService = farmService;
    this.cropsService = cropsService;
  }

  /*
   * Create a Farm.
   */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.create(farmDto.toEntity());
    return farm;
  }

  /**
   * Get all farms.
   */
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Farm> findAll() {
    List<Farm> farms = new ArrayList<>();
    farms = farmService.findAll();
    return farms;
  }

  /**
   * Get farm by id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Farm findById(@PathVariable("id") long id) throws FarmNotFoundException {
    Farm farms = farmService.findById(id);
    return farms;
  }

  /**
   * Create a Crops into Farm.
   */
  @PostMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropsDto createCrops(@RequestBody CropsDto crops, @PathVariable("id") long id)
      throws FarmNotFoundException {
    Crops cropsCreated = cropsService.createCrops(crops.toEntity(), id);
    System.out.printf("Crops created: %s", crops);
    return CropsDto.fromEntity(cropsCreated);
  }

  /**
   * Gett all crops from Farm.
   */
  @GetMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropsDto> createCrops(@PathVariable("id") long id)
      throws FarmNotFoundException, CropsNotFoundException {
    Farm farm = farmService.findById(id);
    List<Crops> crops = farm.getCrops();
    return crops.stream().map(CropsDto::fromEntity).toList();
  }
}

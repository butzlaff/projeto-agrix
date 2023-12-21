package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.controller.dto.FertilizerDto;
import com.betrybe.agrix.farm.entity.Fertilizer;
import com.betrybe.agrix.farm.service.FertilizerService;
import com.betrybe.agrix.farm.service.exceptions.FertilizerNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for Fertilizer.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto saveFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer entity = this.fertilizerService.saveFertilizer(fertilizerDto.toEntity());
    return FertilizerDto.fromEntity(entity);
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto findById(@PathVariable Long id) throws FertilizerNotFoundException {
    Fertilizer entity = this.fertilizerService.findById(id);
    return FertilizerDto.fromEntity(entity);
  }

  /**
   * Get all Fertilizers.
   */
  @GetMapping()
  @Secured("ROLE_ADMIN")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> findAll() {
    return this.fertilizerService.findAllFertilizers().stream()
      .map(FertilizerDto::fromEntity)
      .toList();
  }
}

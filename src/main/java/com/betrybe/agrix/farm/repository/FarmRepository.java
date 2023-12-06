package com.betrybe.agrix.farm.repository;

import com.betrybe.agrix.farm.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface Respository for Farms.
 */
public interface FarmRepository extends JpaRepository<Farm, Long> {
  
}

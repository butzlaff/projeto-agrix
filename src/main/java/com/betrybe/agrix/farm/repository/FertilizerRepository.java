package com.betrybe.agrix.farm.repository;

import com.betrybe.agrix.farm.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface Repository for Fertilizer.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
  
}

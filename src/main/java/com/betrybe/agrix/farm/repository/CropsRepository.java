package com.betrybe.agrix.farm.repository;

import com.betrybe.agrix.farm.entity.Crops;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Crops.
 */
@Repository
public interface CropsRepository extends JpaRepository<Crops, Long> {
  List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end);
}

package com.betrybe.agrix.farm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Crops Entity.
 */
@Entity
@Table(name = "crops")
public class Crops {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String name;
  private Double plantedArea;
  private LocalDate plantedDate;
  private LocalDate harvestDate;
  
  /**
   * Construtor vazio.
   */
  public Crops() { }

  /**
   * Construtor do Crops.
   */
  public Crops(Long id, String name, Double plantedArea, 
      Farm farm, LocalDate plantedDate, LocalDate harvestDate) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  @ManyToMany
  @JoinTable(
      name = "crops_fertilizer", 
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crop_id")
  )
  List<Fertilizer> fertilizers;

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return this.harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }
}
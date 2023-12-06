package com.betrybe.agrix.farm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Fertilizers Entity.
 */
@Entity
@Table(name = "fertilizers")
public class Fertilizer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String brand;
  private String composition;

  /**
   * Construtor vazio.
  */
  public Fertilizer() {
  }
  
  /**
   * Construtor Fertilizers.
   */
  public Fertilizer(Long id, String name, String brand, String composition) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
  }

  @ManyToMany(mappedBy = "fertilizers")
  List<Crops> crops;

  /**
   * Getters and setters.
   */

  public List<Crops> getCrops() {
    return crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return this.composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }
}

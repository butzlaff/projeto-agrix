package com.betrybe.agrix.farm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Farm Entity.
 */
@Entity
@Table(name = "farms")
public class Farm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double size;
  
  /**
   * Constructor vazio.
   */
  public Farm() {}

  /**
   * Constructor do Farm.
   */
  public Farm(Long id, String name, Double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  @JsonIgnore
  @OneToMany(mappedBy = "farm")
  private List<Crops> crops;
  
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

  public Double getSize() {
    return this.size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public List<Crops> getCrops() {
    return this.crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
  }
}

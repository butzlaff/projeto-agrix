package com.betrybe.agrix.farm.service.exceptions;

/**
 * Throws exception when Fertilizer is not found.
 */
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}

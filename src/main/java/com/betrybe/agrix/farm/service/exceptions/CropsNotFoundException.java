package com.betrybe.agrix.farm.service.exceptions;

/**
 * Throws exception when farm is not found.
 */
public class CropsNotFoundException extends NotFoundException {
  public CropsNotFoundException() {
    super("Plantação não encontrada!");
  }
}
  

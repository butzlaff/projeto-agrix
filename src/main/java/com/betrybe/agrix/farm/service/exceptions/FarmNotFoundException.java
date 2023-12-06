package com.betrybe.agrix.farm.service.exceptions;

/**
 * Throws exception when farm is not found.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}

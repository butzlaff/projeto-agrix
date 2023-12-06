package com.betrybe.agrix.farm.service.exceptions;

/**
 * Throws exception when farm is not found.
 */
public abstract class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}

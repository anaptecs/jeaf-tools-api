/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.performance;

/**
 * Static enum defining the supported precisions of a stop watch
 */
public enum TimePrecision {
  /**
   * Literal for time precision nanoseconds.
   */
  NANOS(1000L * 1000 * 1000, 1, "ns"),

  /**
   * Literal for time precision milliseconds.
   */
  MILLIS(1000, 1000L * 1000, "ms");

  /**
   * Factor that is needed to calculate the transactions per second based on this unit.
   */
  private final long tpsFactor;

  /**
   * Divisor that is needed to convert a measurement that is done in nanoseconds into this precision.
   */
  private final long durationDivisor;

  /**
   * String representation of the unit of this time precision.
   */
  private final String unit;

  /**
   * Initialize object.
   */
  private TimePrecision( long pTPSFactor, long pDurationDivisor, String pUnit ) {
    tpsFactor = pTPSFactor;
    durationDivisor = pDurationDivisor;
    unit = pUnit;
  }

  /**
   * Method returns the factor that is needed to calculate the transactions per second based on this unit.
   * 
   * @return long Factor to calculate transactions per second.
   */
  public long getTPSFactor( ) {
    return tpsFactor;
  }

  /**
   * Method returns the divisor that is needed to convert a measurement that is done in nanoseconds into this precision.
   * 
   * @return Divisor.
   */
  public long getDurationDivisor( ) {
    return durationDivisor;
  }

  /**
   * Method returns a string representation of the time precision.
   * 
   * @return String Unit as string. The method never returns null.
   */
  public String getUnit( ) {
    return unit;
  }
}
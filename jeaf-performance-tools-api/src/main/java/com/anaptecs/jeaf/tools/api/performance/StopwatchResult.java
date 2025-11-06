/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.performance;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class represents the result of a stop watch run.
 * 
 * @author JEAF Development Team
 */
public class StopwatchResult {
  /**
   * Duration of the measurement. The unit of the duration is defined by attribute {@link #unit}.
   */
  private final long duration;

  /**
   * Attribute describes the time precision of the measurement and thus also the unit of the {@link #duration}.
   */
  private final TimePrecision unit;

  /**
   * Attribute contains the amount of transactions that were executed during the stopwatch was active. If the
   * information is not available then attribute may be 0.
   */
  private final long transactions;

  /**
   * Attribute describes the transactions per second that were processed during the measurement. The attribute may be
   * null in case that the stop watch did not know the amount of runs during the measurement.
   */
  private final Double tps;

  /**
   * Initialize object
   * 
   * @param pDuration Duration of the measurement.
   * @param pUnit Time precision (unit) of the measurement. The parameter must not be null.
   * @param pTPS Transactions per second that were processed.
   */
  public StopwatchResult( long pDuration, TimePrecision pUnit, long pTransactions ) {
    // Check parameters.
    Check.checkInvalidParameterNull(pUnit, "pUnit");

    duration = pDuration;
    unit = pUnit;
    transactions = pTransactions;
    if (pTransactions > 0) {
      tps = (((double) pTransactions) / duration) * unit.getTPSFactor();
    }
    else {
      tps = 0.0;
    }
  }

  /**
   * Method returns the Duration of the measurement. The unit of the duration is defined by attribute {@link #unit}.
   * 
   * @return long Duration of the stop watch run.
   */
  public long getDuration( ) {
    return duration;
  }

  /**
   * Method returns the time precision of the measurement and thus also the unit of the {@link #duration}.
   * 
   * @return {@link TimePrecision} Time precision of the measurement. The method never returns null.
   */
  public TimePrecision getUnit( ) {
    return unit;
  }

  /**
   * Method returns the number of transactions that were executed during the time when a stopwatch was active.
   * 
   * @return long Number of transactions.
   */
  public long getTransactions( ) {
    return transactions;
  }

  /**
   * Method returns the transactions per second that were processed during the measurement.
   * 
   * @return {@link Double} Transactions per second. The method may return null in case that the stop watch did not know
   * the amount of runs during the measurement.
   */
  public Double getTransactionsPerSecond( ) {
    return tps;
  }

}

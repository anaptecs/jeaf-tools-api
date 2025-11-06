/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import java.util.concurrent.TimeUnit;

/**
 * Interface represents the current status of a timer.
 * 
 * @author JEAF Development Team
 */
public interface TimerInfo extends MeterInfo {
  /**
   * Method returns the amount of samples that were recorder for the timer.
   * 
   * @return long Number of recorded samples of the counter.
   */
  long getCount( );

  /**
   * Method returns the total time of all recorded samples. Method uses the default time unit
   * {@link MonitoringTools#getDefaultTimeUnit()}.
   * 
   * @return double The total time of recorded samples using the default time unit.
   */
  double getTotalTime( );

  /**
   * Method returns the total time of all recorded samples.
   * 
   * @param pTimeUnit The base unit of time to scale the total to. The parameter must not be null.
   * @return double The total time of recorded samples using the passed time unit.
   */
  double getTotalTime( TimeUnit pTimeUnit );

  /**
   * Method returns the average time calculated over all recorded samples. Method uses the default time unit
   * {@link MonitoringTools#getDefaultTimeUnit()}.
   * 
   * @return double Average time of all recorded samples using the passed time unit.
   */
  double getMean( );

  /**
   * Method returns the average time calculated over all recorded samples.
   * 
   * @param pTimeUnit The base unit of time to scale the average to. The parameter must not be null.
   * @return double Average time of all recorded samples using the passed time unit.
   */
  double getMean( TimeUnit pTimeUnit );

  /**
   * Method returns the maximum time of all recorded samples. Method uses the default time unit
   * {@link MonitoringTools#getDefaultTimeUnit()}.
   * 
   * @return double Maximum time of all recorded samples using the default time unit.
   */
  double getMax( );

  /**
   * Method returns the maximum time of all recorded samples.
   * 
   * @param pTimeUnit The base unit of time to scale the total to. The parameter must not be null.
   * @return double Maximum time of all recorded samples using the passed time unit.
   */
  double getMax( TimeUnit pTimeUnit );

}

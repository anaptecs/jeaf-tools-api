/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

/**
 * Interface represents the status of a gauge.
 * 
 * @author JEAF Development Team
 */
public interface GaugeInfo extends MeterInfo {
  /**
   * Method returns the current value of the gauge.
   * 
   * @return double Current value of the gauge.
   */
  double getValue( );
}

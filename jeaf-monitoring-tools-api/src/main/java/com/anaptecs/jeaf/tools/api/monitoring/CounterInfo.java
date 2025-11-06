/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

/**
 * Interface represents the status of counter.
 * 
 * @author JEAF Development Team
 */
public interface CounterInfo extends MeterInfo {
  /**
   * Method returns the current count of the counter.
   * 
   * @return int Current value of the counter.
   */
  int getCount( );
}

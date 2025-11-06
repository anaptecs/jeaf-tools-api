/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

/**
 * Enumeration defines the supported growth strategies for pools.
 */
public enum PoolGrowthStrategy {
  /**
   * If required then the size of the pool will be increased by a fixed size as defined in the pool configuration.
   * 
   * {@link PoolConfiguration#getIncrementSize()}
   */
  FIXED_SIZE_GROWTH,

  /**
   * If required size of the pool will be increased by a fixed percentage of its current size. Percentage is defined in
   * the pool configuration.
   * 
   * {@link PoolConfiguration#getIncrementPercentage()}
   */
  PERCENTAGED_GROWTH
}

/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.pooling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.tools.api.pooling.PoolConfiguration;
import com.anaptecs.jeaf.tools.api.pooling.PoolConfiguration.Builder;
import com.anaptecs.jeaf.tools.api.pooling.PoolGrowthStrategy;

public class PoolConfigurationTest {
  @Test
  void testCustomPoolConfiguration( ) {
    Builder lBuilder = PoolConfiguration.Builder.newBuilder();
    lBuilder.setMaxPoolSize(42);
    lBuilder.setInitialPoolSize(7);
    lBuilder.setPoolGrowthStrategy(PoolGrowthStrategy.PERCENTAGED_GROWTH);
    lBuilder.setIncrementSize(2);
    lBuilder.setIncrementPercentage(20);
    lBuilder.setAcquireTimeout(666);
    lBuilder.setObjectTTL(123456);
    PoolConfiguration lPoolConfiguration = lBuilder.build();
    assertEquals(PoolGrowthStrategy.PERCENTAGED_GROWTH, lPoolConfiguration.getPoolGrowthStrategy());
    assertEquals(42, lPoolConfiguration.getMaxPoolSize());
    assertEquals(7, lPoolConfiguration.getInitialPoolSize());
    assertEquals(2, lPoolConfiguration.getIncrementSize());
    assertEquals(20, lPoolConfiguration.getIncrementPercentage());
    assertEquals(666, lPoolConfiguration.getAcquireTimeout());
    assertEquals(123456, lPoolConfiguration.getObjectTTL());
  }

  @Test
  void testDefaultPoolConfiguration( ) {
    Builder lBuilder = PoolConfiguration.Builder.newBuilder();
    PoolConfiguration lPoolConfiguration = lBuilder.build();
    assertEquals(PoolConfiguration.DEFAULT_POOL_GROWTH_STRATEGY, lPoolConfiguration.getPoolGrowthStrategy());
    assertEquals(PoolConfiguration.DEFAULT_MAX_POOL_SIZE, lPoolConfiguration.getMaxPoolSize());
    assertEquals(PoolConfiguration.DEFAULT_INITIAL_POOL_SIZE, lPoolConfiguration.getInitialPoolSize());
    assertEquals(PoolConfiguration.DEFAULT_INCREMENT_SIZE, lPoolConfiguration.getIncrementSize());
    assertEquals(PoolConfiguration.DEFAULT_INCREMENT_PERCENTAGE, lPoolConfiguration.getIncrementPercentage());
    assertEquals(PoolConfiguration.DEFAULT_ACQUIRE_TIMEOUT, lPoolConfiguration.getAcquireTimeout());
    assertEquals(PoolConfiguration.DEFAULT_OBJECT_TTL, lPoolConfiguration.getObjectTTL());
  }
}

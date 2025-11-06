/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

public final class PoolConfiguration {
  /**
   * Default pool growth strategy {@link PoolGrowthStrategy#FIXED_SIZE_GROWTH} will be used if nothing else is defined.
   */
  public static final PoolGrowthStrategy DEFAULT_POOL_GROWTH_STRATEGY = PoolGrowthStrategy.FIXED_SIZE_GROWTH;

  /**
   * Default maximum pool size.
   */
  public static final int DEFAULT_MAX_POOL_SIZE = 100;

  /**
   * Default initial pool size.
   */
  public static final int DEFAULT_INITIAL_POOL_SIZE = 20;

  /**
   * Default pool increment size.
   */
  public static final int DEFAULT_INCREMENT_SIZE = 10;

  /**
   * Default pool increment percentage.
   */
  public static final int DEFAULT_INCREMENT_PERCENTAGE = 0;

  /**
   * Default acquire timeout.
   */
  public static final int DEFAULT_ACQUIRE_TIMEOUT = 50;

  /**
   * Default object time-to-live.
   */
  public static final int DEFAULT_OBJECT_TTL = 10 * 60;

  /**
   * Strategy that is used in case that the size of the pool needs to be increased.
   */
  private final PoolGrowthStrategy poolGrowthStrategy;

  /**
   * Maximum size of the pool. As the pool can grow dynamically the maximum size will only be reached if neccessary.
   */
  private final int maxPoolSize;

  /**
   * Initial size of the pool. The size might be increased depending on the amount of objects that will be requested
   * from the pool.
   */
  private final int initialPoolSize;

  /**
   * Absolute increment size of the pool in case that {@link PoolGrowthStrategy#FIXED_SIZE_GROWTH} is used.
   */
  private final int incrementSize;

  /**
   * Increment size of the pool in percent. Value of 20 means 20% growth of the current pool size.
   * 
   * @see PoolGrowthStrategy#PERCENTAGED_GROWTH
   */
  private final int incrementPercentage;

  /**
   * Timeout defines the maximum time in milliseconds that will be waited until an object is acquired from the pool.
   */
  private final int acquireTimeout;

  /**
   * Time-to-live for pooled objects in seconds. Depending on the pool, implementation this time is not mandatory a hard
   * timeout but might only be interpreted as approximate time.
   */
  private final int objectTTL;

  public static class Builder {

    /**
     * Strategy that is used in case that the size of the pool needs to be increased.
     */
    private PoolGrowthStrategy poolGrowthStrategy = DEFAULT_POOL_GROWTH_STRATEGY;

    /**
     * Maximum size of the pool. As the pool can grow dynamically the maximum size will only be reached if neccessary.
     */
    private int maxPoolSize = DEFAULT_MAX_POOL_SIZE;

    /**
     * Initial size of the pool. The size might be increased depending on the amount of objects that will be requested
     * from the pool.
     */
    private int initialPoolSize = DEFAULT_INITIAL_POOL_SIZE;

    /**
     * Absolute increment size of the pool in case that {@link PoolGrowthStrategy#FIXED_SIZE_GROWTH} is used.
     */
    private int incrementSize = DEFAULT_INCREMENT_SIZE;

    /**
     * Increment size of the pool in percent. Value of 20 means 20% growth of the current pool size.
     * 
     * @see PoolGrowthStrategy#PERCENTAGED_GROWTH
     */
    private int incrementPercentage = DEFAULT_INCREMENT_PERCENTAGE;

    /**
     * Timeout defines the maximum time in milliseconds that will be waited until an object is acquired from the pool.
     */
    private int acquireTimeout = DEFAULT_ACQUIRE_TIMEOUT;

    /**
     * Time-to-live for pooled objects in seconds. Depending on the pool, implementation this time is not mandatory a
     * hard timeout but might only be interpreted as approximate time.
     */
    private int objectTTL = DEFAULT_OBJECT_TTL;

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    public Builder setPoolGrowthStrategy( PoolGrowthStrategy pPoolGrowthStrategy ) {
      poolGrowthStrategy = pPoolGrowthStrategy;
      return this;
    }

    public Builder setMaxPoolSize( int pMaxPoolSize ) {
      maxPoolSize = pMaxPoolSize;
      return this;
    }

    public Builder setInitialPoolSize( int pInitialPoolSize ) {
      initialPoolSize = pInitialPoolSize;
      return this;
    }

    public Builder setIncrementSize( int pIncrementSize ) {
      incrementSize = pIncrementSize;
      return this;
    }

    public Builder setIncrementPercentage( int pIncrementPercentage ) {
      incrementPercentage = pIncrementPercentage;
      return this;
    }

    public Builder setAcquireTimeout( int pAcquireTimeout ) {
      acquireTimeout = pAcquireTimeout;
      return this;
    }

    public Builder setObjectTTL( int pObjectTTL ) {
      objectTTL = pObjectTTL;
      return this;
    }

    /**
     * Method create a new {@link PoolConfiguration} based on this builder.
     * 
     * @return {@link PoolConfiguration} Created pool configuration. The method never returns null.
     */
    public PoolConfiguration build( ) {
      return new PoolConfiguration(this);
    }

  }

  private PoolConfiguration( Builder pBuilder ) {
    poolGrowthStrategy = pBuilder.poolGrowthStrategy;
    maxPoolSize = pBuilder.maxPoolSize;
    initialPoolSize = pBuilder.initialPoolSize;
    incrementSize = pBuilder.incrementSize;
    incrementPercentage = pBuilder.incrementPercentage;
    acquireTimeout = pBuilder.acquireTimeout;
    objectTTL = pBuilder.objectTTL;
  }

  public PoolGrowthStrategy getPoolGrowthStrategy( ) {
    return poolGrowthStrategy;
  }

  public int getMaxPoolSize( ) {
    return maxPoolSize;
  }

  public int getInitialPoolSize( ) {
    return initialPoolSize;
  }

  public int getIncrementSize( ) {
    return incrementSize;
  }

  public double getIncrementPercentage( ) {
    return incrementPercentage;
  }

  public int getAcquireTimeout( ) {
    return acquireTimeout;
  }

  public int getObjectTTL( ) {
    return objectTTL;
  }
}

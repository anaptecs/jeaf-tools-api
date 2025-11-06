/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

/**
 * This interface defines a wrapper for objects that are acquired from a pool.
 * 
 * Please be aware that objects that are acquired from the pool explicitly need to be returned to it using
 * {@link #release()} or {@link PoolingTools#releasePooledObject(PooledObject)}. After an object was returned to a pool it
 * must not be used any longer no matter what happens
 * 
 * @author JEAF Development Team
 */
public interface PooledObject<T> {
  /**
   * Method returns the actual pooled object.
   * 
   * @return
   */
  T getPooledObject( );

  /**
   * All objects that were acquired from a pool must be returned explicitly as soon as they are not needed any more.
   * Therefore you can either use this method or {@link PoolingTools#releasePooledObject(PooledObject)}
   * 
   * As soon an a pooled object is returned to a pool it must not be used any longer from the application code.
   */
  default void release( ) {
    PoolingTools.getPoolingTools().releasePooledObject(this);
  }
}

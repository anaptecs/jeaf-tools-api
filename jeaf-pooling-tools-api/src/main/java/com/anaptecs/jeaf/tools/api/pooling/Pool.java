/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class represents an object pool. However it is not the actual pool but only its public representation. If you want to
 * acquire a new object from a pool then you have to tell from which pool. And this is what this object is used for.
 * 
 * @author JEAF Development Team
 *
 * @see PoolingTools#createPool(String, PooledObjectLifecycleManager, PoolConfiguration)
 * @see PoolingTools#acquirePooledObject(Pool)
 */
public final class Pool<T> {
  /**
   * ID of the pool. It is ensured that each pool that was created using {@link PoolingTools} has a unique ID.
   */
  private final int poolID;

  /**
   * Name of the pool. The name is never null. However it is not guaranteed that the name of a pool is unique.
   */
  private final String poolName;

  /**
   * Initialize object.
   * 
   * @param pPoolID ID of the pool.
   * @param pPoolName Name of the pool. The parameter must not be null.
   */
  public Pool( int pPoolID, String pPoolName ) {
    // Check parameters
    Check.checkInvalidParameterNull(pPoolName, "pPoolName");

    poolName = pPoolName;
    poolID = pPoolID;
  }

  /**
   * Method returns the ID of the pool. It is ensured that each pool that was created using {@link PoolingTools} has a
   * unique ID.
   * 
   * @return int ID of the pool.
   */
  public int getPoolID( ) {
    return poolID;
  }

  /**
   * Method returns the name of the pool as it was defined when the pool was created.
   * 
   * @return {@link String} Name of the pool. The method never returns null.
   */
  public String getPoolName( ) {
    return poolName;
  }

  /**
   * Method returns an object from the pool.
   * 
   * Please be aware that the object has explicitly returned to the pool again as soon as it it not needed any longer
   * using {@link PooledObject#release()} or {@link PoolingTools#releasePooledObject(PooledObject)}.
   * 
   * 
   * @return {@link PooledObject} Object from the pool. The method never returns null. Method might throw a
   * {@link JEAFSystemException} in case that within the configured timeout of the pool no object could be acquired.
   */
  public PooledObject<T> acquirePooledObject( ) {
    return PoolingTools.getPoolingTools().acquirePooledObject(this);
  }
}

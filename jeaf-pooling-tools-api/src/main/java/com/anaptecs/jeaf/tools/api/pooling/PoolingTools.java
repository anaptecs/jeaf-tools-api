/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines the tools for pooling of objects. <br/>
 * <br/>
 * <b>Important: </b> Most important things to take care about when working with objects pools is that you ensure that
 * objects are returned to the pool again under all circumstances.
 * 
 * @author JEAF Development Team
 *
 */
public interface PoolingTools {
  /**
   * Configured implementation of pooling tools.
   */
  static final PoolingTools POOLING_TOOLS = ToolsLoader.getTools(PoolingTools.class);

  /**
   * Method returns the configured implementation of the pooling tools.
   * 
   * @return PoolingTools Configured implementation of pooling tools. The method never returns null.
   */
  static PoolingTools getPoolingTools( ) {
    return POOLING_TOOLS;
  }

  /**
   * Method creates a new object pool.
   * 
   * @param pPoolName Name of the pool that should be created. It's recommended but not required to use unique names per
   * pool. The parameter must not be null.
   * @param pLifecycleManager Lifecycle manager for the created pool. The lifecycle manager is used to create and reset
   * pooled objects.The parameter must not be null.
   * @param pConfiguration Pool configuration that should be used. The parameter must not be null.
   * @return {@link Pool} Object representing the created pool. This object is needed when you want to acquire objects
   * from the pool. The method never returns null.
   */
  <T> Pool<T> createPool( String pPoolName, PooledObjectLifecycleManager<T> pLifecycleManager,
      PoolConfiguration pConfiguration );

  /**
   * Method returns an object from the pool.
   * 
   * Please be aware that the object has explicitly returned to the pool again as soon as it it not needed any longer
   * using {@link PooledObject#release()} or {@link PoolingTools#releasePooledObject(PooledObject)}.
   * 
   * 
   * @param pPool Pool from which the object should be taken. The parameter must not be null.
   * @return {@link PooledObject} Object from the pool. The method never returns null. Method might throw a
   * {@link JEAFSystemException} in case that within the configured timeout of the pool no object could be acquired.
   */
  <T> PooledObject<T> acquirePooledObject( Pool<T> pPool );

  /**
   * Method is intended to be called to return a pooled object back again to the pool. After an object was returned to
   * the pool it must not be used any longer but the application code.
   * 
   * @param pPooledObject Object that should be returned to the pool. The parameter must not be null.
   */
  <T> void releasePooledObject( PooledObject<T> pPooledObject );

}

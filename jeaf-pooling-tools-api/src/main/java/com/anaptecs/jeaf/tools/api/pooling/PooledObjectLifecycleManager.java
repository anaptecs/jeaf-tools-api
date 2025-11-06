/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.pooling;

/**
 * Interface defines a lifecycle manager that is used manage pooled objects.
 * 
 * @author JEAF Development Team
 */
public interface PooledObjectLifecycleManager<T> {
  /**
   * Method is used to create a new instance of a pooled object. This method will be called when the pool of objects is
   * initially set up as well as in case the the pool size will be increased or when new objects need to be created as
   * existing ones expired.
   * 
   * @return T Created new pooled object. The method must not return null.
   */
  T createObject( );

  /**
   * Method is called when an object is returned to the pool. In this case all attributes / references etc. must be
   * unset again so that the pooled object is in it initial state again which is supposed to be the same as when it was
   * initially created.
   * 
   * @param pObjectPooled object that should be reset to its initial state. The parameter will never be null.
   */
  void resetObject( T pObject );

  /**
   * Method will be called whenever a pooled object will be removed from the pool again. This method can be used to do
   * some maybe required cleanups.
   * 
   * @param Object Object that will be removed from the pool. The parameter is never null.
   */
  void cleanup( T Object );
}

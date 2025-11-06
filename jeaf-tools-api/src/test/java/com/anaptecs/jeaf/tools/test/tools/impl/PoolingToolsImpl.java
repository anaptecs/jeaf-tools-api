/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.pooling.Pool;
import com.anaptecs.jeaf.tools.api.pooling.PoolConfiguration;
import com.anaptecs.jeaf.tools.api.pooling.PooledObject;
import com.anaptecs.jeaf.tools.api.pooling.PooledObjectLifecycleManager;
import com.anaptecs.jeaf.tools.api.pooling.PoolingTools;

@ToolsImplementation(toolsInterface = PoolingTools.class)
public class PoolingToolsImpl implements PoolingTools {
  public PooledObject<?> lastReleasedObject;

  public PooledObject<?> pooledObject;

  @Override
  public <T> Pool<T> createPool( String pPoolName, PooledObjectLifecycleManager<T> pLifecycleManager,
      PoolConfiguration pConfiguration ) {
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> PooledObject<T> acquirePooledObject( Pool<T> pPool ) {
    return (PooledObject<T>) pooledObject;
  }

  @Override
  public <T> void releasePooledObject( PooledObject<T> pPooledObject ) {
    lastReleasedObject = pPooledObject;
  }
}

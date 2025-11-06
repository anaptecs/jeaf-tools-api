/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.pooling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.tools.api.pooling.PooledObject;
import com.anaptecs.jeaf.tools.api.pooling.PoolingTools;
import com.anaptecs.jeaf.tools.test.tools.impl.PoolingToolsImpl;

public class PooledObjectTest {
  @Test
  void testPooledObject( ) {
    PooledObject<String> lPooledObject = new PooledObjectImpl<String>();
    lPooledObject.release();
    assertEquals(((PoolingToolsImpl) PoolingTools.getPoolingTools()).lastReleasedObject, lPooledObject);
  }

}

class PooledObjectImpl<T> implements PooledObject<T> {
  @Override
  public T getPooledObject( ) {
    return null;
  }
}

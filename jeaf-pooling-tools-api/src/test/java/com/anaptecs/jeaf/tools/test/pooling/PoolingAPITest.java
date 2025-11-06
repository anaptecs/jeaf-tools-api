/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.pooling;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.tools.api.pooling.Pool;
import com.anaptecs.jeaf.tools.api.pooling.PooledObject;
import com.anaptecs.jeaf.tools.api.pooling.PoolingTools;
import com.anaptecs.jeaf.tools.test.tools.impl.PoolingToolsImpl;

public class PoolingAPITest {
  @Test
  void testPoolObject( ) {
    Pool<String> lPool = new Pool<>(32, "MyStringPool");
    assertEquals(32, lPool.getPoolID());
    assertEquals("MyStringPool", lPool.getPoolName());

    PoolingToolsImpl lPoolingToolsImpl = (PoolingToolsImpl) PoolingTools.getPoolingTools();
    lPoolingToolsImpl.pooledObject = new PooledObject<String>() {

      @Override
      public String getPooledObject( ) {
        return "Hello World!";
      }
    };

    assertEquals("Hello World!", lPool.acquirePooledObject().getPooledObject());
  }

  @Test
  void testPoolingToolsAccess( ) {
    PoolingTools lPoolingTools = PoolingTools.getPoolingTools();
    assertNotNull(lPoolingTools);
  }
}

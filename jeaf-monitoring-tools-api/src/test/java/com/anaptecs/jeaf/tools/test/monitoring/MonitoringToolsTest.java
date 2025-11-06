/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.monitoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import com.anaptecs.jeaf.tools.annotations.MonitoringToolsConfig;
import com.anaptecs.jeaf.tools.api.monitoring.Tag;
import org.junit.jupiter.api.Test;

public class MonitoringToolsTest {
  @Test
  public void testDefaultValues( ) {
    assertEquals(TimeUnit.MICROSECONDS, MonitoringToolsConfig.DEFAULT_TIME_UNIT);
  }

  @Test
  public void testTag( ) {
    Tag lTag = Tag.of("key", "value");
    assertEquals("key", lTag.getKey());
    assertEquals("value", lTag.getValue());

    try {
      Tag.of("key", null);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pValue' must be a real string. NULL is not a real string.", e.getMessage());
    }

    try {
      Tag.of(null, "value");
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pKey' must be a real string. NULL is not a real string.", e.getMessage());
    }

    try {
      Tag.of("key", "     ");
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pValue' must be a real string.", e.getMessage());
    }

    try {
      Tag.of("", "value");
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pKey' must be a real string.", e.getMessage());
    }
  }
}

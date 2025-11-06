/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.tools.api.stream.BufferingMode;

public class StreamToolsTest {
  @Test
  public void testBufferingMode( ) {
    // Test
    assertEquals(0, BufferingMode.ALWAYS.ordinal());
    assertEquals("ALWAYS", BufferingMode.ALWAYS.name());
    assertEquals(1, BufferingMode.NO_BUFFERING.ordinal());
    assertEquals("NO_BUFFERING", BufferingMode.NO_BUFFERING.name());
    assertEquals(2, BufferingMode.AUTO.ordinal());
    assertEquals("AUTO", BufferingMode.AUTO.name());

    // Ensure that we are SemVer compatible
    assertEquals(3, BufferingMode.values().length);
  }
}

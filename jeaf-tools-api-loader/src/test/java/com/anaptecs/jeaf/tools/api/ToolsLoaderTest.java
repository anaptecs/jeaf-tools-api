/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.trace.TraceLevel;
import org.junit.jupiter.api.Test;

public class ToolsLoaderTest {
  @Test
  void testToolsLoader( ) {
    ToolsLoader lLoader = new ToolsLoader();
    WeirdTools lWeirdTools = lLoader.getToolsImplementation(WeirdTools.class);
    assertNotNull(lWeirdTools);
    TrashTools lTrashTools = lLoader.getToolsImplementation(TrashTools.class);
    assertNotNull(lTrashTools);

    ToolsLoaderStartupInfoWriter lInfoWriter = new ToolsLoaderStartupInfoWriter();
    lInfoWriter.traceStartupInfo(XFun.getTrace(), TraceLevel.INFO);

    assertEquals(ToolsLoader.class, lInfoWriter.getStartupCompletedEventSource());

    // Test exception handling.
    try {
      new ToolsLoader("BrokenToolsImplementationConfig");
      fail();
    }
    catch (NullPointerException e) {
      assertEquals("I'm so broken", e.getMessage());
    }

    lWeirdTools = ToolsLoader.getTools(WeirdTools.class);
    assertNotNull(lWeirdTools);
    assertEquals(WeirdToooooolsImpl.class, lWeirdTools.getClass());
    lTrashTools = ToolsLoader.getTools(TrashTools.class);
    assertNotNull(lTrashTools);
    assertEquals(TrashToolsImpl.class, lTrashTools.getClass());

    // Test null handling
    try {
      ToolsLoader.getTools(null);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pToolsInterface' must not be null.", e.getMessage());
    }

    // Test missing implementation case.
    try {
      ToolsLoader.getTools(NotAvailableTools.class);
      fail();
    }
    catch (RuntimeException e) {
      assertEquals("No implementation for tools interface com.anaptecs.jeaf.tools.api.NotAvailableTools configured.",
          e.getMessage());
    }
  }
}

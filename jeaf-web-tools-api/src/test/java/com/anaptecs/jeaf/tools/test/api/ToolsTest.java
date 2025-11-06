/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.anaptecs.jeaf.tools.api.http.WebTools;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToolsTest {
  @Test
  @Order(10)
  public void testToolsAccess( ) {
    assertNotNull(WebTools.getWebTools());
  }
}

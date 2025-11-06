/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.anaptecs.jeaf.tools.api.Tools;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToolsTest {
  @Test
  @Order(10)
  public void testToolsAccess( ) {
    assertNotNull(Tools.getCacheTools());
    assertNotNull(Tools.getCollectionTools());
    assertNotNull(Tools.getAutoBoxingTools());
    assertNotNull(Tools.getDateTools());
    assertNotNull(Tools.getEncryptionTools());
    assertNotNull(Tools.getFileTools());
    assertNotNull(Tools.getLocaleTools());
    assertNotNull(Tools.getMonitoringTools());
    assertNotNull(Tools.getNetworkingTools());
    assertNotNull(Tools.getPerformanceTools());
    assertNotNull(Tools.getReflectionTools());
    assertNotNull(Tools.getRegExpTools());
    assertNotNull(Tools.getSerializationTools());
    assertNotNull(Tools.getSSLTools());
    assertNotNull(Tools.getStringTools());
    assertNotNull(Tools.getValidationTools());
    assertNotNull(Tools.getWebTools());
    assertNotNull(Tools.getXMLTools());
    assertNotNull(Tools.getEncodingTools());
    assertNotNull(Tools.getStreamTools());
  }
}

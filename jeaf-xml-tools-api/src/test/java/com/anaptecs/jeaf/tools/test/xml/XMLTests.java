/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.anaptecs.jeaf.tools.api.xml.DocumentProperties;
import com.anaptecs.jeaf.tools.api.xml.DocumentProperties.Builder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class XMLTests {
  @Test
  @Order(10)
  public void testDocumentProperties( ) {
    // Test default
    DocumentProperties lDocumentProperties = DocumentProperties.Builder.newBuilder().build();

    assertEquals(false, lDocumentProperties.omitXMLDeclaration());
    assertEquals("1.0", lDocumentProperties.getVersion());
    assertEquals("UTF-8", lDocumentProperties.getEncoding());
    assertEquals(true, lDocumentProperties.isStandalone());
    assertNull(lDocumentProperties.getDoctypePublic());
    assertNull(lDocumentProperties.getDoctypeSystem());
    assertEquals(true, lDocumentProperties.isIndent());
    assertEquals("", lDocumentProperties.getCDataSectionElements());

    Builder lBuilder = DocumentProperties.Builder.newBuilder();
    lBuilder.omitXMLDeclaration(true);
    lBuilder.setVersion("1.1");
    lBuilder.setEncoding("ISO-8859-1");
    lBuilder.setStandalone(false);
    lBuilder.setDoctypePublic("JEAF");
    lBuilder.setDoctypeSystem("jeaf.dtd");
    lBuilder.setIndent(false);
    lBuilder.setCDataSectionElements("comments");
    lDocumentProperties = lBuilder.build();

    assertEquals(true, lDocumentProperties.omitXMLDeclaration());
    assertEquals("1.1", lDocumentProperties.getVersion());
    assertEquals("ISO-8859-1", lDocumentProperties.getEncoding());
    assertEquals(false, lDocumentProperties.isStandalone());
    assertEquals("JEAF", lDocumentProperties.getDoctypePublic());
    assertEquals("jeaf.dtd", lDocumentProperties.getDoctypeSystem());
    assertEquals(false, lDocumentProperties.isIndent());
    assertEquals("comments", lDocumentProperties.getCDataSectionElements());
  }
}

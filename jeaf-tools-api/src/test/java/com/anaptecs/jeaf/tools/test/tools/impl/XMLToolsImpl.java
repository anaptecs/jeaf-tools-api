/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.xml.DocumentProperties;
import com.anaptecs.jeaf.tools.api.xml.XMLTools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@ToolsImplementation(toolsInterface = XMLTools.class)
public class XMLToolsImpl implements XMLTools {

  @Override
  public Document createDocument( ) throws ParserConfigurationException {
    return null;
  }

  @Override
  public DocumentBuilder createDocumentBuilder( boolean pValidating ) throws ParserConfigurationException {
    return null;
  }

  @Override
  public Document parseFile( String pFileName, boolean pValidating ) throws JEAFSystemException {
    return null;
  }

  @Override
  public Document parseFile( String pFileName, boolean pValidating, String pSystemID ) throws JEAFSystemException {
    return null;
  }

  @Override
  public Document parseInputStream( InputStream pInputStream, boolean pValidating ) throws JEAFSystemException {
    return null;
  }

  @Override
  public Document parseInputStream( InputStream pInputStream, boolean pValidating, String pSystemID,
      String pStreamName )
    throws JEAFSystemException {
    return null;
  }

  @Override
  public Document parseString( String pXMLEncodedString, boolean pValidating, String pSystemID, String pStringName )
    throws JEAFSystemException {
    return null;
  }

  @Override
  public void writeDocument( Document pDocument, OutputStream pOutputStream ) {
  }

  @Override
  public void writeDocument( Document pDocument, DocumentProperties pDocumentProperties, OutputStream pOutputStream ) {
  }

  @Override
  public String toString( Document pDocument ) {
    return null;
  }

  @Override
  public String toString( Document pDocument, DocumentProperties pDocumentProperties ) {
    return null;
  }

  @Override
  public String toString( Element pElement ) {
    return null;
  }

  @Override
  public String toString( Element pElement, boolean pIndent ) {
    return null;
  }

  @Override
  public Element getSingleElement( String pElementName, Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public Element getSingleElement( String pElementName, Document pDocument, boolean pRequired ) {
    return null;
  }

  @Override
  public List<Element> getDescendantElements( String pElementName, Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public List<Element> getDescendantElements( String pElementName, Document pDocument, boolean pRequired ) {
    return null;
  }

  @Override
  public String getElementValue( Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public String getElementValueFromSubtree( String pElementName, Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public String getElementValueFromSubtree( String pElementName, Document pDocument, boolean pRequired ) {
    return null;
  }

  @Override
  public Element getFirstChildElement( String pElementName, Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public List<Element> getChildren( String pElementName, Element pElement, boolean pRequired ) {
    return null;
  }

  @Override
  public String getAttributeValue( Element pElement, String pAttributeName, boolean pRequired )
    throws JEAFSystemException {
    return null;
  }

}

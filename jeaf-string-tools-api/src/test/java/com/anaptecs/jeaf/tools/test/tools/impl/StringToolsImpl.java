/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.util.Collection;
import java.util.List;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.string.StringTools;

@ToolsImplementation(toolsInterface = StringTools.class)
public class StringToolsImpl implements StringTools {

  @Override
  public boolean isEmpty( String pString ) {
    return false;
  }

  @Override
  public boolean isRealString( String pString ) {
    return false;
  }

  @Override
  public boolean isBlank( String pString ) {
    return false;
  }

  @Override
  public boolean isNotBlank( String pString ) {
    return false;
  }

  @Override
  public boolean containsDigitsOnly( String pString ) {
    return false;
  }

  @Override
  public List<String> split( String pString, String pRegex, boolean pTrim ) {
    return null;
  }

  @Override
  public boolean endsWith( String pString, List<String> pList ) {
    return false;
  }

  @Override
  public int compareToIgnoreCase( String pString1, String pString2 ) {
    return 0;
  }

  @Override
  public int compareTo( String pString1, String pString2 ) {
    return 0;
  }

  @Override
  public String getClassNamesAsString( Collection<Class<?>> pClasses ) {
    return null;
  }

  @Override
  public String getClassNamesAsString( Collection<Class<?>> pClasses, String pEmptyText ) {
    return null;
  }

  @Override
  public String getClassNamesAsString( Collection<Class<?>> pClasses, String pEmptyText, String pDelimiter ) {
    return null;
  }

  @Override
  public String getClassNamesAsString( Class<?>[] pClasses ) {
    return null;
  }

  @Override
  public String getClassNamesAsString( Class<?>[] pClasses, String pEmptyText ) {
    return null;
  }

  @Override
  public String getClassNamesAsString( Class<?>[] pClasses, String pEmptyText, String pDelimiter ) {
    return null;
  }
}

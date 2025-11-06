/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.util.Locale;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.locale.LocaleTools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@ToolsImplementation(toolsInterface = LocaleTools.class)
public class LocaleToolsImpl implements LocaleTools {

  @Override
  public Locale createLocale( String pLocaleString ) throws JEAFSystemException {
    return null;
  }

  @Override
  public Locale getLocaleFromCountryCode( String pCountryCode ) throws JEAFSystemException {
    return null;
  }

  @Override
  public Locale getCurrentLocale( ) {
    return null;
  }

}

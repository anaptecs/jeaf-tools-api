/**
 * Copyright 2004 - 2013 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.locale;

import java.util.Locale;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines the methods that are available to make the use of Java locales as simple as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface LocaleTools {
  /**
   * Configured implementation of locale tools.
   */
  static final LocaleTools LOCALE_TOOLS = ToolsLoader.getTools(LocaleTools.class);

  /**
   * Method returns the configured implementation of the Locale Tools.
   * 
   * @return {@link LocaleTools} Configured implementation of locale tools. The method never returns null.
   */
  static LocaleTools getLocaleTools( ) {
    return LOCALE_TOOLS;
  }

  /**
   * Method converts a string representation of a locale to a real Java Locale object. The string has to have the format
   * as created by method <code>java.util.Locale.toString()</code>. Since Java does not support the validation of
   * locales this method only provides an elementary validation. According to the locale definition of the JDK a locale
   * consists of three parts, the language, the county and the variant, where a language or a country is required.
   * 
   * @param pLocaleString String that should be converted to a locale object. The parameter must not be null.
   * @return Locale Created locale object. The method never returns null.
   * @throws JEAFSystemException if the passed locale string has an invalid format or does neither define a language nor
   * a country.
   */
  Locale createLocale( String pLocaleString ) throws JEAFSystemException;

  /**
   * Method resolves a matching locale object representing the country of the passed country code. The passed code can
   * either be ISO 3166 alpha-2 or alpha-3 country code.
   * 
   * Please be aware that in multiple countries more than one language is spoken. So it is not always possible find the
   * one and only language per country. In this case the primary language of an country is chosen. Therefore data from
   * geonames.org is used.
   * 
   * @param pCountryCode Alpha-2 or alpha-3 country code that is used to identify the matching locale. The parameter
   * must not be null.
   * @return {@link Locale} Locale representing the country with the passed country code. The method never returns null.
   * @throws JEAFSystemException in case that the country code is neither a valid alpha-2 nor alpha-3 code.
   */
  Locale getLocaleFromCountryCode( String pCountryCode ) throws JEAFSystemException;

  /**
   * Method returns the current locale. How the current locale is determined depends on the environment and the used
   * locale provider implementation.
   * 
   * @return Locale Locale that is appropriate in the current context. The method never returns null.
   */
  Locale getCurrentLocale( );
}

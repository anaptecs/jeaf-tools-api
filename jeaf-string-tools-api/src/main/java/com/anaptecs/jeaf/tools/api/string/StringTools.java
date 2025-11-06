/**
 * Copyright 2004 - 2013 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.string;

import java.util.Collection;
import java.util.List;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines the methods that are available to make the use of Java strings as simple as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface StringTools {
  /**
   * Configured implementation of string tools.
   */
  static final StringTools STRING_TOOLS = ToolsLoader.getTools(StringTools.class);

  /**
   * Method returns the configured implementation of the String Tools.
   * 
   * @return {@link StringTools} Configured implementation of string tools. The method never returns null.
   */
  static StringTools getStringTools( ) {
    return STRING_TOOLS;
  }

  /**
   * <p>
   * Method checks if the passed CharSequence object is null or empty.
   * </p>
   * 
   * <pre>
   * isEmpty(null) = true
   * isEmpty("") = true
   * isEmpty(" ") = true
   * isEmpty("abc") = false
   * isEmpty(" abc ") = false
   * </pre>
   * 
   * @param pString The CharSequence object to be checked. This parameter may be null.
   * @return {@code true} if the passed CharSequence object is null or empty, false otherwise.
   * @see org.apache.commons.lang3.StringUtils
   */
  boolean isEmpty( String pString );

  /**
   * <p>
   * Method checks if the passed CharSequence object is not null or not empty.
   * </p>
   * 
   * <pre>
   * isEmpty(null) = false
   * isEmpty("") = false
   * isEmpty(" ") = false
   * isEmpty("abc") = true
   * isEmpty(" abc ") = true
   * </pre>
   * 
   * @param pString The CharSequence object to be checked. This parameter may be null.
   * @return {@code true} if the passed CharSequence object is not null or not empty, false otherwise.
   * @see org.apache.commons.lang3.StringUtils
   */
  boolean isRealString( String pString );

  /**
   * <p>
   * Method checks if the passed CharSequence object is null or empty or whitespace.
   * </p>
   * 
   * <pre>
   * isEmpty(null) = true
   * isEmpty("") = true
   * isEmpty(" ") = true
   * isEmpty("abc") = false
   * isEmpty(" abc ") = false
   * </pre>
   * 
   * @param pString The CharSequence object to be checked. This parameter may be null.
   * @return {@code true} if the passed CharSequence object is null or empty or whitespace, false otherwise.
   * @see org.apache.commons.lang3.StringUtils
   */
  boolean isBlank( String pString );

  /**
   * <p>
   * Method checks if the passed CharSequence object is not null or not empty or not whitespace.
   * </p>
   * 
   * <pre>
   * isEmpty(null) = false
   * isEmpty("") = false
   * isEmpty(" ") = false
   * isEmpty("abc") = true
   * isEmpty(" abc ") = true
   * </pre>
   * 
   * @param pString The CharSequence object to be checked. This parameter may be null.
   * @return {@code true} if the passed CharSequence object is not null or not empty or not whitespace, false otherwise.
   * @see org.apache.commons.lang3.StringUtils
   */
  boolean isNotBlank( String pString );

  /**
   * Method checks if the passed string only consists of digits. Digits only means no other characters even not decimal
   * delimiter or sign.
   * 
   * @param pString String that should be checked for digits only. The parameter must not be null.
   * @return {@link Boolean} Method returns true if the string only consists of digits.
   */
  boolean containsDigitsOnly( String pString );

  /**
   * Method splits the passed string using the passed regex using method {@link String#split(String)}. In addition its
   * also possible to trim the split strings.
   * 
   * @param pString String that should be split. The parameter may be null. In this case an empty list will be returned.
   * @param pRegex Regex that should be used to split the passed string. The parameter must not be null. Check java doc
   * of {@link String#split(String)} in order to see how the regex has to be defined.
   * @param pTrim Parameter defines if the resulting strings should be trimmed or not.
   * @return {@link List} List contain all split string in the same order as they occurred in the passed string. Method
   * never returns null.
   */
  List<String> split( String pString, String pRegex, boolean pTrim );

  /**
   * Method checks if the passed string has the same ending as one of the passed strings.
   * 
   * @param pString String that should be compared. The parameter must not be null.
   * @param pList List of string which may have the same ending as <code>pString</code> This parameter must not be null.
   * @return boolean The method returns true if at least of the passed strings from the list has the same ending as the
   * passed one and false in all other cases.
   */
  boolean endsWith( String pString, List<String> pList );

  /**
   * Method compares the passed strings ignoring cases according to the definitions of the interface {@link Comparable}.
   * 
   * @param pString1 First string that should be compared. The parameter may be null.
   * @param pString2 Second string that should be compared. The parameter may be null.
   * @return int Result of the compare. For further details see {@link Comparable#compareTo(Object)}
   */
  int compareToIgnoreCase( String pString1, String pString2 );

  /**
   * Method compares the passed strings according to the definitions of the interface {@link Comparable}.
   * 
   * @param pString1 First string that should be compared. The parameter may be null.
   * @param pString2 Second string that should be compared. The parameter may be null.
   * @return int Result of the compare. For further details see {@link Comparable#compareTo(Object)}
   */
  int compareTo( String pString1, String pString2 );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Collection with all classes. The parameter may be null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Collection<Class<?>> pClasses );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Collection with all classes. The parameter may be null.
   * @param pEmptyText String that is used in case that the passed collection is empty or null. The parameter may be
   * null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Collection<Class<?>> pClasses, String pEmptyText );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Collection with all classes. The parameter may be null.
   * @param pEmptyText String that is used in case that the passed collection is empty or null. The parameter may be
   * null.
   * @param pDelimiter Delimiter that should be used. The parameter must not be null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Collection<Class<?>> pClasses, String pEmptyText, String pDelimiter );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Array with all classes. The parameter may be null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Class<?>[] pClasses );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Array with all classes. The parameter may be null.
   * @param pEmptyText String that is used in case that the passed collection is empty or null. The parameter may be
   * null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Class<?>[] pClasses, String pEmptyText );

  /**
   * Method returns the names of all passed classes as a comma separated string.
   * 
   * @param pClasses Array with all classes. The parameter may be null.
   * @param pEmptyText String that is used in case that the passed collection is empty or null. The parameter may be
   * null.
   * @param pDelimiter Delimiter that should be used. The parameter must not be null.
   * @return {@link String} String containing a comma separated list of all class names or an empty string if
   * <code>pClasses</code> is empty or null.
   */
  String getClassNamesAsString( Class<?>[] pClasses, String pEmptyText, String pDelimiter );
}

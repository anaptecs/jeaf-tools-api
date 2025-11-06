/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements a tag. Tags can be used to qualify / categorize / group meters.
 * 
 * @author JEAF Development Team
 */
public class Tag {
  /**
   * Name of the tag.
   */
  private final String key;

  /**
   * Value of the tag.
   */
  private final String value;

  /**
   * Initialize object.
   * 
   * @param pKey Key of the tag. The parameter must be a real string.
   * @param pValue Value of the tag. The parameter must be a real string.
   */
  private Tag( String pKey, String pValue ) {
    // Check parameters
    Check.checkIsRealString(pKey, "pKey");
    Check.checkIsRealString(pValue, "pValue");

    key = pKey;
    value = pValue;
  }

  /**
   * Method creates a new tag using the passed key and value.
   * 
   * @param pKey Key of the tag. The parameter must be a real string.
   * @param pValue Value of the tag. The parameter must be a real string.
   * @return {@link Tag} Created tag. The method never returns null.
   */
  public static Tag of( String pKey, String pValue ) {
    return new Tag(pKey, pValue);
  }

  /**
   * Method returns the key of the tag.
   * 
   * @return {@link String} Key of the tag. The method always returns a real string.
   */
  public String getKey( ) {
    return key;
  }

  /**
   * Method returns the value of the tag.
   * 
   * @return {@link String} Value of the tag. The method always returns a real string.
   */
  public String getValue( ) {
    return value;
  }
}

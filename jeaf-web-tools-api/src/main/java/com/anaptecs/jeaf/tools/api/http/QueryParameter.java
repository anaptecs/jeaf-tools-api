/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.http;

import java.io.Serializable;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class represents an URL query parameter in a more typed form than supported by JDK.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3.1
 */
public class QueryParameter implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Name of the query parameter. The name is never null.
   */
  private final String name;

  /**
   * Value of the parameter. The value may be null.
   */
  private final String value;

  /**
   * Initialize object.
   * 
   * @param pName Name of the parameter represented by this object. The parameter must not be null.
   * @param pValue Value of the parameter. The parameter may be null.
   */
  public QueryParameter( String pName, String pValue ) {
    // Check parameters.
    Check.checkInvalidParameterNull(pName, "pName");

    name = pName;
    value = pValue;
  }

  /**
   * Method returns the name of the parameter.
   * 
   * @return {@link String} Name of the parameter. The method never returns null.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns the value of the parameter.
   * 
   * @return {@link String} Value of the parameter. The method may return null.
   */
  public String getValue( ) {
    return value;
  }
}

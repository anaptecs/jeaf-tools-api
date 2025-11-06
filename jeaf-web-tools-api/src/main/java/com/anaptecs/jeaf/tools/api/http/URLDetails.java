/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.http;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class simplifies usage of URL. It provides most of the method that are offered by class {@link URL} and adds
 * additional one for handling URL parameters.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3.1
 */
public class URLDetails implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Combination of host name, protocol and path
   */
  private final URL url;

  /**
   * List with all query parameters.
   */
  private final Map<String, QueryParameter> parameters;

  /**
   * Initialize object.
   * 
   * @param pURL URL as String. The parameter must not be null.
   * @throws IOException If a URL could not be created from the passed string.
   */
  public URLDetails( String pURL ) throws IOException {
    // Check parameter.
    Check.checkInvalidParameterNull(pURL, "pURL");

    url = new URL(pURL);

    // Extract parameters
    Map<String, QueryParameter> lParameters = new HashMap<>();
    String lQuery = url.getQuery();
    if (lQuery != null) {
      String[] lSplitResult = lQuery.split("\\&");
      for (String lNext : lSplitResult) {
        // Split parameter into name and value.
        String[] lParamSplit = lNext.split("=");
        String lName = lParamSplit[0];
        String lValue;

        // Parameter has a value
        if (lParamSplit.length == 2) {
          lValue = lParamSplit[1];
        }
        // Parameter does not have a value
        else {
          lValue = null;
        }
        QueryParameter lParameter = new QueryParameter(lName, lValue);
        lParameters.put(lName, lParameter);
      }
    }
    parameters = Collections.unmodifiableMap(lParameters);
  }

  /**
   * Get Java's URL representation.
   * 
   * @return {@link URL} URL representation of JDK. The method never returns null.
   */
  public URL getURL( ) {
    return url;
  }

  /**
   * Method returns a String representation of this URL.
   * 
   * @return {@link String} URL as string. The method never returns null.
   */
  public String getURLAsString( ) {
    return url.toExternalForm();
  }

  /**
   * Method returns protocol. For further details see {@link URL#getProtocol()}.
   * 
   * @return {@link String} Protocol as string. The method never returns null.
   */
  public String getProtocol( ) {
    return url.getProtocol();
  }

  /**
   * Method returns host. For further details see {@link URL#getHost()}.
   * 
   * @return {@link String} Host as string. The method never returns null.
   */
  public String getHost( ) {
    return url.getHost();
  }

  /**
   * Method returns port of the URL. If no specific port is defined in the URL the the protocol default port will be
   * used. For further details refer to {@link URL#getPort()} and {@link URL#getDefaultPort()}.
   * 
   * @return int Port of the URL.
   */
  public int getPort( ) {
    int lPort = url.getPort();
    if (lPort < 0) {
      lPort = url.getDefaultPort();
    }
    return lPort;
  }

  /**
   * Method returns the path of the URL. For further details please refer to {@link URL#getPath()}.
   * 
   * @return {@link String} Path of the URL. The method never returns null.
   */
  public String getPath( ) {
    return url.getPath();
  }

  /**
   * Method returns the query parameters as String. For further details refer to {@link URL#getQuery()}.
   * 
   * @return {@link String} String representation of all query parameters.
   */
  public String getQuery( ) {
    return url.getQuery();
  }

  /**
   * Method returns the query parameter with the passed name.
   * 
   * @param pName Name of the parameter that should be returned. The parameter must not be null.
   * @return {@link QueryParameter} Query parameter with the passed name or null of nu such parameter exists.
   */
  public QueryParameter getQueryParameter( String pName ) {
    // Check parameter.
    Check.checkInvalidParameterNull(pName, "pName");

    return parameters.get(pName);
  }

  /**
   * Method checks if the URL contains a query parameter with the passed name.
   * 
   * @param pName Name of the query parameter. The parameter must not be null.
   * @return boolean Method returns true if a query parameter with the passed name exists and otherwise false.
   */
  public boolean hasQueryParameter( String pName ) {
    // Check parameter.
    Check.checkInvalidParameterNull(pName, "pName");

    return parameters.containsKey(pName);
  }

  /**
   * Method returns all query parameters of the URL.
   * 
   * @return {@link Collections} Collection with all query parameters. The method never returns null.
   */
  public Collection<QueryParameter> getQueryParameters( ) {
    return parameters.values();
  }
}

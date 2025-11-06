/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2014 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.http;

import java.io.IOException;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines all helper methods concerning web pages.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface WebTools {
  /**
   * Configured implementation of web tools.
   */
  static final WebTools WEB_TOOLS = ToolsLoader.getTools(WebTools.class);

  /**
   * Method returns the configured implementation of the Web Tools.
   * 
   * @return {@link WebTools} Configured implementation of web tools. The method never returns null.
   */
  static WebTools getWebTools( ) {
    return WEB_TOOLS;
  }

  /**
   * Method performs a http request to gather information from the website with the passed URL.
   * 
   * @param pURL URL from which website information should be gathered. The parameter must not be null.
   * @param pTimeout Timeout in milliseconds for the request. A timeout of 0 is treated as infinite.
   * @param pFollowRedirects Parameters defines if the request should follow redirects.
   * @param pAcceptAllSSLCerts Parameter can be used to accept all kinds of SSL certificates also self-signed and
   * invalid ones. It's strongly recommended to always set this parameter to false except you really know what you are
   * doing and you really trust the requested website.
   * @return {@link WebsiteInfo} Object holding all the information about the requested website. The method never
   * returns null.
   * @throws JEAFSystemException in case the an error occurs when trying to gather the requested information.
   */
  WebsiteInfo lookupWebsiteInfo( String pURL, int pTimeout, boolean pFollowRedirects, boolean pAcceptAllSSLCerts )
    throws JEAFSystemException;

  /**
   * Method checks if the passed URL is a valid URL.
   * 
   * @param pURL URL that should be checked. The parameter may be null. Null will be treated as an invalid URL.
   * @return boolean Method returns true if the passed URL is valid. null will be treated as an invalid URL.
   */
  boolean isValidURL( String pURL );

  /**
   * Unescapes all special characters in the HTML String. The returned String is never null, but may be empty.
   * 
   * @param pInput String which contains escaped special characters.
   * @return String which does contain the special characters in ISO-8859-1 encoding.
   */
  String unescapeHtml( String pInput );

  /**
   * Method creates a http basic auth header from the passed user name and password combination.
   * 
   * @param pUser Login name of the user. The parameter may be null.
   * @param pPassword Password of the user. The parameter may be null.
   * @return {@link String} Created string can be used as http auth header field. The method never returns null.
   */
  String createBasicAuthorizationHeader( String pUser, String pPassword );

  /**
   * Method returns URL details for the passed URL.
   * 
   * @param pURL String representation of the URL. The parameter must not be null.
   * @return {@link URLDetails} Info about the passed URL. The method never returns null.
   * @throws IOException in case that the passed URL is not a valid URL.
   */
  URLDetails getURLDetails( String pURL ) throws IOException;

}
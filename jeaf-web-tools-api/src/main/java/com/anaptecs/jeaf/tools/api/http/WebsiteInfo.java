/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.http;

import java.util.Map;

/**
 * Interface define a generic set of information that can be gathered from a website.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.5.x
 */
public interface WebsiteInfo {
  /**
   * Method returns the location of the website. Due to redirects / switching from http to htpps and so on the returned
   * location may not be the same as the requested one
   * 
   * @return Location of the website. The method never returns null.
   */
  String getLocation( );

  /**
   * Method returns the title of the website. The title is taken from the HTML response of the requested URL.
   * 
   * @return String Title of the website. If the website does not hava a title then en empty string will be returned.
   */
  String getTitle( );

  /**
   * HTTP status code that was returned by the website.
   * 
   * @return {@link HTTPStatusCode} Status code that was returned when the website was accessed. The method never returns
   * null. In almost all cases this will be {@link HTTPStatusCode#OK}.
   */
  HTTPStatusCode getStatusCode( );

  /**
   * X-Frame-Options that are configured for the website.
   * 
   * @return {@link XFrameOptions} X-Frame-Options that are configured for the website. The method never returns null.
   */
  XFrameOptions getXFrameOptions( );

  /**
   * Method returns a map with all http headers that were part of the response.
   * 
   * @return {@link Map} Map with all http header. The method never returns null. The map is not modifiable.
   */
  Map<String, String> getHeaders( );

  /**
   * Method returns a map with all cookies that were part of the response.
   * 
   * @return {@link Map} Map with all cookies. The method never returns null. The map is not modifiable.
   */
  Map<String, String> getCookies( );

}

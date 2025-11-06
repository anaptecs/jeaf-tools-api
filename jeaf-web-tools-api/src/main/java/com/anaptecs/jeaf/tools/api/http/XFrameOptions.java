/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.http;

/**
 * Enumeration represents the possible values of the X-Frame-Options HTTP header field.
 * 
 * If you are interested in addition information about the http header field then please refer to
 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.5
 */
public enum XFrameOptions {
  /**
   * No restrictions about embedding.
   */
  NONE,

  /**
   * The page cannot be displayed in a frame, regardless of the site attempting to do so.
   */
  DENY,

  /**
   * The page can only be displayed in a frame on the same origin as the page itself. The spec leaves it up to browser
   * vendors to decide whether this option applies to the top level, the parent, or the whole chain.
   */
  SAMEORIGIN,

  /**
   * This is an obsolete directive that no longer works in modern browsers. Don't use it. In supporting legacy browsers,
   * a page can be displayed in a frame only on the specified origin uri.
   */
  ALLOW_FROM;

  /**
   * Method looks up the matching enum from the value of the X-Frame-Options in a http header. In case that the passed
   * String is null, empty or not one of the predefined values then {@link XFrameOptions#NONE} will be returned.
   * 
   * @param pHeaderValue That should be used to lookup its matching enumeration literal. The lookup is not case
   * sensitive.
   * @return {@link XFrameOptions} Matchin enum literal. The method never returns null.
   */
  public static XFrameOptions fromHTTPHeader( String pHeaderValue ) {
    // Header value is set.
    XFrameOptions lXFrameOption;
    if (pHeaderValue != null) {
      if (pHeaderValue.equalsIgnoreCase("deny")) {
        lXFrameOption = DENY;
      }
      else if (pHeaderValue.equalsIgnoreCase("sameorigin")) {
        lXFrameOption = SAMEORIGIN;
      }
      else if (pHeaderValue.toLowerCase().startsWith("allow-from ")) {
        lXFrameOption = ALLOW_FROM;
      }
      else {
        lXFrameOption = NONE;
      }
    }
    // X-Frame-Options are not set at all.
    else {
      lXFrameOption = NONE;
    }
    return lXFrameOption;
  }
}

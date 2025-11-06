/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.io.IOException;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.http.URLDetails;
import com.anaptecs.jeaf.tools.api.http.WebTools;
import com.anaptecs.jeaf.tools.api.http.WebsiteInfo;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@ToolsImplementation(toolsInterface = WebTools.class)
public class WebToolsImpl implements WebTools {

  @Override
  public WebsiteInfo lookupWebsiteInfo( String pURL, int pTimeout, boolean pFollowRedirects,
      boolean pAcceptAllSSLCerts )
    throws JEAFSystemException {
    return null;
  }

  @Override
  public boolean isValidURL( String pURL ) {
    return false;
  }

  @Override
  public String unescapeHtml( String pInput ) {
    return null;
  }

  @Override
  public String createBasicAuthorizationHeader( String pUser, String pPassword ) {
    return null;
  }

  @Override
  public URLDetails getURLDetails( String pURL ) throws IOException {
    return null;
  }

}

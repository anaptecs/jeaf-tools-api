/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.ssl.SSLTools;

@ToolsImplementation(toolsInterface = SSLTools.class)
public class SSLToolsImpl implements SSLTools {

  @Override
  public SSLSocketFactory getAcceptAllCertsSSLSocketFactory( ) {
    return null;
  }

  @Override
  public Class<? extends SSLSocketFactory> getAcceptAllCertsSSLSocketFactoryClass( ) {
    return null;
  }

  @Override
  public X509TrustManager getAcceptAllCertsTrustManager( ) {
    return null;
  }

  @Override
  public Class<? extends X509TrustManager> getAcceptAllCertsTrustManagerClass( ) {
    return null;
  }

  @Override
  public HostnameVerifier getAcceptAllHostnamesVerifier( ) {
    return null;
  }

  @Override
  public Class<? extends HostnameVerifier> getAcceptAllHostnamesVerifierClass( ) {
    return null;
  }

}

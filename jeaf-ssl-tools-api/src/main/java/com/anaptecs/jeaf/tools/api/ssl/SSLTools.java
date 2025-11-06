/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines a set of methods that should simplify the SSL handling.<br/>
 * <br/>
 * <b>Warning:</b> This interface offers some operations that are not intended to be used in production environments as
 * they might cause fatal security issues.
 * 
 * @author JEAF Development Team
 */
public interface SSLTools {
  /**
   * Configured implementation of SSL tools.
   */
  static final SSLTools SSL_TOOLS = ToolsLoader.getTools(SSLTools.class);

  /**
   * Method returns the configured implementation of the SSL Tools.
   * 
   * @return {@link SSLTools} Configured implementation of SSL tools. The method never returns null.
   */
  static SSLTools getSSLTools( ) {
    return SSL_TOOLS;
  }

  /**
   * Method returns a SSL socket factory implementation that accepts all kinds of certificates including self-signed and
   * expired ones.<br/>
   * <br/>
   * <b>Warning:</b> Do not used this feature in production environments.
   * 
   * 
   * @return {@link SSLSocketFactory} Socket factory that accepts all certificates. The method never returns null.
   */
  SSLSocketFactory getAcceptAllCertsSSLSocketFactory( );

  /**
   * Method returns the socket factory class that accepts all certificates.<br/>
   * <br/>
   * <b>Warning:</b> Do not used this feature in production environments.
   * 
   * @return {@link Class} Socket factory class that accepts all certificates. The method never returns null.
   */
  Class<? extends SSLSocketFactory> getAcceptAllCertsSSLSocketFactoryClass( );

  /**
   * Method returns a trust manager that accepts all kinds of certificates including self-signed and expired ones.<br/>
   * <br/>
   * <b>Warning:</b> Do not used this feature in production environments.
   * 
   * @return {@link X509TrustManager} Trust manager that accepts all certificates. The method never returns null.
   */
  X509TrustManager getAcceptAllCertsTrustManager( );

  /**
   * Method returns the trust manager class that accepts all certificates.<br/>
   * <br/>
   * <b>Warning:</b> Do not used this feature in production environments.
   * 
   * @return {@link Class} Trust manager class that accepts all certificates. The method never returns null.
   */
  Class<? extends X509TrustManager> getAcceptAllCertsTrustManagerClass( );

  /**
   * Method returns a host name verifier that accepts all host names to a certificate even those that do not match.<br/>
   * <br/>
   * <b>Warning:</b> Do not used this feature in production environments.
   * 
   * @return {@link HostnameVerifier} Host name verifier that accepts all host names. The method never returns null.
   */
  HostnameVerifier getAcceptAllHostnamesVerifier( );

  /**
   * Method returns the host name verifier class that accepts all kinds of host names.
   * 
   * @return {@link Class} Host name verifier class that accepts all host names. The method never returns null.
   */
  Class<? extends HostnameVerifier> getAcceptAllHostnamesVerifierClass( );
}

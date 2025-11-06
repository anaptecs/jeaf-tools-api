/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.net.Inet4Address;
import java.net.URL;
import java.util.List;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.network.NetworkingTools;

@ToolsImplementation(toolsInterface = NetworkingTools.class)
public class NetworkingToolsImpl implements NetworkingTools {

  @Override
  public String getHostname( ) {
    return null;
  }

  @Override
  public List<Inet4Address> getIPv4Addresses( ) {
    return null;
  }

  @Override
  public List<String> getHardwareAddresses( ) {
    return null;
  }

  @Override
  public boolean isReachable( String pHostAddress ) {
    return false;
  }

  @Override
  public boolean isReachable( String pHostAddress, int pTimeout ) {
    return false;
  }

  @Override
  public URL toURL( String pURLString ) {
    return null;
  }

}

/**
 * Copyright 2004 - 2016 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.network;

import java.net.Inet4Address;
import java.net.URL;
import java.util.List;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines the helper methods that are provided by JEAF in the area of networks.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public interface NetworkingTools {
  /**
   * Configured implementation of networking tools.
   */
  static final NetworkingTools NETWORKING_TOOLS = ToolsLoader.getTools(NetworkingTools.class);

  /**
   * Method returns the configured implementation of the Networking Tools.
   * 
   * @return {@link NetworkingTools} Configured implementation of networking tools. The method never returns null.
   */
  static NetworkingTools getNetworkingTools( ) {
    return NETWORKING_TOOLS;
  }

  /**
   * Method returns the host name of this machine.
   * 
   * @return String Host name of this machine. Method never returns null.
   */
  String getHostname( );

  /**
   * Method returns all IPv4 addresses of the machine. Loop back addresses will not be returned as well as addresses
   * from interfaces that are not up and running. If the JVM has public and private IPv4 addresses then the public will
   * be ordered before the private addresses.
   * 
   * @return {@link List} List with all public IPv4 addresses of this JVM. The method never returns null.
   */
  List<Inet4Address> getIPv4Addresses( );

  /**
   * Method returns all real hardware addresses of this machine. "real" in this case means that virtual network adapters
   * are ignored as well as loop back adapters and adapters with invalid mac addresses.
   * 
   * @return List List of all hardware addresses. The Strings are formated in the typical MAC address style
   * AA:AA:AA:11:11:11. The method never returns null.
   */
  List<String> getHardwareAddresses( );

  /**
   * Method checks if the passed IP or host is reachable.
   * 
   * @param pHostAddress IP address or IP that should be check. The parameter must not be null and a valid IP or host
   * name.
   * @return boolean Method returns true in case that the host is reachable or false if not.
   */
  boolean isReachable( String pHostAddress );

  /**
   * Method checks if the passed IP or host is reachable.
   * 
   * @param pHostAddress IP address or IP that should be check. The parameter must not be null and a valid IP or host
   * name.
   * @param pTimeout Timeout in milliseconds.
   * @return boolean Method returns true in case that the host is reachable or false if not.
   */
  boolean isReachable( String pHostAddress, int pTimeout );

  /**
   * Method creates a new {@link URL} from the passed string.
   * 
   * @param pURLString String that should be used to create a {@link URL} object. The parameter must not be null.
   * @return {@link URL} URL object that was created using the passed string.
   * @throws JEAFSystemException if the passed string is not a valid URL.
   */
  URL toURL( String pURLString );
}

/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.tools.api.network.NetworkingTools;

/**
 * Annotation is used to configure behavior of {@link NetworkingTools} implementation.
 * 
 * @author JEAF Development Team
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface NetworkingToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String NETWORKING_TOOLS_CONFIG_RESOURCE_NAME = "NetworkingToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String NETWORKING_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + NETWORKING_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * Default timeout for ping request will be 10 seconds if no other value is configured.
   */
  static final int DEFAULT_PING_TIMEOUT = 10000;

  /**
   * Defines the default timeout in milliseconds that will be used for pings if no other will be provided
   * 
   * {@link NetworkingTools#isReachable(String)} {@link NetworkingTools#isReachable(String, int)}
   */
  int pingTimeout() default DEFAULT_PING_TIMEOUT;
}

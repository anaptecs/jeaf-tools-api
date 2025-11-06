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
import java.nio.charset.Charset;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.tools.api.encoding.EncodingTools;

/**
 * Annotation can be used to configure {@link EncodingTools}.
 * 
 * @author JEAF Development Team
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface EncodingToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String ENCODING_TOOLS_CONFIG_RESOURCE_NAME = "EncodingToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String ENCODING_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + ENCODING_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * Constant for usage of default encoding as configured on JDK level.
   */
  static final boolean SYSTEM_DEFAULT_ENCODING_ENABLED = true;

  /**
   * Constant for default encoding that is used if nothing specific is configured.
   */
  static final String DEFAULT_ENCODING = "UTF-8";

  /**
   * Defines if the system default encoding should be used. If it is set to <code>true</code> the the system default
   * encoding will be used instead of configured value from {@link EncodingToolsConfig#defaultEncoding()}
   * 
   * {@link Charset#defaultCharset()} {@link EncodingToolsConfig#defaultEncoding()}
   */
  boolean useSystemDefaultEncoding() default SYSTEM_DEFAULT_ENCODING_ENABLED;

  /**
   * Defines the default encoding that should be used. Value will effectively only be used if
   * {@link EncodingToolsConfig#useSystemDefaultEncoding()} is set to <code>false</code>
   */
  String defaultEncoding() default DEFAULT_ENCODING;
}

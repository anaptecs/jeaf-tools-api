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
import com.anaptecs.jeaf.tools.api.xml.XMLTools;

/**
 * Annotation is used to configure behavior of {@link XMLTools} implementation.
 * 
 * @author JEAF Development Team
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface XMLToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String XML_TOOLS_CONFIG_RESOURCE_NAME = "XMLToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String XML_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + XML_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * If no other value is configured the a pool of 100 document builders will be used (one with validation and one
   * without)
   */
  static final int DEFAULT_DOCUMENT_BUILDER_POOL_SIZE = 100;

  /**
   * Defines the size of the document builder pool.
   */
  int documenBuilderPoolSize() default DEFAULT_DOCUMENT_BUILDER_POOL_SIZE;
}

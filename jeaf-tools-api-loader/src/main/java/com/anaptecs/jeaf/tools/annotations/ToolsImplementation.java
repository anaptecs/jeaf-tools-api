/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Annotation is intended to be used to mark a class as a tools implementation. Classes with this annotation will be
 * loaded by JEAF Tools Loader ({@link ToolsLoader}) during startup.
 * 
 * It is required to classes with this annotation provide an public default constructor.
 * 
 * @author JEAF Development Team
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface ToolsImplementation {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String TOOLS_IMPL_RESOURCE_NAME = "ToolsImplementation";

  /**
   * Path under which the configuration file is stored.
   */
  String TOOLS_IMPL_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + TOOLS_IMPL_RESOURCE_NAME;

  /**
   * Property defines the tools interface that is provided by the annotated tools implementation class. The referenced
   * interface must be implemented by the annotated class.
   */
  Class<?> toolsInterface();
}

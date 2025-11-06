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
import com.anaptecs.jeaf.tools.api.stream.StreamTools;

/**
 * Annotation is used to configure behavior of {@link StreamTools} implementation.
 * 
 * @author JEAF Development Team
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface StreamToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String STREAM_TOOLS_CONFIG_RESOURCE_NAME = "StreamToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String STREAM_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + STREAM_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * Default buffer size
   */
  static final int DEFAULT_BUFFER_SIZE = 8 * 1024;

  /**
   * Default size of the buffer pool.
   */
  static final int DEFAULT_BUFFER_POOL_SIZE = 20;

  /**
   * Size of the buffer that is used when working with streams. It is very unlikely that the default value needs to be
   * changed.
   */
  int bufferSize() default DEFAULT_BUFFER_SIZE;

  /**
   * Size of the buffer pool that is used when coping data from one stream to another. Pooling of buffers helps to
   * reduce generated garbage. Instead a little more memory is required. In optimal setting highly depends on the
   * behavior of the application itself. If the size of the pool is 0 or negative then pooling will be disabled.
   */
  int bufferPoolSize() default DEFAULT_BUFFER_POOL_SIZE;
}

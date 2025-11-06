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
import java.util.concurrent.TimeUnit;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.tools.api.monitoring.MeterRegistryFactory;
import com.anaptecs.jeaf.tools.api.monitoring.MonitoringTools;

/**
 * Annotation can be used to configure JEAF's {@link MonitoringTools}.
 * 
 * @author JEAF Development Team
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MonitoringToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the {@link MonitoringToolsConfig} annotation.
   */
  String MONITORING_TOOLS_CONFIG_RESOURCE_NAME = "MonitoringToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String MONITORING_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + MONITORING_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * Default time unit that is used in cases that time unit is not defined explicitly when working with JEAF's
   * Monitoring Tools.
   */
  TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MICROSECONDS;

  /**
   * Factory that should be used to create the so called meter registry. The meter registry is the key to connect JEAF's
   * Monitoring Tools to a concrete monitoring solution. This means that depending on the target monitoring solution the
   * matching factory class has to be defined here.
   */
  Class<? extends MeterRegistryFactory> meterRegistryFactory() default MeterRegistryFactory.class;

  /**
   * Configures the default time unit that is used when ever no time unit is set explicitly when working with JEAF's
   * Monitoring Tools. It's recommended that you either always work with explicit time units are always with the default
   * one.
   */
  TimeUnit defaultTimeUnit() default TimeUnit.MICROSECONDS;

  /**
   * Configures the domain prefix to which all meters belong to.
   */
  String domain() default "";

}

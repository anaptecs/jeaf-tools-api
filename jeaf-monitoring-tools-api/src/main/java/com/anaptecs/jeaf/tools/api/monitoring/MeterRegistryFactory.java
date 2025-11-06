/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import com.anaptecs.jeaf.tools.annotations.MonitoringToolsConfig;

import io.micrometer.core.instrument.MeterRegistry;

/**
 * Interface defines the factory to create a concrete {@link MeterRegistry}. Through the different implementations of
 * this interface it is possible to connect different monitoring solutions and JEAF Monitoring Tools.
 * 
 * Which factory is used at runtime can be configured through annotation {@link MonitoringToolsConfig}
 */
public interface MeterRegistryFactory {
  /**
   * Method creates a new Micrometer MeterRegistry.
   * 
   * @return {@link MeterRegistry} Created registry. The method must not return null.
   */
  MeterRegistry createMeterRegistry( String pDomain );
}

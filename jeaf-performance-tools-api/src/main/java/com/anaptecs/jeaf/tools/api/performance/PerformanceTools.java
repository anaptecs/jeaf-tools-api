/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.performance;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface provides methods / functionality that is rather helpful in case of performance measurements etc.
 * 
 * @author JEAF Development Team
 */
public interface PerformanceTools {
  /**
   * Configured implementation of performance tools.
   */
  static final PerformanceTools PERFORMANCE_TOOLS = ToolsLoader.getTools(PerformanceTools.class);

  /**
   * Method returns the configured implementation of the Performance Tools.
   * 
   * @return {@link PerformanceTools} Configured implementation of performance tools. The method never returns null.
   */
  static PerformanceTools getPerformanceTools( ) {
    return PERFORMANCE_TOOLS;
  }

  /**
   * Method creates a new stop watch. A stop watch can be used multiple times if required. However creating a new one is
   * also very cheap.
   * 
   * @param pName Name of the executed measurement. The parameter may be null.
   * @param pPrecision Precision with which the stop watch should report results.
   */
  Stopwatch createStopwatch( String pName, TimePrecision pTimePrecision );
}

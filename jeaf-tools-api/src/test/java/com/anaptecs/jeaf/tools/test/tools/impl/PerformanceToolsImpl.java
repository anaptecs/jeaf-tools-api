/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.performance.PerformanceTools;
import com.anaptecs.jeaf.tools.api.performance.Stopwatch;
import com.anaptecs.jeaf.tools.api.performance.TimePrecision;

@ToolsImplementation(toolsInterface = PerformanceTools.class)
public class PerformanceToolsImpl implements PerformanceTools {

  @Override
  public Stopwatch createStopwatch( String pName, TimePrecision pTimePrecision ) {
    return null;
  }

}

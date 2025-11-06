/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleFunction;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.monitoring.CounterInfo;
import com.anaptecs.jeaf.tools.api.monitoring.GaugeInfo;
import com.anaptecs.jeaf.tools.api.monitoring.MonitoringToken;
import com.anaptecs.jeaf.tools.api.monitoring.MonitoringTools;
import com.anaptecs.jeaf.tools.api.monitoring.Tag;
import com.anaptecs.jeaf.tools.api.monitoring.TimerInfo;
import com.anaptecs.jeaf.tools.api.monitoring.TimerSample;

@ToolsImplementation(toolsInterface = MonitoringTools.class)
public class MonitoringToolsImpl implements MonitoringTools {
  @Override
  public TimeUnit getDefaultTimeUnit( ) {
    return TimeUnit.MICROSECONDS;
  }

  @Override
  public long getTimestamp( ) {
    return 0;
  }

  @Override
  public long getTimestamp( TimeUnit pTimeUnit ) {
    return 0;
  }

  @Override
  public TimerSample newTimerSample( String pName, Tag... pTimerTags ) {
    return null;
  }

  @Override
  public TimerSample newTimerSample( String pName, TimeUnit pTimeUnit, Tag... pTimerTags ) {
    return null;
  }

  @Override
  public void recordTimerSample( TimerSample pTimerSample ) {
  }

  @Override
  public TimerInfo getTimerInfo( String pName, Tag... pTimerTags ) {
    return null;
  }

  @Override
  public void incrementCounter( String pName, Tag... pCounterTags ) {
  }

  @Override
  public CounterInfo getCounterInfo( String pName, Tag... pCounterTags ) {
    return null;
  }

  @Override
  public <T> void monitorObject( T pMonitoredObject, ToDoubleFunction<T> pValueFunction, String pName, Tag... pTags ) {
  }

  @Override
  public GaugeInfo getGaugeInfo( String pName, Tag... pTags ) {
    return null;
  }

  @Override
  public MonitoringToken getMonitoringToken( ) {
    return null;
  }
}

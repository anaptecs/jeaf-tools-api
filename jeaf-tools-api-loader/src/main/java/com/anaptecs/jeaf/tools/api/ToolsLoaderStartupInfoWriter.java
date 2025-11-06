/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import com.anaptecs.jeaf.xfun.annotations.StartupInfoWriterImpl;
import com.anaptecs.jeaf.xfun.api.trace.StartupInfoWriter;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.jeaf.xfun.api.trace.TraceLevel;

@StartupInfoWriterImpl
public class ToolsLoaderStartupInfoWriter implements StartupInfoWriter {

  @Override
  public Class<?> getStartupCompletedEventSource( ) {
    return ToolsLoader.class;
  }

  @Override
  public void traceStartupInfo( Trace pTrace, TraceLevel pTraceLevel ) {
    ToolsLoader.traceStartupInfo(pTrace, pTraceLevel);
  }

}

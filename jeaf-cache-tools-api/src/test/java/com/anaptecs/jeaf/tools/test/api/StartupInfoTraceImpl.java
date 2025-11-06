/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.api;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.SystemException;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;
import com.anaptecs.jeaf.xfun.api.trace.ContextStackElement;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.jeaf.xfun.api.trace.TraceLevel;

public class StartupInfoTraceImpl implements Trace {
  public List<String> messages = new ArrayList<>();

  public List<TraceLevel> traceLevels = new ArrayList<>();

  @Override
  public void newContextStack( ContextStackElement pContextStackElement ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void pushContextStackElement( ContextStackElement pContextStackElement ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public ContextStackElement popContextStackElement( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return null;
  }

  @Override
  public void writeEmergencyTrace( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void writeEmergencyTrace( String pMessage, Throwable pThrowable, TraceLevel pTraceLevel ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void writeInitInfo( String pMessage, TraceLevel pTraceLevel ) {
    messages.add(pMessage);
    traceLevels.add(pTraceLevel);
  }

  @Override
  public boolean isTraceEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void trace( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void traceObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( Throwable pThrowable, boolean pSuppressStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void trace( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isDebugEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void debug( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debugObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( Throwable pThrowable, boolean pNoStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void debug( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isInfoEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void info( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void infoObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( Throwable pThrowable, boolean pNoStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void info( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isWarnEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void warn( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warnObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( Throwable pThrowable, boolean pNoStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void warn( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isErrorEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void error( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void errorObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( Throwable pThrowable, boolean pNoStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void error( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isFatalEnabled( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public void fatal( String pMessage ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatalObject( Object pObject ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( Throwable pThrowable, boolean pNoStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( String pMessage, Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void fatal( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( Throwable pThrowable ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( Throwable pThrowable, boolean pSuppressStacktrace ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, Throwable pThrowable, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, Throwable pThrowable, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, ApplicationException pApplicationException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, ApplicationException pApplicationException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, SystemException pSystemException, String... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public void write( MessageID pMessageID, SystemException pSystemException, Object... pMessageParameters ) {
    fail("Method must not be called by StartupInfoWriter.");
  }

  @Override
  public boolean isLevelEnabled( TraceLevel pTraceLevel ) {
    fail("Method must not be called by StartupInfoWriter.");
    return false;
  }

  @Override
  public TraceLevel getLevel( ) {
    fail("Method must not be called by StartupInfoWriter.");
    return null;
  }
}

/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.config.ConfigurationReader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.StartupInfoEventCollector;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.jeaf.xfun.api.trace.TraceLevel;
import com.anaptecs.jeaf.xfun.bootstrap.Check;
import com.anaptecs.jeaf.xfun.fallback.trace.FallbackTraceProviderImpl;

/**
 * Class acts as loader for all tools implementations that are configured.
 * 
 * Which tools configuration will be loaded will be read from configuration file
 * {@link ToolsImplementation#TOOLS_IMPL_PATH} via the applications classpath. The file can either be maintained
 * manually or using JEAF Maven Plugin.
 * 
 * @author JEAF Development Team
 * 
 * @see {@link ToolsImplementation}
 */
public class ToolsLoader {
  /**
   * Name of the base path under which all Tools configuration files are located.
   */
  public static final String TOOLS_BASE_PATH = "META-INF/JEAF/Tools";

  /**
   * Map contains all loaded tools implementations.
   */
  private final Map<Class<?>, Object> tools = new HashMap<>();

  /**
   * Reference to instance that implements this class in the used environment.
   */
  private static final ToolsLoader INSTANCE;

  /**
   * Initialize class and load all configured tools implementations.
   */
  static {
    try {
      INSTANCE = new ToolsLoader();
      StartupInfoEventCollector.startupCompleted(ToolsLoader.class);
    }
    catch (RuntimeException e) {
      Trace lTrace = FallbackTraceProviderImpl.EMERGENCY_TRACE;
      lTrace.fatal(
          "Caught exception during JEAF Tools initialization. Most likely this is caused by some missing configuration file or problems with your classpath.");
      lTrace.fatal(e);
      throw e;
    }
  }

  /**
   * Method returns the tools implementation that belongs to the passed interface.
   * 
   * @param pToolsInterface Interface provided by the tools implementation that should be returned. The parameter must
   * not be null.
   * @return T ToolsImplementation for the requested interface. The method never returns null.
   * @throws JEAFSystemException In case that no matching tools implementation is available.
   */
  public static synchronized <T> T getTools( Class<T> pToolsInterface ) throws JEAFSystemException {
    return INSTANCE.getToolsImplementation(pToolsInterface);
  }

  /**
   * Initialize object using default configuration.
   */
  public ToolsLoader( ) {
    this(ToolsImplementation.TOOLS_IMPL_PATH);
  }

  /**
   * Initialize object.
   * 
   * @param pConfigurationFilePath Configuration file from which the names of annotated classes should be read. The
   * parameter must not be null.
   */
  public ToolsLoader( String pConfigurationFilePath ) {
    // Load all tools implementations
    ConfigurationReader lReader = new ConfigurationReader();
    List<Class<?>> lClasses = lReader.readClassesFromConfigFile(pConfigurationFilePath);
    for (Class<?> lToolsClass : lClasses) {
      ToolsImplementation lAnnotation = lToolsClass.getAnnotation(ToolsImplementation.class);
      if (lAnnotation != null) {
        Class<?> lToolsInterface = lAnnotation.toolsInterface();
        Object lExistingImplementation = tools.get(lToolsInterface);
        if (lExistingImplementation == null) {
          try {
            tools.put(lToolsInterface, lToolsClass.newInstance());
          }
          catch (ReflectiveOperationException e) {
            String lMessage = "Unable to create new instance of tools implementation '" + lToolsClass.getName()
                + "'. See nested exception for further details.";
            FallbackTraceProviderImpl.EMERGENCY_TRACE.error(lMessage);
            throw new ToolsLoaderRuntimeException(lMessage, e);
          }
          catch (RuntimeException e) {
            String lMessage = "Unable to create new instance of tools implementation '" + lToolsClass.getName()
                + "'. See nested exception for further details.";
            FallbackTraceProviderImpl.EMERGENCY_TRACE.error(lMessage);
            throw e;
          }
        }
        // Other implementation already available for the current interface
        else {
          String lMessage = "Ignoring tools implementation '" + lToolsClass.getName() + "' for tools interface '"
              + lToolsInterface.getName() + "'. Using implementation '" + lExistingImplementation.getClass().getName()
              + "' instead as it has higher priority.";
          FallbackTraceProviderImpl.EMERGENCY_TRACE.warn(lMessage);
        }
      }
    }
  }

  /**
   * Method returns the tools implementation that belongs to the passed interface.
   * 
   * @param pToolsInterface Interface provided by the tools implementation that should be returned. The parameter must
   * not be null.
   * @return T ToolsImplementation for the requested interface. The method never returns null.
   * @throws JEAFSystemException In case that no matching tools implementation is available.
   */
  public <T> T getToolsImplementation( Class<T> pToolsInterface ) throws JEAFSystemException {
    // Check parameter
    Check.checkInvalidParameterNull(pToolsInterface, "pToolsInterface");

    // Lookup matching tools implementation.
    @SuppressWarnings("unchecked")
    T lToolsImpl = (T) tools.get(pToolsInterface);

    // Return configured tools implementation
    if (lToolsImpl != null) {
      return lToolsImpl;
    }
    // Requested tools implementation is not available.
    else {
      throw new ToolsLoaderRuntimeException(
          "No implementation for tools interface " + pToolsInterface.getName() + " configured.");
    }
  }

  /**
   * Method traces startup info about the loaded Tools implementations.
   * 
   * @param pTrace Trace object that should be used to write startup info. The parameter must not be null.
   * @param pTraceLevel Trace level that should be used. The parameter must not be null.
   */
  public static void traceStartupInfo( Trace pTrace, TraceLevel pTraceLevel ) {
    pTrace.writeInitInfo("JEAF Tools uses the following implementations:", pTraceLevel);
    for (Entry<Class<?>, Object> lNextEntry : INSTANCE.tools.entrySet()) {
      pTrace.writeInitInfo(String.format(XFun.IMPL_INFO_FORMAT_STRING, lNextEntry.getKey().getSimpleName() + ":",
          lNextEntry.getValue().getClass().getName()), pTraceLevel);
    }
  }
}

/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleFunction;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines method that can be used to simplify monitoring of existing applications. JEAF's Monitoring Tools
 * are compatible with Micrometer (https://micrometer.io/) which is a monitoring facade and can be bound to a wide range
 * of monitoring solutions.
 * 
 * JEAF's Monitoring Tools completely decouple application code from the concrete monitoring solution. You will also
 * have no dependencies to Micrometer in your application code.
 * 
 * @author JEAF Development Team
 */
public interface MonitoringTools {
  /**
   * Configured implementation of monitoring tools.
   */
  static final MonitoringTools MONITORING_TOOLS = ToolsLoader.getTools(MonitoringTools.class);

  /**
   * Method returns the configured implementation of the Monitoring Tools.
   * 
   * @return {@link MonitoringTools} Configured implementation of monitoring tools. The method never returns null.
   */
  static MonitoringTools getMonitoringTools( ) {
    return MONITORING_TOOLS;
  }

  /**
   * Method returns the configured default time unit. The default time unit is used when ever no time unit is set
   * explicitly when working with JEAF's Monitoring Tools. It's recommended that you either always work with explicit
   * time units are always with the default one.
   * 
   * @return {@link TimeUnit} Configured default time unit. The method never returns null.
   */
  TimeUnit getDefaultTimeUnit( );

  /**
   * Method returns the current timestamp with default time unit precision.
   * 
   * @return long Current timestamp based on the precision of the configured default time unit.
   * 
   * {@link #getDefaultTimeUnit()}
   */
  long getTimestamp( );

  /**
   * Method returns a timestamp that can be used to measure execution time. Based on the passed time unit either
   * {@link System#currentTimeMillis()} or {@link System#nanoTime()} will be used to resolve timestamp. Due to different
   * mechanisms in timestamp resolution timestamps with different {@link TimeUnit} can not be mixed.
   * 
   * @param pTimeUnit Time unit that should be used for recordings. The parameter must not be null.
   * @return long Timestamp using the passed time unit.
   */
  long getTimestamp( TimeUnit pTimeUnit );

  /**
   * Method creates a new timer sample. This is the starting point for a new recording. As soon as the recording is done
   * {@link #recordTimerSample(TimerSample)} needs to be called. The created timer sample uses the default time unit for
   * its recording.
   * 
   * @param pName Name of the timer. The parameter must not be null.
   * @param pTimerTags Optional tags for the timer. Please be aware that a timer is identified by its name and all of
   * its tags.
   * @return {@link TimerSample} Created timer sample. the method never returns null.
   */
  TimerSample newTimerSample( String pName, Tag... pTimerTags );

  /**
   * Method creates a new timer sample. This is the starting point for a new recording. As soon as the recording is done
   * {@link #recordTimerSample(TimerSample)} needs to be called. The created timer sample uses the default time unit for
   * its recording.
   * 
   * @param pName Name of the timer. The parameter must not be null.
   * @param pTimeUnit Time unit that is used for recording. The parameter must not be null.
   * @param pTimerTags Optional tags for the timer. Please be aware that a timer is identified by its name and all of
   * its tags.
   * @return {@link TimerSample} Created timer sample. The method never returns null.
   */
  TimerSample newTimerSample( String pName, TimeUnit pTimeUnit, Tag... pTimerTags );

  /**
   * Method records the passed timer sample. Start time of the recorded sample is when the sample was created and stop
   * time will be this call.
   * 
   * @param pTimerSample Time sample that should be recorded. The parameter must not be null.
   */
  void recordTimerSample( TimerSample pTimerSample );

  /**
   * Method returns status information about the timer that is identified by the passed parameters.
   * 
   * @param pName Name of the timer. The parameter must not be null.
   * @param pTimerTags Optional tags for the timer. Please be aware that a timer is identified by its name and all of
   * its tags.
   * @return {@link TimerInfo} Status information about the requested timer. The method never returns null.
   */
  TimerInfo getTimerInfo( String pName, Tag... pTimerTags );

  /**
   * Method increments the counter with the passed name and tags.Please be aware that a counter is identified by its
   * name and all of its tags.
   * 
   * @param pName Name of the counter. The parameter must be a real string.
   * @param pCounterTags Optional list of tags of the counter.
   */
  void incrementCounter( String pName, Tag... pCounterTags );

  /**
   * Method returns the current status info of the counter with the passed name and tags. Please be aware that a counter
   * is identified by its name and all of its tags.
   * 
   * @param pName Name of the counter. The parameter must be a real string.
   * @param pCounterTags Optional list of tags of the counter.
   * @return {@link CounterInfo} Status information about the requested counter. The method never returns null.
   */
  CounterInfo getCounterInfo( String pName, Tag... pCounterTags );

  /**
   * Method monitors the passed object using the defined method to retrieve the monitored value. If the method is called
   * for the first time for a combination of name and tags then a Gauge will be created. The status of the gauge can be
   * requested using {@link #getGaugeInfo(String, Tag...)}.
   * 
   * @param pMonitoredObject Object that should be monitored. The parameter must not be null.
   * @param pValueFunction Function that should be used to used to retrieve the value that should be monitored. The
   * parameter must not be null
   * @param pName Name of the value that will be monitored and will also be used to name the meter. The parameter must
   * be a real string. Please be aware that meters are identified by its name and all of its tags.
   * @param pTags Optional list of tags of the meter.
   */
  <T> void monitorObject( T pMonitoredObject, ToDoubleFunction<T> pValueFunction, String pName, Tag... pTags );

  /**
   * Method returns a status information about the gauge that can be identified by the passed name and tags.
   * 
   * @param pName Name of the gauge that should be returned. The parameter must be a real string. Please be aware that
   * meters are identified by its name and all of its tags.
   * @param pTags Optional list of tags of the meter.
   * @return {@link GaugeInfo} Info object representing the requested gauge. The method never returns null.H
   */
  GaugeInfo getGaugeInfo( String pName, Tag... pTags );

  /**
   * Method returns a monitoring token. Monitoring tokens can be used to link multiple threads that execute a business
   * transaction into a single monitoring transaction. Linking of threads is only required in case that some parts of a
   * business transaction are executed asynchronously.
   * 
   * To effectively link threads with each other method {@link MonitoringToken#link()} or
   * {@link MonitoringToken#linkAndRelease()} has to be called from the thread that should be linked to its "parent".
   * 
   * It's very important to release the token as soon as no further threads should be linked
   * ({@link MonitoringToken#release()}) .
   * 
   * @return {@link MonitoringToken} Token that can be used to link another thread with the current one to span them
   * together into a single transaction from a performance monitoring perspective.
   */
  MonitoringToken getMonitoringToken( );
}

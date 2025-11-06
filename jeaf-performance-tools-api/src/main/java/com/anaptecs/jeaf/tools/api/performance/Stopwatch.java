/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.performance;

public interface Stopwatch {

  /**
   * Method starts the stop watch. A stop watch can be started multiple times. When starting the stop watch may be
   * existing results will be deleted.
   */
  Stopwatch start( );

  /**
   * Method starts the stop watch. A stop watch can be started multiple times. When starting the stop watch may be
   * existing results will be deleted.
   * 
   * @param pName Name of the executed measurement. The parameter may be null.
   * @param pCount Number of iterations.
   */
  Stopwatch start( long pCount );

  /**
   * Method stops a running measurements and logs the result.
   */
  void stopAndTrace( );

  /**
   * Method stops a running measurement.
   */
  void stop( );

  /**
   * Method stops a running measurement.
   * 
   * @param pCount Number of iterations.
   */
  void stop( long pCount );

  /**
   * Method stops a running measurements and logs the result.
   * 
   * @param pCount Number of iterations.
   */
  void stopAndTrace( long pCount );

  /**
   * Method checks if the stop watch is still running.
   * 
   * @return boolean Method returns true if the stop watch is still running and otherwise false.
   */
  boolean isRunning( );

  /**
   * Method returns the result of the measurement. If the stop watch is not stopped then it will be done by this method.
   * 
   * @return {@link StopwatchResult} Result of the measurement.
   */
  StopwatchResult getResult( );

  /**
   * Method logs the results of a measurement.
   */
  void traceResult( );
}
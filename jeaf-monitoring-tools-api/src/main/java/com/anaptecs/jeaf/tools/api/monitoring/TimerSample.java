/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import java.util.concurrent.TimeUnit;

/**
 * Interface represents a timer sample that is used for a recording.
 * 
 * @author JEAF Development Team
 */
public interface TimerSample {
  /**
   * Method returns the name of the timer.
   * 
   * @return {@link String} Name of the timer. the method always returns a real string.
   */
  public String getTimerName( );

  /**
   * Method returns the tags of the timer.
   * 
   * @return {@link Tag} Array with all tags of the timer. the method may return null.
   */
  public Tag[] getTimerTags( );

  /**
   * Method returns the timestamp when the timer sample was started using the {@link TimeUnit} as returned by
   * {@link #getTimeUnit()}.
   * 
   * @return long Start timestamp.
   */
  long getStartTimestamp( );

  /**
   * Method returns the time unit that is used to record the sample.
   * 
   * @return {@link TimeUnit} Time unit that is used for the sample. The method never returns null.
   */
  TimeUnit getTimeUnit( );
}

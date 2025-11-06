/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

/**
 * Monitoring tokens can be used to link multiple threads that execute a business transaction into a single monitoring
 * transaction. Linking of threads is only required in case that some parts of a business transaction are executed
 * asynchronously.
 * 
 * To effectively link threads with each other method {@link #link()} or {@link #linkAndRelease()} have to be called
 * from the thread that should be linked to its "parent".
 * 
 * It's very important to release the token as soon as no further threads should be linked ({@link #release()}).
 * 
 * @author JEAF Development Team
 */
public interface MonitoringToken {
  /**
   * Method links the current thread with the transaction to which the token originally belongs to.
   * 
   * @return boolean Method returns true if the current thread could be linked and false in all other cases.
   */
  boolean link( );

  /**
   * Method releases the token. This means that it can not be used any longer.
   */
  void release( );

  /**
   * Method links the current thread with the transaction of the token and afterwards releases the token. As
   * housekeeping of tokens is very important this is the simplest way to do it.
   * 
   * @return boolean Method returns true if the current thread could be linked and false in all other cases.
   */
  boolean linkAndRelease( );

  /**
   * Method checks if the token can still be used. As soon as the token was release it will not be active any longer.
   * 
   * @return boolean Method returns true if the token can still be used and false in all other cases.
   */
  boolean isActive( );
}

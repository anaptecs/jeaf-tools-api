/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.stream;

/**
 * Class defines so called buffering modes when copying streams
 * 
 * @author JEAF Development Team
 */
public enum BufferingMode {
  /**
   * Buffering should always be used.
   */
  ALWAYS,

  /**
   * No buffering should be used
   */
  NO_BUFFERING,

  /**
   * Buffering should only be used in meaningful cases. This means that the implementation decides when buffering will
   * be done.
   */
  AUTO
}

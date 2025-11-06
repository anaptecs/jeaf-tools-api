/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.monitoring;

import java.util.List;

/**
 * Interface defines all method that are available for all kinds of meters.
 * 
 * @author JEAF Development Team
 */
public interface MeterInfo {
  /**
   * Method return the name of the timer.
   * 
   * @return {@link String} Name of the timer. The method always returns a real string.
   */
  String getName( );

  /**
   * Method returns all tags of the timer.
   * 
   * @return {@link Tag} List with all tags of the timer. The method never returns null but may return an empty list.
   */
  List<Tag> getTags( );

}

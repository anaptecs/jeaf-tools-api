/**
 * Copyright 2004 - 2017 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.cache;

import java.util.Calendar;

/**
 * Interface defines methods for all cacheable objects in order that they work with any of JEAF's cache implementations.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public interface Cacheable<K> {
  /**
   * Method returns the cache key of a cachable object
   * 
   * @return KEY Cache key of this object. The method must not return null.
   */
  K getCacheKey( );

  /**
   * Method returns the expire date of this object.
   * 
   * @return {@link Calendar} Expiry date of the cache entry. The method may return null. This means that the object
   * never expires.
   */
  Calendar getExpiryDate( );

}

/**
 * Copyright 2004 - 2017 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.cache;

/**
 * This interface defines the methods of a generic cache.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 *
 * @param <K> Cache-Key type
 * @param <O> Object type
 */
public interface Cache<K, O extends Cacheable<K>> {

  /**
   * Method returns the cached object with the passed key.
   * 
   * @param pCacheKey Key of the cached object that should be returned. The parameter must not be null-
   * @return CachedObject Cached object with the passed key. The method returns null if no object with the passed key
   * exists.
   */
  O getCachedObject( K pCacheKey );

  /**
   * Method adds the passed object to the cache. If an object with the same key already exists then it will be
   * overwritten.
   * 
   * @param pCacheObject Object that should be added to the cache. The parameter must not be null.
   */
  void cacheObject( O pCacheObject );
}
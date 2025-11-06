/**
 * Copyright 2004 - 2017 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.cache;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines the access to JEAF's cache tools.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public interface CacheTools {
  /**
   * Configured implementation of cache tools.
   */
  static final CacheTools CACHE_TOOLS = ToolsLoader.getTools(CacheTools.class);

  /**
   * Method returns the configured implementation of the Cache Tools.
   * 
   * @return {@link CacheTools} Configured implementation of cache tools. The method never returns null.
   */
  static CacheTools getCacheTools( ) {
    return CACHE_TOOLS;
  }

  /**
   * Method creates a new time based cache instance.
   * 
   * @param pCacheTTL Time to life of all objects inside the cache. After the TTL expired all objects of the cache will
   * be read again from the database. The parameter must not be null. The TTL is defined in seconds.
   */
  <K, O extends Cacheable<K>> Cache<K, O> createTimeBasedCache( int pCacheTTL );
}

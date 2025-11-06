/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.cache.Cache;
import com.anaptecs.jeaf.tools.api.cache.CacheTools;
import com.anaptecs.jeaf.tools.api.cache.Cacheable;

@ToolsImplementation(toolsInterface = CacheTools.class)
public class CacheToolsImpl implements CacheTools {

  @Override
  public <KEY, CACHED_OBJECT extends Cacheable<KEY>> Cache<KEY, CACHED_OBJECT> createTimeBasedCache( int pCacheTTL ) {
    return null;
  }

}

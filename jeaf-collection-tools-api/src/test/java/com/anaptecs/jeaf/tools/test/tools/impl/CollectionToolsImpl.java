/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.collections.CollectionTools;

@ToolsImplementation(toolsInterface = CollectionTools.class)
public class CollectionToolsImpl implements CollectionTools {

  @Override
  public <T> Collection<T> unmodifiableClone( Collection<? extends T> pCollection ) {
    return null;
  }

  @Override
  public <T> List<T> unmodifiableClone( List<? extends T> pList ) {
    return null;
  }

  @Override
  public <K, V> Map<K, V> unmodifiableClone( Map<? extends K, ? extends V> pMap ) {
    return null;
  }

  @Override
  public <T> Set<T> unmodifiableClone( Set<? extends T> pSet ) {
    return null;
  }

  @Override
  public <T> SortedSet<T> unmodifiableClone( SortedSet<? extends T> pSortedSet ) {
    return null;
  }

  @Override
  public <T, S extends T> List<S> filter( Collection<? extends T> pCollection, Class<S> pClass ) {
    return null;
  }

  @Override
  public <T, S extends T> List<S> filter( Map<?, ? extends T> pMap, Class<S> pClass ) {
    return null;
  }

  @Override
  public String toString( Collection<?> pCollection, String pSeparator ) {
    return null;
  }

  @Override
  public <T> boolean addAll( Collection<T> pCollection, @SuppressWarnings("unchecked") T... pElements ) {
    return false;
  }

}

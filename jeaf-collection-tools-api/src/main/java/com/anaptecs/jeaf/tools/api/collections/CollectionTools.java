/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.collections;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines all helper methods concerning collections. As JEAF supports multiple runtime environments and some
 * of them as Google Web Toolkit have limitations in some areas or require special implementations tools classes are
 * also abstracted by an interface.
 * 
 * @author JEAF Development Team
 * @version JEAF Version 1.0
 */
public interface CollectionTools {
  /**
   * Configured implementation of collection tools.
   */
  static final CollectionTools COLLECTION_TOOLS = ToolsLoader.getTools(CollectionTools.class);

  /**
   * Method returns the configured implementation of the Collection Tools.
   * 
   * @return {@link CollectionTools} Configured implementation of collection tools. The method never returns null.
   */
  static CollectionTools getCollectionTools( ) {
    return COLLECTION_TOOLS;
  }

  /**
   * Method creates a unmodifiable clone of the passed collection.
   * 
   * @param <T>
   * @param pCollection List of which an unmodifiable clone should be created. The parameter must not be null.
   * @return {@link Collection} Unmodifiable clone of the passed collection. The method never returns null.
   */
  <T> Collection<T> unmodifiableClone( Collection<? extends T> pCollection );

  /**
   * Method creates a unmodifiable clone of the passed list.
   * 
   * @param <T>
   * @param pList List of which an unmodifiable clone should be created. The parameter must not be null.
   * @return {@link List} Unmodifiable clone of the passed list. The method never returns null.
   */
  <T> List<T> unmodifiableClone( List<? extends T> pList );

  /**
   * Method creates a unmodifiable clone of the passed map.
   * 
   * @param <K>
   * @param <V>
   * @param pMap Map of which an unmodifiable clone should be created. The parameter must not be null.
   * @return {@link Map} Unmodifiable clone of the passed Map. The method never returns null.
   */
  <K, V> Map<K, V> unmodifiableClone( Map<? extends K, ? extends V> pMap );

  /**
   * Method creates a unmodifiable clone of the passed set.
   * 
   * @param <T>
   * @param pSet Set of which an unmodifiable clone should be created. The parameter must not be null.
   * @return {@link Set} Unmodifiable clone of the passed set. The method never returns null.
   */
  <T> Set<T> unmodifiableClone( Set<? extends T> pSet );

  /**
   * Method creates a unmodifiable clone of the passed sorted set.
   * 
   * @param <T>
   * @param pSortedSet Sorted set of which an unmodifiable clone should be created. The parameter must not be null.
   * @return {@link SortedSet} Unmodifiable clone of the passed sorted set. The method never returns null.
   */
  <T> SortedSet<T> unmodifiableClone( SortedSet<? extends T> pSortedSet );

  /**
   * Methods filters the passed collection for all objects that have the passed type.
   * 
   * @param <T>
   * @param pCollection Collection that should be filtered for all objects of the passed type. The parameter must not be
   * null.
   * @param pClass Type for which the passed collection should be filtered. The parameter must not be null.
   * @return {@link List} List with all objects that are instance of the passed class. The method never returns null.
   */
  <T, S extends T> List<S> filter( Collection<? extends T> pCollection, Class<S> pClass );

  /**
   * Methods filters the passed map for entries that have the passed type.
   * 
   * @param <T>
   * @param pMap Map that should be filtered for all objects of the passed type. The parameter must not be null.
   * @param pClass Type for which the passed map should be filtered. The parameter must not be null.
   * @return {@link List} List with all objects that are instance of the passed class. The method never returns null.
   */
  <T, S extends T> List<S> filter( Map<?, ? extends T> pMap, Class<S> pClass );

  /**
   * Method converts the passed collection into a string using {@link Object#toString()} for each object plus the passed
   * separator.
   * 
   * @param pCollection Collection that should be converted into a string. The parameter must not be null.
   * @param pSeparator Separator string that should be used. The parameter must not be null.
   * @return {@link String} String that was created from the collection. The method never returns null.
   */
  String toString( Collection<?> pCollection, String pSeparator );

  /**
   * Method add all the elements of the passed array to the passed collection.
   * 
   * @param pCollection Collection to which the elements should be added. The parameter must not be null.
   * @param pElements Array with all elements that should be added. The parameter may be null.
   * @return boolean Method returns true if one or more elements were added.
   */
  <T> boolean addAll( Collection<T> pCollection, @SuppressWarnings("unchecked") T... pElements );
}

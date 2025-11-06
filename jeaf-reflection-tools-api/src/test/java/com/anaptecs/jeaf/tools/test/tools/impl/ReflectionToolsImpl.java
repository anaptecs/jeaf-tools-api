/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.reflect.ReflectionTools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@ToolsImplementation(toolsInterface = ReflectionTools.class)
public class ReflectionToolsImpl implements ReflectionTools {

  @Override
  public Class<?> loadClass( String pClassName ) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> Class<? extends T> loadClass( String pClassName, Class<T> pType ) throws JEAFSystemException {
    return null;
  }

  @Override
  public boolean isClassLoadable( String pClassName ) {
    return false;
  }

  @Override
  public <T> T newInstance( Class<T> pClass ) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T newInstance( Class<T> pClass, boolean pMakeAccessible ) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T newInstance( Class<T> pClass, Class<?> pAssignableClass ) {
    return null;
  }

  @Override
  public <T> T newInstance( String pClassName, Class<T> pAssignableClass ) {
    return null;
  }

  @Override
  public <T extends Annotation> Map<Class<?>, T> getAnnotations( List<Class<?>> pClasses, Class<T> pAnnotationType ) {
    return null;
  }
}

/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines the methods that are available to make the use of Java's Reflection API as simple as possible.
 * Nevertheless the most simple usage of the reflection API is not to use it. ;-)
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface ReflectionTools {
  /**
   * Configured implementation of reflection tools.
   */
  static final ReflectionTools REFLECTION_TOOLS = ToolsLoader.getTools(ReflectionTools.class);

  /**
   * Method returns the configured implementation of the Reflection Tools.
   * 
   * @return {@link ReflectionTools} Configured implementation of reflection tools. The method never returns null.
   */
  static ReflectionTools getReflectionTools( ) {
    return REFLECTION_TOOLS;
  }

  /**
   * Method loads the class with the passed name and returns its class object.
   * 
   * @param pClassName Name of the class that should be loaded. The parameter must not be null.
   * @return Class Class object of the class with the passed name. The method never returns null.
   * @throws JEAFSystemException if the class with the passed name could not be found in the applications classpath.
   */
  Class<?> loadClass( String pClassName ) throws JEAFSystemException;

  /**
   * Method loads the class with the passed name and returns its class object.
   * 
   * @param pClassName Name of the class that should be loaded. The parameter must not be null.
   * @param pType Type that is expected as return type. The parameter must not be null.
   * @return Class Class object of the class with the passed name. The method never returns null.
   * @throws JEAFSystemException if the class with the passed name could not be found in the applications classpath.
   */
  <T> Class<? extends T> loadClass( String pClassName, Class<T> pType ) throws JEAFSystemException;

  /**
   * Method checks if the class with the passed name is loadable from the class path.
   * 
   * @param pClassName Name of the class that should be loaded. The parameter must not be null.
   * @return boolean The method returns true if the class is loadable and false in all other cases.
   */
  boolean isClassLoadable( String pClassName );

  /**
   * Method creates a new instance of the passed class.
   * 
   * @param <T> Type parameter for class that should be created.
   * @param pClass Class of which a new instance should be created. The parameter must not be null.
   * @return Object Created instance of the passed class. The method never returns null.
   * @throws JEAFSystemException if the passed class does not provide a parameterless public constructor.
   */
  <T> T newInstance( Class<T> pClass ) throws JEAFSystemException;

  /**
   * Method creates a new instance of the passed class.
   * 
   * @param <T> Type parameter for class that should be created.
   * @param pClass Class of which a new instance should be created. The parameter must not be null.
   * @param pMakeAccessible If the parameter is set to true, the method will create a new instance of the passed class
   * ignoring the access modifier of the default constructor.
   * @return Object Created instance of the passed class. The method never returns null.
   * @throws JEAFSystemException if the passed class does not provide a parameterless public constructor.
   */
  <T> T newInstance( Class<T> pClass, boolean pMakeAccessible ) throws JEAFSystemException;

  /**
   * Method creates a new instance of the passed class. The created object has to be assignable to the passed class.
   * 
   * @param <T> Type
   * @param pClass Class of which a new instance should be created. The parameter must not be null.
   * @param pAssignableClass Class to which the created object has to be assignable to. The parameter must not be null.
   * @return Object Created instance of the passed class. The method never returns null.
   */
  <T> T newInstance( Class<T> pClass, Class<?> pAssignableClass );

  /**
   * Method creates a new instance of the class with the passed name. The created object has to be assignable to the
   * passed class.
   * 
   * @param <T> Type
   * @param pClassName Name of the class of which a new instance should be created. The parameter must not be null.
   * @param pAssignableClass Class to which the created object has to be assignable to. The parameter must not be null.
   * @return Object Created instance of the passed class. The method never returns null.
   */
  <T> T newInstance( String pClassName, Class<T> pAssignableClass );

  /**
   * Method returns a map with the passed classes as key and the annotation of the passed type as value. If the class
   * does not have the passed annotation then the class will not be inside the returned map.
   * 
   * @param pClasses List of classes whose annotation of the passed type should be returned. The parameter must not be
   * null.
   * @param pAnnotationType Type of the annotation that should be returned. The parameter must not be null.
   * @return {@link Map} Map with one the passed classes as key and annotation of the passed type as value. The method
   * never returns null.
   */
  <T extends Annotation> Map<Class<?>, T> getAnnotations( List<Class<?>> pClasses, Class<T> pAnnotationType );
}

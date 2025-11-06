/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.lang;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines tools for converting Java primitive types into wrapper types and vice versa. In addition to Java's
 * auto boxing mechanism also primitive array types are supported.
 * 
 * @author JEAF Development Team
 *
 */
public interface AutoBoxingTools {
  /**
   * Configured implementation of autoboxing tools.
   */
  static final AutoBoxingTools AUTO_BOXING_TOOLS = ToolsLoader.getTools(AutoBoxingTools.class);

  /**
   * Method returns the configured implementation of the Autoboxing Tools.
   * 
   * @return {@link AutoboxingTools} Configured implementation of autoboxing tools. The method never returns null.
   */
  static AutoBoxingTools getAutoBoxingTools( ) {
    return AUTO_BOXING_TOOLS;
  }

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  boolean autoBox( Boolean pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  boolean autoBox( Boolean pWrapper, boolean pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Boolean autoBox( boolean pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  boolean[] autoBox( Boolean[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Boolean[] autoBox( boolean[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  byte autoBox( Byte pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  byte autoBox( Byte pWrapper, byte pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Byte autoBox( byte pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  byte[] autoBox( Byte[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Byte[] autoBox( byte[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  short autoBox( Short pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  short autoBox( Short pWrapper, short pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Short autoBox( short pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  short[] autoBox( Short[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Short[] autoBox( short[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  int autoBox( Integer pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  int autoBox( Integer pWrapper, int pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Integer autoBox( int pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  int[] autoBox( Integer[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Integer[] autoBox( int[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  long autoBox( Long pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  long autoBox( Long pWrapper, long pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Long autoBox( long pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  long[] autoBox( Long[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Long[] autoBox( long[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  float autoBox( Float pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  float autoBox( Float pWrapper, float pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Float autoBox( float pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  float[] autoBox( Float[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Float[] autoBox( float[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  double autoBox( Double pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  double autoBox( Double pWrapper, double pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Double autoBox( double pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  double[] autoBox( Double[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Double[] autoBox( double[] pPrimitive );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter must not be null.
   * @return Primitive value of the passed wrapper.
   */
  char autoBox( Character pWrapper );

  /**
   * Method converts the passed wrapper into its primitive type.
   * 
   * @param pWrapper Java wrapper type that should be converted into its primitive type. The parameter may be null.
   * @param pNullDefault Default value that will be used in case that the passed wrapper is null.
   * @return Primitive value of the passed wrapper or its null default value.
   */
  char autoBox( Character pWrapper, char pNullDefault );

  /**
   * Method converts the passed primitive type into its wrapper type.
   * 
   * @param pPrimitive Primitive type that should be converted.
   * @return Wrapper type into which the primitive type was converted. The method never returns null.
   */
  Character autoBox( char pPrimitive );

  /**
   * Method converts the passed array of wrapper types into an array of its primitive types.
   * 
   * @param pWrapper Array of wrapper types the should be converted. The parameter may be null.
   * @return Array of primitive types. If the array of wrapper types is null then the method will also return null.
   */
  char[] autoBox( Character[] pWrapper );

  /**
   * Method converts the passed primitive array into an array of wrapper types.
   * 
   * @param pPrimitive Array of primitive types that should be converted. The parameter may be null.
   * @return Array of wrapper types. If the passed array is null then the method will also return null.
   */
  Character[] autoBox( char[] pPrimitive );
}

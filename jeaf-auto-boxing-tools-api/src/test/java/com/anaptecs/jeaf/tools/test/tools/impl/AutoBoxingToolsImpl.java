/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.lang.AutoBoxingTools;

@ToolsImplementation(toolsInterface = AutoBoxingTools.class)
public class AutoBoxingToolsImpl implements AutoBoxingTools {

  @Override
  public boolean autoBox( Boolean pWrapper ) {
    return false;
  }

  @Override
  public boolean autoBox( Boolean pWrapper, boolean pNullDefault ) {
    return false;
  }

  @Override
  public Boolean autoBox( boolean pPrimitive ) {
    return null;
  }

  @Override
  public boolean[] autoBox( Boolean[] pWrapper ) {
    return null;
  }

  @Override
  public Boolean[] autoBox( boolean[] pPrimitive ) {
    return null;
  }

  @Override
  public byte autoBox( Byte pWrapper ) {
    return 0;
  }

  @Override
  public byte autoBox( Byte pWrapper, byte pNullDefault ) {
    return 0;
  }

  @Override
  public Byte autoBox( byte pPrimitive ) {
    return null;
  }

  @Override
  public byte[] autoBox( Byte[] pWrapper ) {
    return null;
  }

  @Override
  public Byte[] autoBox( byte[] pPrimitive ) {
    return null;
  }

  @Override
  public short autoBox( Short pWrapper ) {
    return 0;
  }

  @Override
  public short autoBox( Short pWrapper, short pNullDefault ) {
    return 0;
  }

  @Override
  public Short autoBox( short pPrimitive ) {
    return null;
  }

  @Override
  public short[] autoBox( Short[] pWrapper ) {
    return null;
  }

  @Override
  public Short[] autoBox( short[] pPrimitive ) {
    return null;
  }

  @Override
  public int autoBox( Integer pWrapper ) {
    return 0;
  }

  @Override
  public int autoBox( Integer pWrapper, int pNullDefault ) {
    return 0;
  }

  @Override
  public Integer autoBox( int pPrimitive ) {
    return null;
  }

  @Override
  public int[] autoBox( Integer[] pWrapper ) {
    return null;
  }

  @Override
  public Integer[] autoBox( int[] pPrimitive ) {
    return null;
  }

  @Override
  public long autoBox( Long pWrapper ) {
    return 0;
  }

  @Override
  public long autoBox( Long pWrapper, long pNullDefault ) {
    return 0;
  }

  @Override
  public Long autoBox( long pPrimitive ) {
    return null;
  }

  @Override
  public long[] autoBox( Long[] pWrapper ) {
    return null;
  }

  @Override
  public Long[] autoBox( long[] pPrimitive ) {
    return null;
  }

  @Override
  public float autoBox( Float pWrapper ) {
    return 0;
  }

  @Override
  public float autoBox( Float pWrapper, float pNullDefault ) {
    return 0;
  }

  @Override
  public Float autoBox( float pPrimitive ) {
    return null;
  }

  @Override
  public float[] autoBox( Float[] pWrapper ) {
    return null;
  }

  @Override
  public Float[] autoBox( float[] pPrimitive ) {
    return null;
  }

  @Override
  public double autoBox( Double pWrapper ) {
    return 0;
  }

  @Override
  public double autoBox( Double pWrapper, double pNullDefault ) {
    return 0;
  }

  @Override
  public Double autoBox( double pPrimitive ) {
    return null;
  }

  @Override
  public double[] autoBox( Double[] pWrapper ) {
    return null;
  }

  @Override
  public Double[] autoBox( double[] pPrimitive ) {
    return null;
  }

  @Override
  public char autoBox( Character pWrapper ) {
    return 0;
  }

  @Override
  public char autoBox( Character pWrapper, char pNullDefault ) {
    return 0;
  }

  @Override
  public Character autoBox( char pPrimitive ) {
    return null;
  }

  @Override
  public char[] autoBox( Character[] pWrapper ) {
    return null;
  }

  @Override
  public Character[] autoBox( char[] pPrimitive ) {
    return null;
  }

}

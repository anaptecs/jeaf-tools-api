/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.date.DateFormatStyle;
import com.anaptecs.jeaf.tools.api.date.DateTools;

@ToolsImplementation(toolsInterface = DateTools.class)
public class DateToolsImpl implements DateTools {

  @Override
  public Calendar newCalendar( ) {
    return null;
  }

  @Override
  public Calendar newCalendar( long pTimeInMillis ) {
    return null;
  }

  @Override
  public Date toDate( int pYear, int pMonth, int pDay ) {
    return null;
  }

  @Override
  public Date toDate( int pYear, int pMonth, int pDay, int pHour, int pMinute, int pSecond ) {
    return null;
  }

  @Override
  public Date toDate( int pYear, int pMonth, int pDay, int pHour, int pMinute, int pSecond, int pMilliseconds ) {
    return null;
  }

  @Override
  public Date toDate( FileTime pFileTime ) {
    return null;
  }

  @Override
  public Date addDaysToActualDate( int pDays ) {
    return null;
  }

  @Override
  public Calendar addDaysToActualCalendar( int pDays ) {
    return null;
  }

  @Override
  public String toDateString( Date pDate ) {
    return null;
  }

  @Override
  public String toDateString( Calendar pCalendar ) {
    return null;
  }

  @Override
  public String toDateTimeString( Date pDate ) {
    return null;
  }

  @Override
  public String toDateTimeString( Calendar pCalendar ) {
    return null;
  }

  @Override
  public String toShortDateTimeString( Date pDate ) {
    return null;
  }

  @Override
  public String toShortDateTimeString( Calendar pDate ) {
    return null;
  }

  @Override
  public String toTimestampString( Date pDate ) {
    return null;
  }

  @Override
  public String toTimestampString( Calendar pDate ) {
    return null;
  }

  @Override
  public String toLocalizedDateTimeString( Date pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateTimeString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateTimeString( Date pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateTimeString( Calendar pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateOnlyString( Date pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateOnlyString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateOnlyString( Date pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedDateOnlyString( Calendar pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedTimeOnlyString( Date pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedTimeOnlyString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedTimeOnlyString( Date pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toLocalizedTimeOnlyString( Calendar pDate, DateFormatStyle pStyle ) {
    return null;
  }

  @Override
  public String toString( Date pDate, String pPattern ) {
    return null;
  }

  @Override
  public String toString( Calendar pDate, String pPattern ) {
    return null;
  }

  @Override
  public int calculateTimeDifferenceInDays( Date pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInDays( Calendar pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInHours( Date pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInHours( Calendar pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInMinutes( Date pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInMinutes( Calendar pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInSeconds( Date pDate ) {
    return 0;
  }

  @Override
  public int calculateTimeDifferenceInSeconds( Calendar pDate ) {
    return 0;
  }

  @Override
  public Calendar toCalendar( Date pDate ) {
    return null;
  }

  @Override
  public Calendar toCalendar( FileTime pFileTime ) {
    return null;
  }

  @Override
  public Calendar toCalendar( String pDateString ) {
    return null;
  }

  @Override
  public boolean isDateValid( String pDate ) {
    return false;
  }

  @Override
  public Date toDate( String pDate ) {
    return null;
  }

  @Override
  public Date toDate( Calendar pCalendar ) {
    return null;
  }

  @Override
  public Date toDate( String pDate, boolean pStrict ) {
    return null;
  }

  @Override
  public Calendar toCalendar( String pDate, boolean pStrict ) {
    return null;
  }

  @Override
  public String toString( Date pDate ) {
    return null;
  }

  @Override
  public String toString( Calendar pCalendar ) {
    return null;
  }

}

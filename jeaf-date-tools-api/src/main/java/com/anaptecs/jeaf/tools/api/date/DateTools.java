/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.date;

import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines all helper methods concerning dates. As JEAF supports multiple runtime environments and some of
 * them as Google Web Toolkit have limitations in some areas or require special implementations tools classes are also
 * abstracted by an interface.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface DateTools {
  /**
   * Configured implementation of date tools.
   */
  static final DateTools DATE_TOOLS = ToolsLoader.getTools(DateTools.class);

  /**
   * Method returns the configured implementation of the Date Tools.
   * 
   * @return {@link DateTools} Configured implementation of date tools. The method never returns null.
   */
  static DateTools getDateTools( ) {
    return DATE_TOOLS;
  }

  /**
   * Constant defines the pattern that is used to convert dates in string format to java objects. The string
   * representation of a date has to have the following structure: "yyyy-MM-dd" (e.g. "2004-11-28")
   */
  public static final String DATE_PATTERN = "yyyy-MM-dd";

  /**
   * Constant defines the pattern that is used to convert time stamps in string format to java objects. The string
   * representation of a time stamp has to have the following structure: "yyyy-MM-dd HH:mm:ss" (e.g. "2004-11-28
   * 13:31:17")
   */
  public static final String SHORT_DATE_TIME_PATTERN = DATE_PATTERN + " HH:mm";

  /**
   * Constant defines the pattern that is used to convert time stamps in string format to java objects. The string
   * representation of a time stamp has to have the following structure: "yyyy-MM-dd HH:mm:ss" (e.g. "2004-11-28
   * 13:31:17")
   */
  public static final String DATE_TIME_PATTERN = SHORT_DATE_TIME_PATTERN + ":ss";

  /**
   * Constant defines the pattern that is used to convert time stamps in string format to java objects. The string
   * representation of a time stamp has to have the following structure: "yyyy-MM-dd HH:mm:ss.SSS" (e.g. "2004-11-28
   * 13:31:17.098")
   */
  public static final String TIMESTAMP_PATTERN = DATE_TIME_PATTERN + ".SSS";

  /**
   * Method creates a new calendar object with the current date, time and timezone.
   * 
   * @return {@link Calendar} New calendar object. The method never returns null.
   */
  Calendar newCalendar( );

  /**
   * Method creates a new calendar wit the passed time / date and the current timezone.
   * 
   * @param pTimeInMillis Date / time definition in milliseconds.
   * @return {@link Calendar} New calendar object. The method never returns null.
   */
  Calendar newCalendar( long pTimeInMillis );

  /**
   * Method returns a date object the represents the passed date.
   * 
   * @param pYear Year of the date.
   * @param pMonth Month of the date.
   * @param pDay Day of month of the date.
   * @return {@link Date} Created date object. The method never returns null.
   */
  Date toDate( int pYear, int pMonth, int pDay );

  /**
   * Method returns a date object the represents the passed date.
   * 
   * @param pYear Year of the date.
   * @param pMonth Month of the date.
   * @param pDay Day of month of the date.
   * @param pHour Hour of the date.
   * @param pMinute Minute of the date.
   * @param pSecond Second of the date.
   * @return {@link Date} Created date object. The method never returns null.
   */
  Date toDate( int pYear, int pMonth, int pDay, int pHour, int pMinute, int pSecond );

  /**
   * Method returns a date object the represents the passed date.
   * 
   * @param pYear Year of the date.
   * @param pMonth Month of the date.
   * @param pDay Day of month of the date.
   * @param pHour Hour of the date.
   * @param pMinute Minute of the date.
   * @param pSecond Second of the date.
   * @param pMilliseconds Milliseconds of the date.
   * @return {@link Date} Created date object. The method never returns null.
   */
  Date toDate( int pYear, int pMonth, int pDay, int pHour, int pMinute, int pSecond, int pMilliseconds );

  /**
   * Method returns the Calendar converted to a Date Object.
   * 
   * @param pCalendar Calendar Object which will be converted
   * @return Date the Object the Calendar Object was converted to.
   */
  Date toDate( Calendar pCalendar );

  /**
   * Method returns the FileTime converted to a Date object.
   * 
   * @param pFileTime FileTime object which will be converted. The parameter must not be null.
   * @return {@link Date} Object the file time was converted to. The method never returns null.
   */
  Date toDate( FileTime pFileTime );

  /**
   * Converts the given Date Strings resembling the {@link TIMESTAMP_PATTERN}. If it matches this pattern the date will
   * be returned otherwise a Exception will be thrown.
   * 
   * @param pDate the String which will be converted. The parameter must not be null.
   * @return Date object that was created from the string. The method never returns null.
   */
  Date toDate( String pDate );

  /**
   * Converts the given string into a {@link Date}. If it matches this pattern the date will be returned otherwise a
   * Exception will be thrown.
   * 
   * @param pDate the String which will be converted. The parameter must not be null.
   * @param pStrict If parameter is set to <code>true</code> then the passed string strictly has to match with pattern
   * {@link #TIMESTAMP_PATTERN}. If parameter is set to <code>false</code> the closest fitting pattern out of
   * {@link #TIMESTAMP_PATTERN}, {@link #DATE_TIME_PATTERN}, {@link #SHORT_DATE_TIME_PATTERN}, or {@link #DATE_PATTERN}
   * will be chosen.
   * @return Date object that was created from the string. The method never returns null.
   */
  Date toDate( String pDate, boolean pStrict );

  /**
   * Checks if the given Date Strings resembles the {@link TIMESTAMP_PATTERN}. If it matches this pattern true will be
   * returned otherwise false.
   * 
   * @param pDate the String which will be tested.
   * @return true if the given String can be converted into a date.
   */
  boolean isDateValid( String pDate );

  /**
   * Method returns a Date object that represents the date with given days from now.
   * 
   * @param pDays Days which will be added to the actual date.
   * @return {@link Date} Created date object. The method never returns null.
   */
  Date addDaysToActualDate( int pDays );

  /**
   * Method returns a Calendar object that represents the date with given days from now.
   * 
   * @param pDays Days which will be added to the actual date.
   * @return {@link Calendar} Created calendar object. The method never returns null.
   */
  Calendar addDaysToActualCalendar( int pDays );

  /**
   * Method creates a string out of the passed date and thereby respects the current precision of the object. This means
   * e.g. if milliseconds are 0 or seconds are not set (meaning 0) then they are not present in the string
   * representation.
   * 
   * @param pDate Date that should be converted to its string representation. The parameter must not be null.
   * @return {@link String} String representation of the passed date. The method never returns null.
   */
  String toString( Date pDate );

  /**
   * Method creates a string out of the passed date and thereby respects the current precision of the object. This means
   * e.g. if milliseconds are 0 or seconds are not set (meaning 0) then they are not present in the string
   * representation.
   * 
   * @param pCalendar Date that should be converted to its string representation. The parameter must not be null.
   * @return {@link String} String representation of the passed date. The method never returns null.
   */
  String toString( Calendar pCalendar );

  /**
   * Method returns a string representation of the date information of the passed date.
   * 
   * @param pDate Date object whose date should be returned as string. The parameter must not be null.
   * @return String String representation of the date. The returned string is formated as described by the pattern
   */
  String toDateString( Date pDate );

  /**
   * Method returns a string representation of the date information of the passed calendar.
   * 
   * @param pDate Calendar object whose date should be returned as string. The parameter must not be null.
   * @return String String representing the date of the calendar. The returned string is formated as described by the
   * pattern @see {@link #DATE_PATTERN}.
   */
  String toDateString( Calendar pDate );

  /**
   * Method returns a string representation of the date and time information of the passed date.
   * 
   * @param pDate Date object whose date should be returned as string. The parameter must not be null.
   * @return String String representation of the date. The returned string is formated as described by the pattern
   * 
   * @see {@link #DATE_TIME_PATTERN}.
   */
  String toDateTimeString( Date pDate );

  /**
   * Method returns a string representation of the date and time information of the passed calendar.
   * 
   * @param pDate Calendar object whose date should be returned as string. The parameter must not be null.
   * @return String String representing the date of the calendar. The returned string is formated as described by the
   * pattern @see {@link #DATE_TIME_PATTERN}.
   */
  String toDateTimeString( Calendar pDate );

  /**
   * Method returns a string representation of the date and time information of the passed date.
   * 
   * @param pDate Date object whose date should be returned as string. The parameter must not be null.
   * @return String String representation of the date. The returned string is formated as described by the pattern
   * 
   * @see {@link #SHORT_DATE_TIME_PATTERN}.
   */
  String toShortDateTimeString( Date pDate );

  /**
   * Method returns a string representation of the date and time information of the passed date.
   * 
   * @param pDate Calendar object whose date should be returned as string. The parameter must not be null.
   * @return String String representation of the date. The returned string is formated as described by the pattern
   * 
   * @see {@link #SHORT_DATE_TIME_PATTERN}.
   */
  String toShortDateTimeString( Calendar pDate );

  /**
   * Method returns a string representation of the timestamp information of the passed date.
   * 
   * @param pDate Date object whose date should be returned as string. The parameter must not be null.
   * @return String String representation of the date. The returned string is formated as described by the pattern
   */
  String toTimestampString( Date pDate );

  /**
   * Method returns a string representation of the timestamp information of the passed calendar.
   * 
   * @param pDate Calendar object whose date should be returned as string. The parameter must not be null.
   * @return String String representing the date of the calendar. The returned string is formated as described by the
   * pattern @see {@link #TIMESTAMP_PATTERN}.
   */
  String toTimestampString( Calendar pDate );

  /**
   * Method returns a date-time string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateTimeString( Date pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a date-time string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateTimeString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a date-time string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateTimeString( Date pDate, DateFormatStyle pStyle );

  /**
   * Method returns a date-time string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateTimeString( Calendar pDate, DateFormatStyle pStyle );

  /**
   * Method returns a date-only string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateOnlyString( Date pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a date-only string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateOnlyString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a date-only string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateOnlyString( Date pDate, DateFormatStyle pStyle );

  /**
   * Method returns a date-only string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedDateOnlyString( Calendar pDate, DateFormatStyle pStyle );

  /**
   * Method returns a time-only string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedTimeOnlyString( Date pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a time-only string representation of the passed date using the provided locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pLocale Locale that should be used to format the date. The parameter must not be null.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedTimeOnlyString( Calendar pDate, Locale pLocale, DateFormatStyle pStyle );

  /**
   * Method returns a time-only string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedTimeOnlyString( Date pDate, DateFormatStyle pStyle );

  /**
   * Method returns a time-only string representation of the passed date using the current locale.
   * 
   * @param pDate Date which will be formatted as string. The parameter may be null. In this case an empty string will
   * be returned.
   * @param pStyle Style that should be used to format the date. The parameter must not be null.
   * @return {@link String} String representing the passed date. The method never returns null.
   */
  String toLocalizedTimeOnlyString( Calendar pDate, DateFormatStyle pStyle );

  /**
   * Method returns a string representation of the passed calendar using the passed pattern.
   * 
   * @param pDate Date object whose date should be returned as string. The parameter must not be null.
   * @param pPattern Pattern that should be used to format the passed calendar. The parameter must not be null.
   * @return String String representing the date of the calendar. The returned string is formated as described by the
   * pattern
   */
  String toString( Date pDate, String pPattern );

  /**
   * Method returns a string representation of the passed calendar using the passed pattern.
   * 
   * @param pDate Calendar object whose date should be returned as string. The parameter must not be null.
   * @param pPattern Pattern that should be used to format the passed calendar. The parameter must not be null.
   * @return String String representing the date of the calendar. The returned string is formated as described by the
   * pattern @see {@link #TIMESTAMP_PATTERN}.
   */
  String toString( Calendar pDate, String pPattern );

  /**
   * Method returns the difference between the given date and the current date in days.
   * 
   * @param pDate Date object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of days between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInDays( Date pDate );

  /**
   * Method returns the difference between the given date and the current date in days.
   * 
   * @param pDate Calendar object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of days between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInDays( Calendar pDate );

  /**
   * Method returns the difference between the given date and the current date in hours.
   * 
   * @param pDate Date object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of hours between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInHours( Date pDate );

  /**
   * Method returns the difference between the given date and the current date in hours.
   * 
   * @param pDate Calendar object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of hours between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInHours( Calendar pDate );

  /**
   * Method returns the difference between the given date and the current date in minutes.
   * 
   * @param pDate Date object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of minutes between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInMinutes( Date pDate );

  /**
   * Method returns the difference between the given date and the current date in minutes.
   * 
   * @param pDate Calendar object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of minutes between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInMinutes( Calendar pDate );

  /**
   * Method returns the difference between the given date and the current date in seconds.
   * 
   * @param pDate Date object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of seconds between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInSeconds( Date pDate );

  /**
   * Method returns the difference between the given date and the current date in seconds.
   * 
   * @param pDate Calendar object whose time period to the current date should be calculated. The parameter must not be
   * null.
   * @return int Number of seconds between the current date and the given date. If the passed date is in the future then
   * the method will return a positive value. If the passed date is in the past then a negative value will be returned.
   */
  int calculateTimeDifferenceInSeconds( Calendar pDate );

  /**
   * Method returns the Date converted to a Calendar object.
   * 
   * @param pDate Date object which will be converted. The parameter must not be null.
   * @return {@link Calendar} Object the date was converted to. The method never returns null.
   */
  Calendar toCalendar( Date pDate );

  /**
   * Method returns the FileTime converted to a Calendar object.
   * 
   * @param pFileTime FileTime object which will be converted. The parameter must not be null.
   * @return {@link Calendar} Object the file time was converted to. The method never returns null.
   */
  Calendar toCalendar( FileTime pFileTime );

  /**
   * Method returns the string converted to a Calendar object.
   * 
   * @param pDateString String object which will be converted. The parameter must not be null.
   * @return {@link Calendar} Object the date string was converted to. The method never returns null.
   */
  Calendar toCalendar( String pDateString );

  /**
   * Converts the given string into a {@link Calendar}.
   * 
   * @param pDate the String which will be converted. The parameter must not be null.
   * @param pStrict If parameter is set to <code>true</code> then the passed string strictly has to match with pattern
   * {@link #TIMESTAMP_PATTERN}. If parameter is set to <code>false</code> the closest fitting pattern out of
   * {@link #TIMESTAMP_PATTERN}, {@link #DATE_TIME_PATTERN}, {@link #SHORT_DATE_TIME_PATTERN}, or {@link #DATE_PATTERN}
   * will be chosen.
   * @return Date object that was created from the string. The method never returns null.
   */
  Calendar toCalendar( String pDate, boolean pStrict );
}

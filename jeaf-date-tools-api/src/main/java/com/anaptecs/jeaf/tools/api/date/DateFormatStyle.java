/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.date;

import java.text.DateFormat;

public enum DateFormatStyle {
  SHORT(DateFormat.SHORT, DateFormat.SHORT), MEDIUM(DateFormat.MEDIUM, DateFormat.MEDIUM), LONG(DateFormat.LONG,
      DateFormat.MEDIUM), FULL(DateFormat.FULL, DateFormat.MEDIUM);

  private int dateFormat;

  private int timeFormat;

  private DateFormatStyle( int pDateFormatStyle, int pTimeFormatStyle ) {
    dateFormat = pDateFormatStyle;
    timeFormat = pTimeFormatStyle;
  }

  public int getDateFormatStyle( ) {
    return dateFormat;
  }

  public int getTimeFormatStyle( ) {
    return timeFormat;
  }
}

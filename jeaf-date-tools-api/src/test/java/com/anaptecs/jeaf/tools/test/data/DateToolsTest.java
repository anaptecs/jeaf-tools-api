/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;

import com.anaptecs.jeaf.tools.api.date.DateFormatStyle;
import org.junit.jupiter.api.Test;

public class DateToolsTest {
  @Test
  public void testDateFormatStyle( ) {
    assertEquals(DateFormat.SHORT, DateFormatStyle.SHORT.getDateFormatStyle());
    assertEquals(DateFormat.SHORT, DateFormatStyle.SHORT.getTimeFormatStyle());

    assertEquals(DateFormat.MEDIUM, DateFormatStyle.MEDIUM.getDateFormatStyle());
    assertEquals(DateFormat.MEDIUM, DateFormatStyle.MEDIUM.getTimeFormatStyle());

    assertEquals(DateFormat.LONG, DateFormatStyle.LONG.getDateFormatStyle());
    assertEquals(DateFormat.MEDIUM, DateFormatStyle.LONG.getTimeFormatStyle());

    assertEquals(DateFormat.FULL, DateFormatStyle.FULL.getDateFormatStyle());
    assertEquals(DateFormat.MEDIUM, DateFormatStyle.FULL.getTimeFormatStyle());

    // Ensure SemVer compatibility
    List<DateFormatStyle> lLiterals = Arrays.asList(DateFormatStyle.values());
    assertTrue(lLiterals.contains(DateFormatStyle.SHORT));
    assertTrue(lLiterals.contains(DateFormatStyle.MEDIUM));
    assertTrue(lLiterals.contains(DateFormatStyle.LONG));
    assertTrue(lLiterals.contains(DateFormatStyle.FULL));
    assertEquals(4, lLiterals.size());
  }
}

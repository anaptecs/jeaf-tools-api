/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.performance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.anaptecs.jeaf.tools.api.performance.StopwatchResult;
import com.anaptecs.jeaf.tools.api.performance.TimePrecision;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StopwatchTests {
  @Test
  @Order(10)
  public void testStopwatchResult( ) {
    StopwatchResult lStopwatchResult = new StopwatchResult(1234, TimePrecision.MILLIS, 37);
    assertNotNull(lStopwatchResult);
    assertEquals(1234, lStopwatchResult.getDuration());
    assertEquals(TimePrecision.MILLIS, lStopwatchResult.getUnit());
    assertEquals(37, lStopwatchResult.getTransactions());
    double lExpectedTPS = TimePrecision.MILLIS.getTPSFactor() / (1234.0 / 37);
    double lTPSDiff = Math.abs(lExpectedTPS - lStopwatchResult.getTransactionsPerSecond());
    assertTrue(lTPSDiff < 0.0001);

    lStopwatchResult = new StopwatchResult(127832, TimePrecision.NANOS, 12345);
    assertNotNull(lStopwatchResult);
    assertEquals(127832, lStopwatchResult.getDuration());
    assertEquals(TimePrecision.NANOS, lStopwatchResult.getUnit());
    lExpectedTPS = TimePrecision.NANOS.getTPSFactor() / (127832.0 / 12345);
    lTPSDiff = Math.abs(lExpectedTPS - lStopwatchResult.getTransactionsPerSecond());
    assertTrue(lTPSDiff < 0.0001);

    lStopwatchResult = new StopwatchResult(127832, TimePrecision.NANOS, -2);
    assertEquals(0, lStopwatchResult.getTransactionsPerSecond());
    lStopwatchResult = new StopwatchResult(127832, TimePrecision.NANOS, 0);
    assertEquals(0, lStopwatchResult.getTransactionsPerSecond());

    // Test error handling.
    try {
      new StopwatchResult(1234, null, 5009);
      fail("Exception expected.");
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pUnit' must not be null.", e.getMessage());
    }
  }

  @Test
  @Order(20)
  public void testTimePrecision( ) {
    // Test milliseconds
    assertEquals(1000000, TimePrecision.MILLIS.getDurationDivisor());
    assertEquals(1000, TimePrecision.MILLIS.getTPSFactor());
    assertEquals("ms", TimePrecision.MILLIS.getUnit());

    // Test nanoseconds
    assertEquals(1, TimePrecision.NANOS.getDurationDivisor());
    assertEquals(1000000000, TimePrecision.NANOS.getTPSFactor());
    assertEquals("ns", TimePrecision.NANOS.getUnit());

    // Check for unexpected literals for backward compatibility.
    for (TimePrecision lPrecision : TimePrecision.values()) {
      switch (lPrecision) {
        case MILLIS:
        case NANOS:
          // Nothing to do as this are the expected literals.
          break;

        default:
          fail("Unexpected literal " + lPrecision.name());
      }
    }
  }
}

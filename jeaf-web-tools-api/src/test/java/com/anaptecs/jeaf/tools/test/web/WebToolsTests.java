/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.anaptecs.jeaf.tools.api.ToolsMessages;
import com.anaptecs.jeaf.tools.api.http.QueryParameter;
import com.anaptecs.jeaf.tools.api.http.HTTPStatusCode;
import com.anaptecs.jeaf.tools.api.http.HTTPStatusCode.Category;
import com.anaptecs.jeaf.tools.api.http.URLDetails;
import com.anaptecs.jeaf.tools.api.http.XFrameOptions;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

import junit.framework.TestCase;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebToolsTests {
  @Test
  @Order(10)
  public void testQueryParameter( ) {
    QueryParameter lQueryParameter = new QueryParameter("name", "value");
    assertEquals("name", lQueryParameter.getName());
    assertEquals("value", lQueryParameter.getValue());

    lQueryParameter = new QueryParameter("name", null);
    assertEquals("name", lQueryParameter.getName());
    assertNull(lQueryParameter.getValue());

    // Test error handling
    try {
      new QueryParameter(null, "value");
      fail("Exception expected.");
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pName' must not be null.", e.getMessage());
    }
    try {
      new QueryParameter(null, null);
      fail("Exception expected.");
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pName' must not be null.", e.getMessage());
    }
  }

  @Test
  @Order(20)
  public void testURLDetails( ) throws Exception {
    String lURLString =
        "https://FFC-powerpoint.officeapps.live.com/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Flocalhost%3A8080%2Fweeasy%2F1.3%2Fdesktop%2Fwopi%2Ffiles%2F1-----B-----N5-&New=1&rs=de-DE&ui=de-DE&IsLicensedUser=0&PowerPointView=EditView";
    URLDetails lURLDetails = new URLDetails(lURLString);

    // Check standard info
    TestCase.assertEquals("Wrong protocol", "https", lURLDetails.getProtocol());
    TestCase.assertEquals("Wrong host", "FFC-powerpoint.officeapps.live.com", lURLDetails.getHost());
    TestCase.assertEquals("Wrong port", 443, lURLDetails.getPort());
    TestCase.assertEquals("Wrong path", "/p/PowerPointFrame.aspx", lURLDetails.getPath());
    TestCase.assertEquals("Wrong query",
        "WOPISrc=http%3A%2F%2Flocalhost%3A8080%2Fweeasy%2F1.3%2Fdesktop%2Fwopi%2Ffiles%2F1-----B-----N5-&New=1&rs=de-DE&ui=de-DE&IsLicensedUser=0&PowerPointView=EditView",
        lURLDetails.getQuery());
    TestCase.assertEquals("Wrong URL", lURLString, lURLDetails.getURLAsString());
    TestCase.assertNotNull("URL object not returned", lURLDetails.getURL());

    // Check URL parameters.
    TestCase.assertEquals("Wrong number of parameters", 6, lURLDetails.getQueryParameters().size());

    QueryParameter lQueryParameter = lURLDetails.getQueryParameter("WOPISrc");
    TestCase.assertEquals("Wrong parameter name", "WOPISrc", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value",
        "http%3A%2F%2Flocalhost%3A8080%2Fweeasy%2F1.3%2Fdesktop%2Fwopi%2Ffiles%2F1-----B-----N5-",
        lQueryParameter.getValue());

    lQueryParameter = lURLDetails.getQueryParameter("New");
    TestCase.assertEquals("Wrong parameter name", "New", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value", "1", lQueryParameter.getValue());

    lQueryParameter = lURLDetails.getQueryParameter("rs");
    TestCase.assertEquals("Wrong parameter name", "rs", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value", "de-DE", lQueryParameter.getValue());

    lQueryParameter = lURLDetails.getQueryParameter("IsLicensedUser");
    TestCase.assertEquals("Wrong parameter name", "IsLicensedUser", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value", "0", lQueryParameter.getValue());

    lQueryParameter = lURLDetails.getQueryParameter("PowerPointView");
    TestCase.assertEquals("Wrong parameter name", "PowerPointView", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value", "EditView", lQueryParameter.getValue());

    lQueryParameter = lURLDetails.getQueryParameter("ui");
    TestCase.assertEquals("Wrong parameter name", "ui", lQueryParameter.getName());
    TestCase.assertEquals("Wrong parameter value", "de-DE", lQueryParameter.getValue());
    TestCase.assertTrue(lURLDetails.hasQueryParameter("ui"));
    TestCase.assertFalse(lURLDetails.hasQueryParameter("uiX"));

    lURLDetails = new URLDetails("https://example.org/?a=1&b=2&c&d=4");
    TestCase.assertEquals(lURLDetails.getQueryParameter("a").getValue(), "1");
    TestCase.assertEquals(lURLDetails.getQueryParameter("b").getValue(), "2");
    TestCase.assertNull(lURLDetails.getQueryParameter("c").getValue());
    TestCase.assertEquals(lURLDetails.getQueryParameter("d").getValue(), "4");

    // Check creation of URLs with invalid URLs
    try {
      new URLDetails("Invalid URL");
      TestCase.fail("Expecting exception");
    }
    catch (IOException e) {
      // Nothing to do. Exception is expected to happen.
    }

    lURLDetails = new URLDetails("http://www.heise.de");
    assertEquals(80, lURLDetails.getPort());
    assertEquals(0, lURLDetails.getQueryParameters().size());

    lURLDetails = new URLDetails("http://localhost:8080");
    assertEquals(8080, lURLDetails.getPort());
    assertEquals(0, lURLDetails.getQueryParameters().size());

  }

  @Test
  @Order(30)
  public void testStatusCode( ) {
    assertEquals(200, HTTPStatusCode.OK.getCode());
    assertEquals(HTTPStatusCode.Category.SUCCESSFUL, HTTPStatusCode.OK.getCategory());
    assertEquals("OK", HTTPStatusCode.OK.getName());

    HTTPStatusCode lStatusCode = HTTPStatusCode.fromStatusCode(200);
    assertEquals(HTTPStatusCode.OK, lStatusCode);

    assertEquals(Category.INFORMATIONAL, HTTPStatusCode.Category.fromStatusCode(100));
    assertEquals(Category.SUCCESSFUL, HTTPStatusCode.Category.fromStatusCode(200));
    assertEquals(Category.REDIRECTION, HTTPStatusCode.Category.fromStatusCode(303));
    assertEquals(Category.CLIENT_ERROR, HTTPStatusCode.Category.fromStatusCode(404));
    assertEquals(Category.SERVER_ERROR, HTTPStatusCode.Category.fromStatusCode(500));
    assertEquals(Category.OTHER, HTTPStatusCode.Category.fromStatusCode(998));

    // Test usage of invalid status codes.
    try {
      HTTPStatusCode.fromStatusCode(999);
      fail("Exception expected when using unoffical status code.");
    }
    catch (JEAFSystemException e) {
      assertEquals(ToolsMessages.INVALID_HTTP_STATUS_CODE, e.getErrorCode());
    }

    // 1xx informational
    assertTrue(HTTPStatusCode.isOfficalStatusCode(100));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(101));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(102));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(103));

    // 2xx success
    assertTrue(HTTPStatusCode.isOfficalStatusCode(200));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(201));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(202));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(203));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(204));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(205));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(206));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(207));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(208));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(226));

    // 3xx redirection
    assertTrue(HTTPStatusCode.isOfficalStatusCode(300));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(301));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(302));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(303));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(304));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(305));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(306));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(307));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(308));

    // 4xx client errors
    assertTrue(HTTPStatusCode.isOfficalStatusCode(400));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(401));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(402));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(403));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(404));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(405));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(406));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(407));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(408));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(409));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(410));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(411));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(412));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(413));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(414));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(415));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(416));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(417));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(418));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(421));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(422));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(423));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(424));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(425));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(426));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(428));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(429));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(431));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(451));

    // 5xx server errors
    assertTrue(HTTPStatusCode.isOfficalStatusCode(500));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(501));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(502));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(503));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(504));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(505));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(506));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(507));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(508));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(510));
    assertTrue(HTTPStatusCode.isOfficalStatusCode(511));

    // Test detection of unofficial status codes.
    assertFalse(HTTPStatusCode.isOfficalStatusCode(999));

    // Check overall amount of status codes.
    assertEquals(63, HTTPStatusCode.values().length);
  }

  @Test
  @Order(40)
  public void testXFrameOptions( ) {

    // Test lookup of XFrameOptions from string.
    assertEquals(XFrameOptions.NONE, XFrameOptions.fromHTTPHeader(null));
    assertEquals(XFrameOptions.NONE, XFrameOptions.fromHTTPHeader("invalid header field"));

    assertEquals(XFrameOptions.DENY, XFrameOptions.fromHTTPHeader("deny"));
    assertEquals(XFrameOptions.DENY, XFrameOptions.fromHTTPHeader("DENY"));
    assertEquals(XFrameOptions.DENY, XFrameOptions.fromHTTPHeader("Deny"));

    assertEquals(XFrameOptions.SAMEORIGIN, XFrameOptions.fromHTTPHeader("SAMEORIGIN"));
    assertEquals(XFrameOptions.SAMEORIGIN, XFrameOptions.fromHTTPHeader("sameorigin"));
    assertEquals(XFrameOptions.SAMEORIGIN, XFrameOptions.fromHTTPHeader("SameOrigin"));

    // ALLOW_FROM always requires some URI thats why the plain string will not be accepted.
    assertEquals(XFrameOptions.NONE, XFrameOptions.fromHTTPHeader("ALLOW-FROM"));
    assertEquals(XFrameOptions.ALLOW_FROM, XFrameOptions.fromHTTPHeader("ALLOW-FROM https://example.com"));
    assertEquals(XFrameOptions.ALLOW_FROM, XFrameOptions.fromHTTPHeader("allow-from https://example.com"));
    assertEquals(XFrameOptions.ALLOW_FROM, XFrameOptions.fromHTTPHeader("Allow-FROM https://example.com"));
  }
}

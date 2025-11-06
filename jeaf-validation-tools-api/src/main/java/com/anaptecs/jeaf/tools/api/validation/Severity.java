/**
 * Copyright 2004 - 2018 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.validation;

import javax.validation.Payload;

/**
 * Class is intended to be used as indicator of the severity of failed validation checks.
 * 
 * @author JEAF Development Team
 * @version 1.3
 */
public class Severity {
  private Severity( ) {
  }

  public static class Info implements Payload {
  }

  public static class Warning implements Payload {
  }

  public static class Error implements Payload {
  }
}

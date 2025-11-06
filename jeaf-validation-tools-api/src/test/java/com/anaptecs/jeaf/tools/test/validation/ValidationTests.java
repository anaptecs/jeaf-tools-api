/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.validation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.anaptecs.jeaf.tools.api.validation.Severity;
import com.anaptecs.jeaf.tools.api.validation.ValidationResult;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidationTests {
  @Test
  @Order(10)
  public void testValidationSeverity( ) {
    assertNotNull(new Severity.Info());
    assertNotNull(new Severity.Warning());
    assertNotNull(new Severity.Error());
  }

  @Test
  void testValidationResult( ) {
    Object lValidatedObject = new Object();
    ValidationResult<Object> lValidationResult = new ValidationResult<>(lValidatedObject, null);
    assertEquals(lValidatedObject, lValidationResult.getValidatedObject());
    assertEquals(false, lValidationResult.hasConstrainViolations());
    assertEquals(0, lValidationResult.getConstraintViolations().size());

    Collection<ConstraintViolation<Object>> lViolations = new ArrayList<>();
    MyConstraintViolation<Object> lViolation = new MyConstraintViolation<Object>();
    lViolations.add(lViolation);

    lValidationResult = new ValidationResult<Object>(lValidatedObject, lViolations);
    assertEquals(lValidatedObject, lValidationResult.getValidatedObject());
    assertEquals(true, lValidationResult.hasConstrainViolations());
    assertEquals(1, lValidationResult.getConstraintViolations().size());
    assertEquals(lViolation, lValidationResult.getConstraintViolations().get(0));

    // Check null handling
    try {
      new ValidationResult<>(null, null);
      fail("Expected exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("'pValidatedObject' must not be null.", e.getMessage());
    }
  }
}

class MyConstraintViolation<T> implements ConstraintViolation<T> {

  @Override
  public String getMessage( ) {
    return null;
  }

  @Override
  public String getMessageTemplate( ) {
    return null;
  }

  @Override
  public T getRootBean( ) {
    return null;
  }

  @Override
  public Class<T> getRootBeanClass( ) {
    return null;
  }

  @Override
  public Object getLeafBean( ) {
    return null;
  }

  @Override
  public Object[] getExecutableParameters( ) {
    return null;
  }

  @Override
  public Object getExecutableReturnValue( ) {
    return null;
  }

  @Override
  public Path getPropertyPath( ) {
    return null;
  }

  @Override
  public Object getInvalidValue( ) {
    return null;
  }

  @Override
  public ConstraintDescriptor<?> getConstraintDescriptor( ) {
    return null;
  }

  @Override
  public <U> U unwrap( Class<U> pType ) {
    return null;
  }

}

/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolation;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class represents the result of a constraint check.
 * 
 * @author JEAF Development Team
 */
public class ValidationResult<T> {
  /**
   * Object that was validated.
   */
  private final T validatedObject;

  /**
   * List with all constraint checks the failed during the validation process.
   */
  private final List<ConstraintViolation<T>> constraintViolations;

  /**
   * Initialize object.
   * 
   * @param pValidatedObject Object that should be was validated. The parameter must not be null.
   * @param pConstraintViolations May be found constraint violations. The parameter may be null.
   */
  public ValidationResult( T pValidatedObject, Collection<ConstraintViolation<T>> pConstraintViolations ) {
    Check.checkInvalidParameterNull(pValidatedObject, "pValidatedObject");
    validatedObject = pValidatedObject;

    if (pConstraintViolations != null) {
      constraintViolations = Collections.unmodifiableList(new ArrayList<>(pConstraintViolations));
    }
    else {
      constraintViolations = Collections.emptyList();
    }
  }

  /**
   * Method returns the object that was validated.
   * 
   * @return Object that was validated. The method never returns null..
   */
  public T getValidatedObject( ) {
    return validatedObject;
  }

  /**
   * Method returns all constraint violations that were detected during a constraint check.
   * 
   * @return {@link List} List with all found constraint violations. In case that none were found an empty {@link List}
   * will be returned. The method never returns null.
   */
  public List<ConstraintViolation<T>> getConstraintViolations( ) {
    return constraintViolations;
  }

  /**
   * Method checks if constraint violations where detected during constraint check or not.
   * 
   * @return Method returns <code>true</code> if constraint violations where found and <code>false</code> otherwise.
   */
  public boolean hasConstrainViolations( ) {
    return !constraintViolations.isEmpty();
  }
}

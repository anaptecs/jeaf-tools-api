/**
 * Copyright 2004 - 2018 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines helper methods for Java Bean validation.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public interface ValidationTools {
  /**
   * Configured implementation of validation tools.
   */
  static final ValidationTools VALIDATION_TOOLS = ToolsLoader.getTools(ValidationTools.class);

  /**
   * Method returns the configured implementation of the Validation Tools.
   * 
   * @return {@link ValidationTools} Configured implementation of validation tools. The method never returns null.
   */
  static ValidationTools getValidationTools( ) {
    return VALIDATION_TOOLS;
  }

  /**
   * Method checks if the passed method requires validation of its request parameters.
   * 
   * @param pMethod Method that should be checked. The parameter must not be null.
   * @return boolean Method returns true if a validation for the parameters of the method is required and false
   * otherwise.
   */
  boolean requiresRequestValidation( Method pMethod );

  /**
   * Method checks if the passed method requires validation of its response.
   * 
   * @param pMethod Method that should be checked. The parameter must not be null.
   * @return boolean Method returns true if a validation for the response of the method is required and false otherwise.
   */
  boolean requiresResponseValidation( Method pMethod );

  /**
   * Method checks if the passed field requires validation of its response.
   * 
   * @param pField Field that should be checked. The parameter must not be null.
   * @return boolean Method returns true if a validation for the field is required and false otherwise.
   */
  boolean requiresValidation( Field pField );

  /**
   * Method checks if the passed annotation is a validation annotation.
   * 
   * @param pAnnotation Validation that should be checked. The parameter must not be null.
   * @return boolean true if the annotation is a validation annotation and false otherwise.
   */
  boolean isValidationAnnotation( Annotation pAnnotation );

  /**
   * Method checks if the passed list contains at least one validation annotations.
   * 
   * @param pAnnotations List of annotations that should be checked. The parameter must not be null.
   * @return boolean true if at least one annotation inside the list is a validation annotation.
   */
  boolean containsValidationAnnotation( List<Annotation> pAnnotations );

  /**
   * Method checks if the passed array contains at least one validation annotations.
   * 
   * @param pAnnotations Array of annotations that should be checked. The parameter must not be null.
   * @return boolean true if at least one annotation inside the array is a validation annotation.
   */
  boolean containsValidationAnnotation( Annotation[] pAnnotations );

  /**
   * Method checks the constraints on the passed object.
   * 
   * @param pObject Object whose constraints should be checked. The parameter must not be null.
   * @return {@link ValidationResult} Object representing the result of the constraint validation. The method never
   * returns null.
   */
  <T> ValidationResult<T> validate( T pObject );

  /**
   * Method checks the constraints on the passed object.
   * 
   * @param pObject Object whose constraints should be checked. The parameter must not be null.
   * @return {@link Set} Set containing all constraint violations. The method never returns null.
   */
  <T> Set<ConstraintViolation<T>> validateObject( T pObject );

  /**
   * Method enforces that the passed object is valid. In case that the object is not valid a
   * ConstraintViolationException will be thrown.
   * 
   * @param pObject Object that should be validated. The parameter must not be null
   * @throws ConstraintViolationException Exception describing which violations failed.
   */
  void enforceObjectValidation( Object pObject ) throws ConstraintViolationException;

  /**
   * Method checks the constraints of all objects that are inside the passed collection.
   * 
   * @param pObjects Collection with all objects whose constraints should be checked. The parameter may be null.
   * @return {@link Set} Set with all constraint violations that were found for the passed objects. The method never
   * returns null.
   */
  <T> Set<ConstraintViolation<T>> validateObjects( Collection<T> pObjects );

  /**
   * Method checks the constraints of all objects that are inside the passed array.
   * 
   * @param pObjects Array with all objects whose constraints should be checked. The parameter may be null.
   * @return {@link Set} Set with all constraint violations that were found for the passed objects. The method never
   * returns null.
   */
  <T> Set<ConstraintViolation<T>> validateObjects( T[] pObjects );

  /**
   * Validates all constraints placed on the parameters of the given method.
   *
   * @param <T> the type hosting the method to validate
   * @param pObject the object on which the method to validate is invoked
   * @param pMethod the method for which the parameter constraints is validated
   * @param pParameterValues the values provided by the caller for the given method's parameters
   * @param pGroups the group or list of groups targeted for validation (defaults to {@link Default})
   * @return a set with the constraint violations caused by this validation; will be empty if no error occurs, but never
   * {@code null}
   * @throws IllegalArgumentException if {@code null} is passed for any of the parameters or if parameters don't match
   * with each other
   * @throws ValidationException if a non recoverable error happens during the validation process
   * 
   * @see ExecutableValidator#validateConstructorParameters(java.lang.reflect.Constructor, Object[], Class...)
   */
  <T> Set<ConstraintViolation<T>> validateParameters( T pObject, Method pMethod, Object[] pParameterValues,
      Class<?>... pGroups );

  /**
   * Method validates the passed parameters according to the defined bean validation. If at least one validation fails
   * then a ConstraintViolationException will be thrown.
   * 
   * @param <T> the type hosting the method to validate
   * @param pObject the object on which the method to validate is invoked
   * @param pMethod the method for which the parameter constraints is validated
   * @param pParameterValues the values provided by the caller for the given method's parameters
   * @param pGroups the group or list of groups targeted for validation (defaults to {@link Default})
   * @return a set with the constraint violations caused by this validation; will be empty if no error occurs, but never
   * {@code null}
   * 
   * @see ExecutableValidator#validateReturnValue(Object, Method, Object, Class...)
   */
  <T> void enforceParameterValidation( T pObject, Method pMethod, Object[] pParameterValues, Class<?>... pGroups )
    throws ConstraintViolationException;

  /**
   * Validates all return value constraints of the given method.
   *
   * @param <T> the type hosting the method to validate
   * @param pObject the object on which the method to validate is invoked
   * @param pMethod the method for which the return value constraints is validated
   * @param pReturnValue the value returned by the given method
   * @param pGroups the group or list of groups targeted for validation (defaults to {@link Default})
   * @return a set with the constraint violations caused by this validation; will be empty if no error occurs, but never
   * {@code null}
   * @throws IllegalArgumentException if {@code null} is passed for any of the object, method or groups parameters or if
   * parameters don't match with each other
   * @throws ValidationException if a non recoverable error happens during the validation process
   */
  <T> Set<ConstraintViolation<T>> validateReturnValue( T pObject, Method pMethod, Object pReturnValue,
      Class<?>... pGroups );

  /**
   * Method validates the passed return value according to the defined bean validation. If at least one validation fails
   * then a ConstraintViolationException will be thrown.
   * 
   * @param <T>
   * @param pObject
   * @param pMethod
   * @param pReturnValue
   * @param pGroups
   */
  <T> void enforceReturnValueValidation( T pObject, Method pMethod, Object pReturnValue, Class<?>... pGroups );

  /**
   * Method returns the available Java Bean validator implementation.
   * 
   * @return {@link Validator} Validator implementation that can be used for validations. The method never returns null.
   */
  Validator getValidator( );
}

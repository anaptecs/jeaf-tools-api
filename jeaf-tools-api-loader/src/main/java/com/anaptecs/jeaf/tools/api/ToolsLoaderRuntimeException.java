/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

/**
 * Class implements exceptions that occur during startup of JEAF Tools.
 * 
 * @author JEAF Development Team
 */
public class ToolsLoaderRuntimeException extends RuntimeException {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  ToolsLoaderRuntimeException( String pMessage, Throwable pCause, boolean pEnableSuppression,
      boolean pWritableStackTrace ) {
    super(pMessage, pCause, pEnableSuppression, pWritableStackTrace);
  }

  ToolsLoaderRuntimeException( String pMessage, Throwable pCause ) {
    super(pMessage, pCause);
  }

  ToolsLoaderRuntimeException( String pMessage ) {
    super(pMessage);
  }

  ToolsLoaderRuntimeException( Throwable pCause ) {
    super(pCause);
  }
}

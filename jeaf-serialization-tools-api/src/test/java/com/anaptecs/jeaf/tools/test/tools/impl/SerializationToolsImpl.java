/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.io.Serializable;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.serialization.SerializationTools;

@ToolsImplementation(toolsInterface = SerializationTools.class)
public class SerializationToolsImpl implements SerializationTools {

  @Override
  public byte[] serializeObject( Serializable pObject ) {
    return null;
  }

  @Override
  public <T extends Serializable> T deserializeObject( byte[] pBytes, Class<T> pType ) {
    return null;
  }
}

/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.serialization;

import java.io.Serializable;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines methods of tools class that makes serialization and deserialization of objects as easy as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface SerializationTools {
  /**
   * Configured implementation of serialization tools.
   */
  static final SerializationTools SERIALIZATION_TOOLS = ToolsLoader.getTools(SerializationTools.class);

  /**
   * Method returns the configured implementation of the Serialization Tools.
   * 
   * @return {@link SerializationTools} Configured implementation of serialization tools. The method never returns null.
   */
  static SerializationTools getSerializationTools( ) {
    return SERIALIZATION_TOOLS;
  }

  /**
   * Method serializes the passed object to the returned byte[].
   * 
   * @param pObject Object that should be serialized. The parameter may be null.
   * @return byte[] Byte array representing the serialized object. The method returns null if the parameter is null.
   */
  byte[] serializeObject( Serializable pObject );

  /**
   * Method deserializes the passed byte[] to an object of the passed type.
   * 
   * @param <T>
   * @param pBytes Byte array that should be used to deserialize the object. The parameter may be null.
   * @param pType Class of the expected object to be returned. The parameter must not be null.
   * @return T Object that was deserialized from the passed bytes. The method returns null if null was passed.
   */
  <T extends Serializable> T deserializeObject( byte[] pBytes, Class<T> pType );
}

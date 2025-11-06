/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.encoding;

import java.nio.charset.Charset;

import com.anaptecs.jeaf.tools.annotations.EncodingToolsConfig;
import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Encoding tools provide information about the configured encoding that is used among all JEAF Tools. Encoding can be
 * configured using {@link EncodingToolsConfig}
 * 
 * @author JEAF Development Team
 */
public interface EncodingTools {
  /**
   * Configured implementation of encoding tools.
   */
  static final EncodingTools ENCODING_TOOLS = ToolsLoader.getTools(EncodingTools.class);

  /**
   * Method returns the configured implementation of the Encoding Tools.
   * 
   * @return {@link EncodingTools} Configured implementation of encoding tools. The method never returns null.
   */
  static EncodingTools getEncodingTools( ) {
    return ENCODING_TOOLS;
  }

  /**
   * Method returns the default charset / encoding as it is configured for JEAF Tools through annotation
   * {@link EncodingToolsConfig}
   * 
   * @return {@link Charset} Charset that is defined as default for JEAF Tools. The method never returns null.
   */
  Charset getDefaultCharset( );

  /**
   * Method returns the name of the default charset as it is defined.
   * 
   * @return String Name of the defined default charset. The method never returns null.
   */
  String getDefaultCharsetName( );
}

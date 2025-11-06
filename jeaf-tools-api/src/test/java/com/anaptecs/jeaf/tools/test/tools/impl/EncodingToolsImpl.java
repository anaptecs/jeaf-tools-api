/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.nio.charset.Charset;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.encoding.EncodingTools;

@ToolsImplementation(toolsInterface = EncodingTools.class)
public class EncodingToolsImpl implements EncodingTools {

  @Override
  public Charset getDefaultCharset( ) {
    return null;
  }

  @Override
  public String getDefaultCharsetName( ) {
    return null;
  }

}

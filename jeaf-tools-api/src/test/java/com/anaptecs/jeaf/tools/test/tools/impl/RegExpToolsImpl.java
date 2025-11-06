/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.regexp.RegExpTools;

@ToolsImplementation(toolsInterface = RegExpTools.class)
public class RegExpToolsImpl implements RegExpTools {

  @Override
  public boolean matchesPattern( String pCharacters, String pRegExpPattern ) {
    return false;
  }

}

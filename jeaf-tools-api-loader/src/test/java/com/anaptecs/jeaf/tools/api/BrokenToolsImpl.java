/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;

@ToolsImplementation(toolsInterface = BrokenTools.class)
public class BrokenToolsImpl implements BrokenTools {
  public BrokenToolsImpl( ) {
    throw new NullPointerException("I'm so broken");
  }

  @Override
  public void letsBreakIt( ) {
  }
}

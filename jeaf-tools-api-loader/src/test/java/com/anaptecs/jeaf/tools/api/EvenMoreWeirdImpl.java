/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;

@ToolsImplementation(toolsInterface = WeirdTools.class)
public class EvenMoreWeirdImpl implements WeirdTools {

  @Override
  public void doSomethingWeird( ) {
  }

}

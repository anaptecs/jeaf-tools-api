/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.regexp;

import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines all helper methods concerning regular expressions. As JEAF supports multiple runtime environments
 * and some of them as Google Web Toolkit have limitations in some areas or require special implementations tools
 * classes are also abstracted by an interface.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface RegExpTools {
  /**
   * Configured implementation of regexp tools.
   */
  static final RegExpTools REG_EXP_TOOLS = ToolsLoader.getTools(RegExpTools.class);

  /**
   * Method returns the configured implementation of the RegExp Tools.
   * 
   * @return {@link RegExpTools} Configured implementation of regular expression tools. The method never returns null.
   */
  static RegExpTools getRegExpTools( ) {
    return REG_EXP_TOOLS;
  }

  /**
   * Method checks whether the passed characters match to the passed regular expression pattern. Thereby the caller has
   * to keep in mind that there may be differences in the syntax of the regular expressions depending on the runtime
   * environment.
   * 
   * @param pCharacters Characters that should be checked against the passed pattern. The parameter must not be null.
   * @param pRegExpPattern Regular expression pattern. The parameter must not be null.
   * @return boolean The method returns true if the passed characters match to to passed pattern and false in all other
   * cases.
   */
  public boolean matchesPattern( String pCharacters, String pRegExpPattern );
}

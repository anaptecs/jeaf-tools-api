/**
 * Copyright 2004 - 2016 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.encryption;

/**
 * Enum defines the supported AES key lengths.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public enum AESKeyLength {
  /**
   * 128 bit AES key length. Please only use this key length if your security requirements are not too high.
   **/
  AES_128(128),

  /**
   * 192 bit AES key length. As 192 bit do not provider better performance than 256 bit but are less secure its
   * recommended to use 256 bit key length. Please be aware that JCE extension has to be installed to support this key
   * length in case of Oracle JDK. OpenJDK supports 192 AES key length by default.
   */
  AES_192(192),

  /**
   * 256 bit AES key length. Its recommenced to use 256 bit as default. Please be aware that JCE extension has to be
   * installed to support this key length in case of Oracle JDK. OpenJDK supports 256 AES key length by default.
   */
  AES_256(256);

  private int keyLength;

  /**
   * Initialize object.
   * 
   * @param pKeyLength Length of the key.
   */
  private AESKeyLength( int pKeyLength ) {
    keyLength = pKeyLength;
  }

  /**
   * Method returns the length of the key as numeric value.
   * 
   * @return int Key length as numeric value.
   */
  public int getKeyLength( ) {
    return keyLength;
  }

  /**
   * Method returns an AES key length that matches to the passed value. The returned key length will always be less or
   * equal to the passed integer value e.g if a key length of 200 is requested the {@link AESKeyLength#AES_192} will be
   * returned.
   * 
   * @param pKeyLength Key length as integer value.
   * @return {@link AESKeyLength} Best matching AES key length. The method never returns null.
   */
  public static AESKeyLength fromKeyLength( int pKeyLength ) {
    AESKeyLength lKeyLengthEnum;
    if (pKeyLength < AES_192.keyLength) {
      lKeyLengthEnum = AES_128;
    }
    else if (pKeyLength < AES_256.keyLength) {
      lKeyLengthEnum = AES_192;
    }
    else {
      lKeyLengthEnum = AES_256;
    }
    return lKeyLengthEnum;
  }
}

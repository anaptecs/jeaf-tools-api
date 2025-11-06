/**
 * Copyright 2004 - 2016 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.encryption;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * Class represents the result of an AES encryption process.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public final class AESEncrypted {
  /**
   * Base64 encoded IV as AES encryption result. The attribute may be null.
   */
  private final byte[] iv;

  /**
   * AES encrypted text. The attribute may be null.
   */
  private final byte[] cipherText;

  /**
   * Initialize object.
   * 
   * @param pIV AES IV vector, that was used to encrypt some content. The parameter may be null.
   * @param pCipherText Encrypted text. The parameter must must match to the base 64 encoding scheme {@link Base64}. The
   * parameter may be null.
   */
  public AESEncrypted( byte[] pIV, byte[] pCipherText ) {
    // Handle IV
    if (pIV != null) {
      iv = Arrays.copyOf(pIV, pIV.length);
    }
    else {
      iv = null;
    }

    // Handle cipher
    if (pCipherText != null) {
      cipherText = Arrays.copyOf(pCipherText, pCipherText.length);
    }
    else {
      cipherText = null;
    }
  }

  /**
   * Initialize object.
   * 
   * @param pIV AES IV vector, that was used to encrypt some content. The parameter may be null.
   * @param pCipherText Encrypted text. The parameter must must match to the base 64 encoding scheme {@link Base64}. The
   * parameter may be null.
   */
  public AESEncrypted( String pIV, String pCipherText ) {
    Decoder lDecoder = Base64.getDecoder();

    // Convert IV to Base64 representation
    if (pIV != null) {
      iv = lDecoder.decode(pIV);
    }
    else {
      iv = null;
    }

    // Convert cipher text to Base64 representation
    if (pCipherText != null) {
      cipherText = lDecoder.decode(pCipherText);
    }
    else {
      cipherText = null;
    }
  }

  /**
   * Method returns the AES initialization vector.
   * 
   * @return
   */
  public byte[] getIV( ) {
    byte[] lIV;
    if (iv != null) {
      lIV = Arrays.copyOf(iv, iv.length);
    }
    else {
      lIV = null;
    }
    return lIV;
  }

  /**
   * Method returns a base 64 encoded string with the IV.
   * 
   * @return {@link String} Base 64 encoded string of the IV. The meethod may return null.
   */
  public String getIVAsString( ) {
    String lIVString;
    if (iv != null) {
      lIVString = Base64.getEncoder().encodeToString(iv);
    }
    else {
      lIVString = null;
    }
    return lIVString;
  }

  /**
   * Method returns the base 64 encoded cipher text.
   * 
   * @return byte[] Encrypted content. The method may return null.
   */
  public byte[] getCipherText( ) {
    byte[] lCipherText;
    if (cipherText != null) {
      lCipherText = Arrays.copyOf(cipherText, cipherText.length);
    }
    else {
      lCipherText = null;
    }
    return lCipherText;
  }

  /**
   * Method returns a base 64 encoded cipher text.
   * 
   * @return {@link String} Base 64 encoded cipher text.
   */
  public String getCipherTextAsString( ) {
    String lCipherTextString;
    if (cipherText != null) {
      lCipherTextString = Base64.getEncoder().encodeToString(cipherText);
    }
    else {
      lCipherTextString = null;
    }
    return lCipherTextString;
  }
}

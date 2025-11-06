/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.encryption.AESEncrypted;
import com.anaptecs.jeaf.tools.api.encryption.AESKeyLength;
import com.anaptecs.jeaf.tools.api.encryption.AESSecretKey;
import com.anaptecs.jeaf.tools.api.encryption.EncryptionTools;

@ToolsImplementation(toolsInterface = EncryptionTools.class)
public class EncryptionToolsImpl implements EncryptionTools {

  @Override
  public String encryptAES( String pString, AESKeyLength pKeyLength, int pHashIterations ) {
    return null;
  }

  @Override
  public String decryptAES( String pString, AESKeyLength pKeyLength, int pHashIterations ) {
    return null;
  }

  @Override
  public AESEncrypted encrypt( String pPlainText, AESSecretKey pKey ) {
    return null;
  }

  @Override
  public String decrypt( AESEncrypted pAESCipher, AESSecretKey pEncryptionParams ) {
    return null;
  }

  @Override
  public byte[] sign( byte[] pMessage, String pAlgorithm, PrivateKey pPrivateKey ) {
    return null;
  }

  @Override
  public byte[] sign( byte[] pMessage, String pAlgorithm, KeyPair pKeyPair ) {
    return null;
  }

  @Override
  public boolean verify( byte[] pMessage, String pAlgorithm, byte[] pSignature, KeyPair pKeyPair ) {
    return false;
  }

  @Override
  public boolean verify( byte[] pMessage, String pAlgorithm, byte[] pSignature, PublicKey pPublicKey ) {
    return false;
  }

  @Override
  public KeyPair generateRSAKeyPair( int pKeyLength ) {
    return null;
  }

  @Override
  public KeyPair generateRSAKeyPair( int pKeyLength, String pAlgorithm ) {
    return null;
  }

  @Override
  public PublicKey createRSAPublicKey( byte[] pPublicKeyBytes ) {
    return null;
  }

  @Override
  public PublicKey createRSAPublicKey( byte[] pPublicKeyBytes, String pAlgorithm ) {
    return null;
  }

  @Override
  public PrivateKey createRSAPrivateKey( byte[] pPrivateKeyBytes ) {
    return null;
  }

  @Override
  public PrivateKey createRSAPrivateKey( byte[] pPrivateKeyBytes, String pAlgorithm ) {
    return null;
  }

  @Override
  public byte[] encryptRSA( byte[] pContent, PublicKey pPublicKey ) {
    return null;
  }

  @Override
  public byte[] decryptRSA( byte[] pEncryptedContent, PrivateKey pPrivateKey ) {
    return null;
  }

  @Override
  public String getKeyAsBase64( Key pKey ) {
    return null;
  }

  @Override
  public String getSecureToken( int pTokenLength ) {
    return null;
  }

  @Override
  public String getSecureToken( int pTokenLength, boolean pHumanReadable ) {
    return null;
  }

  @Override
  public AESKeyLength getAESDefaultKeyLength( ) {
    return null;
  }

}

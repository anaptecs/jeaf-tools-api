/**
 * Copyright 2004 - 2016 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.encryption;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.anaptecs.jeaf.tools.api.ToolsMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class represents a secret key for AES encryption.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public final class AESSecretKey {
  /**
   * Secret key that was generated when the object was created.
   */
  private final SecretKey secretKey;

  /**
   * Constructor creates a new AES secret key based on the passed parameters.
   * 
   * @param pPrivateKey The key that should be used for encryption. The parameter must not be null.
   * @param pSalt Salt that should be used for encryption. The parameter must not be null.
   * @param pKeyLength Length of the key that should be used. The parameter must not be null.
   * @param pHashAlgorithm Name of the hash algorithm. The parameter must not be null.
   * @param pIterations Number of iterations to hash the passed key using the passed hash algorithm.
   * @throws JEAFSystemException if a problem occurs during secret key generation.
   */
  public AESSecretKey( String pPrivateKey, String pSalt, AESKeyLength pKeyLength, String pHashAlgorithm,
      int pIterations ) throws JEAFSystemException {

    // Check parameters.
    Check.checkInvalidParameterNull(pPrivateKey, "pPrivateKey");
    Check.checkInvalidParameterNull(pSalt, "pSalt");
    Check.checkInvalidParameterNull(pKeyLength, "pKeyLength");
    Check.checkInvalidParameterNull(pHashAlgorithm, "pHashAlgorithm");

    // Implementation is based on: http://stackoverflow.com/questions/992019/java-256-bit-aes-password-based-encryption
    try {
      // Create key factory
      SecretKeyFactory lFactory = SecretKeyFactory.getInstance(pHashAlgorithm);

      // Create secret key.
      byte[] lSaltBytes = pSalt.getBytes(StandardCharsets.UTF_8);
      KeySpec lKeySpec = new PBEKeySpec(pPrivateKey.toCharArray(), lSaltBytes, pIterations, pKeyLength.getKeyLength());
      SecretKey lTempKey = lFactory.generateSecret(lKeySpec);
      secretKey = new SecretKeySpec(lTempKey.getEncoded(), EncryptionTools.AES_ALGORITHM);
    }
    catch (GeneralSecurityException e) {
      throw new JEAFSystemException(ToolsMessages.UNABLE_TO_CREATE_AES_SECRET_KEY, e);
    }
  }

  public AESSecretKey( SecretKey pSecretKey ) {
    // Check parameters.
    Check.checkInvalidParameterNull(pSecretKey, "pSecretKey");

    secretKey = pSecretKey;
  }

  /**
   * Method creates a secret key based on the passed encryption parameters.
   * 
   * @return {@link SecretKey} Secret key that was created using this configuration of this object.
   * @throws GeneralSecurityException if some problem occurs during the key generation.
   */
  public SecretKey getSecretKey( ) {
    return secretKey;
  }
}

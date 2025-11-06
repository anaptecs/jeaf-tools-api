/**
 * Copyright 2004 - 2013 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.encryption;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.anaptecs.jeaf.tools.annotations.EncryptionToolsConfig;
import com.anaptecs.jeaf.tools.api.ToolsLoader;

/**
 * Interface defines the methods that are available to make encryption as simple as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface EncryptionTools {

  /** The Constant keyLength for 128 bit. */
  static final int WINDOWS_DEFAULT_KEY_LENGTH_128 = 128;

  /** The Constant keyLength for 256 bit. */
  static final int OTHER_DEFAULT_KEY_LENGTH_256 = 256;

  static final String PBKDF2_WITH_HMAC_SHA256 = "PBKDF2WithHmacSHA256";

  static final String PBKDF2_WITH_HMAC_SHA1 = "PBKDF2WithHmacSHA1";

  static final String AES_ALGORITHM = "AES";

  /**
   * Configured implementation of encryption tools.
   */
  static final EncryptionTools ENCRYPTION_TOOLS = ToolsLoader.getTools(EncryptionTools.class);

  /**
   * Method returns the configured implementation of the Encryption Tools.
   * 
   * @return {@link EncryptionTools} Configured implementation of encryption tools. The method never returns null.
   */
  static EncryptionTools getEncryptionTools( ) {
    return ENCRYPTION_TOOLS;
  }

  /**
   * Method encrypts the passed String with AES.
   * 
   * @param pString String to be encrypted. The parameter may not be null.
   * @param pKeyLength Length of the master key which is used for the encryption. For every encrypt and decrypt
   * operation the same masterKeyLength must be used.
   * @param pHashIterations the number of hash operations which will be done.For every encrypt and decrypt operation the
   * same hashIerations must be used.
   * @return String the encrypted CharSequence.
   */
  String encryptAES( String pString, AESKeyLength pKeyLength, int pHashIterations );

  /**
   * Method decodes the passed String with AES.
   * 
   * @param pString String to be decoded. This parameter may not be null.
   * @param pKeyLength Length of the master key which is used for the encryption. For every encrypt and decrypt
   * operation the same masterKeyLength must be used.
   * @param pHashIterations the number of hash operations which will be done.For every encrypt and decrypt operation the
   * same hashIerations must be used.
   * @return String the decoded CharSequence.
   */
  String decryptAES( String pString, AESKeyLength pKeyLength, int pHashIterations );

  /**
   * Method encrypts the passed plain text using AES.
   * 
   * @param pPlainText Text that should be encrypted. The parameter may be null.
   * @param pKey Parameter contains the AES secret key that should be used. The parameter must not be null.
   * @return {@link AESEncrypted} Result of the encryption. As AES generates the encrypted text as output as well as
   * some initialization vector (IV) we have to return an object. Both information have to be kept and are needed for
   * decryption.
   */
  AESEncrypted encrypt( String pPlainText, AESSecretKey pKey );

  /**
   * Method decrypts the passed AES cipher.
   * 
   * @param pAESCipher Object describing the encrypted text. The parameter must not be null.
   * @param pKey Parameter contains the AES secret key that should be used. The parameter must not be null.
   * @return {@link String} Decrypted text. The method may return null if null was encrypted.
   */
  String decrypt( AESEncrypted pAESCipher, AESSecretKey pEncryptionParams );

  /**
   * Methods signs the passed message with the passed private key.
   * 
   * @param pMessage Message that should be signed. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used to sign the message. The parameter must not be null.
   * @param pKeyPair Key pair (or actually the private key of it) that should be used to sign the message. The parameter
   * must not be null.
   * 
   * @return byte[] Signature for the passed message. The method never returns null.
   */
  byte[] sign( byte[] pMessage, String pAlgorithm, KeyPair pKeyPair );

  /**
   * Methods signs the passed message with the passed private key.
   * 
   * @param pMessage Message that should be signed. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used to sign the message. The parameter must not be null.
   * @param pPrivateKey Private key that should be used to sign the message. The parameter must not be null.
   * 
   * @return byte[] Signature for the passed message. The method never returns null.
   */
  byte[] sign( byte[] pMessage, String pAlgorithm, PrivateKey pPrivateKey );

  /**
   * Method verifies the passed message against the passed signature using the passed certificate that was used to sign
   * the message.
   * 
   * @param pMessage Message that should be verified. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used to verify the signature.
   * @param pSignature Signature that was created by the sender of the message. The parameter must not be null.
   * @param pKeyPair Key pair (or actually the public key of it) that should have been used to sign the message. The
   * parameter must not be null.
   * @return boolean Method returns true if the passed messages matches with the passed signature and the certificate
   * and otherwise false.
   */
  boolean verify( byte[] pMessage, String pAlgorithm, byte[] pSignature, KeyPair pKeyPair );

  /**
   * Method verifies the passed message against the passed signature using the passed public key that was used to sign
   * the message.
   * 
   * @param pMessage Message that should be verified. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used to verify the signature. The parameter must not be null.
   * @param pSignature Signature that was created by the sender of the message. The parameter must not be null.
   * @param pPublicKey Public key that should have been used to sign the message. The parameter must not be null.
   * @return boolean Method returns true if the passed messages matches with the passed signature and the public key and
   * otherwise false.
   */
  boolean verify( byte[] pMessage, String pAlgorithm, byte[] pSignature, PublicKey pPublicKey );

  /**
   * Method generates a new key pair (public and private key) for the passed asymmetric encryption algorithm.
   * 
   * @param pKeyLength Length of the generated keys. It's strongly recommended that the key length is at least 2048.
   * @return {@link KeyPair} Generated public and private key. The method never returns null.
   */
  KeyPair generateRSAKeyPair( int pKeyLength );

  /**
   * Method generates a new key pair (public and private key) for the passed asymmetric encryption algorithm.
   * 
   * @param pKeyLength Length of the generated keys. It's strongly recommended that the key length is at least 2048.
   * @param pAlgorithm Algorithm that should be used for the keys. The parameter must not be null.
   * @return {@link KeyPair} Generated public and private key. The method never returns null.
   */
  KeyPair generateRSAKeyPair( int pKeyLength, String pAlgorithm );

  /**
   * Method generates a new RSA public key object from the passed bytes.
   * 
   * @param pPublicKeyBytes Bytes that should be used to generate the public key. The parameter must not be null.
   * @return {@link PublicKey} RSA public key that was generated using the passed bytes. The method never returns null.
   */
  PublicKey createRSAPublicKey( byte[] pPublicKeyBytes );

  /**
   * Method generates a new RSA public key object from the passed bytes.
   * 
   * @param pPublicKeyBytes Bytes that should be used to generate the public key. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used for the keys. The parameter must not be null.
   * @return {@link PublicKey} RSA public key that was generated using the passed bytes. The method never returns null.
   */
  PublicKey createRSAPublicKey( byte[] pPublicKeyBytes, String pAlgorithm );

  /**
   * Method generates a new RSA private key object from the passed bytes.
   * 
   * @param pPrivateKeyBytes Bytes that should be used to generate the private key. The parameter must not be null.
   * @return {@link PrivateKey} RSA private key that was generated using the passed bytes. The method never returns
   * null.
   */
  PrivateKey createRSAPrivateKey( byte[] pPrivateKeyBytes );

  /**
   * Method generates a new RSA private key object from the passed bytes.
   * 
   * @param pPrivateKeyBytes Bytes that should be used to generate the private key. The parameter must not be null.
   * @param pAlgorithm Algorithm that should be used for the keys. The parameter must not be null.
   * @return {@link PrivateKey} RSA private key that was generated using the passed bytes. The method never returns
   * null.
   */
  PrivateKey createRSAPrivateKey( byte[] pPrivateKeyBytes, String pAlgorithm );

  /**
   * Method encrypts the passed content using RSA algorithm and the passed public key.
   * 
   * <b>Attention:</b> Converting the encrypted content from bytes to a string may cause problems during decryption. So
   * please do not store encrypted content as string but as bytes.
   * 
   * @param pContent Content that should be encrypted. The parameter must not be null.
   * @param pPublicKey Public key that should be used for the RSA encryption. The parameter must not be null.
   * @return byte[] Encrypted content as bytes. The method never returns null.
   */
  byte[] encryptRSA( byte[] pContent, PublicKey pPublicKey );

  /**
   * Method decrypts the passed content using RSA algorithm and the passed private key.
   * 
   * @param pContent Content that should be decrypted. The parameter must not be null.
   * @param pPrivateKey Private key that should be used for the RSA encryption. The parameter must not be null.
   * @return byte[] Decrypted content as bytes. The method never returns null.
   */
  byte[] decryptRSA( byte[] pEncryptedContent, PrivateKey pPrivateKey );

  /**
   * Method converts the passed key into a base 64 string representation.
   * 
   * @param pKey Key that should be converted. The parameter must not be null.
   * @return {@link String} Base 64 encoded key. The method never returns null.
   */
  String getKeyAsBase64( Key pKey );

  /**
   * Method generates a secure token with the passed length.
   * 
   * @param pTokenLength Length of the tokens that should be generated.
   * @return String Generated one-time token. The method never returns null.
   */
  String getSecureToken( int pTokenLength );

  /**
   * Method generates a secure token of the passed length.
   * 
   * @param pTokenLength Length of the tokens that should be generated.
   * @param pHumanReadable Parameter defines if the returned token should be optimized for human readability. If you
   * enable human readability please ensure the you increase the length of the created token.
   * @return String Generated token. The method never returns null.
   */
  String getSecureToken( int pTokenLength, boolean pHumanReadable );

  /**
   * Method returns the defined AES default key length. The result of this operation depends on the encryption
   * capabilities of the used JDK (@see https://www.oracle.com/java/technologies/javase-jce8-downloads.html) as well as
   * on the configured maximum key length using @link {@link EncryptionToolsConfig#aesDefaultKeyLength()}
   * 
   * @return {@link AESKeyLength} AESDefault key length. The method never returns null.
   */
  AESKeyLength getAESDefaultKeyLength( );
}

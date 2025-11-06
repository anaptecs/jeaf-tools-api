/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.tools.api.encryption.AESKeyLength;
import com.anaptecs.jeaf.tools.api.encryption.EncryptionTools;

/**
 * Annotation is used to configure behavior of {@link EncryptionTools} implementation.
 * 
 * @author JEAF Development Team
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface EncryptionToolsConfig {
  /**
   * Name of the resource that contains the name of the class with the @ToolsConfig annotation.
   */
  String ENCRYPTION_TOOLS_CONFIG_RESOURCE_NAME = "EncryptionToolsConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String ENCRYPTION_TOOLS_CONFIG_PATH = ToolsLoader.TOOLS_BASE_PATH + '/' + ENCRYPTION_TOOLS_CONFIG_RESOURCE_NAME;

  /**
   * Algorithm that is used to create token, if nothing else is defined.
   */
  static final String SECURE_TOKEN_RANDOM_DEFAULT_ALGORITHM = "SHA1PRNG";

  /**
   * Constant for default RSA algorithm that is used.
   */
  static final String RSA_DEFAULT_ALGORITHM = "RSA";

  /**
   * Constant for default RSA transformation that is used.
   */
  static final String RSA_DEFAULT_TRANSFORM = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";

  /**
   * Constant for AES default transformation that is used if no specific variant is defined.
   */
  static final String AES_DEFAULT_TRANSFORMATION = "AES/CBC/PKCS5Padding";

  /**
   * When working with AES encryption then it is required that the concrete variant of the AES encryption is defined.
   * This can be done here.
   */
  String aesTransformation() default AES_DEFAULT_TRANSFORMATION;

  /**
   * Default key length used for AES encryption. If key length is not supported due to limited encryption capabilities
   * of the runtime environment then the configured value will be overwritten to the max supported key length.
   * 
   * @see https://www.oracle.com/de/java/technologies/javase-jce8-downloads.html
   */
  AESKeyLength aesDefaultKeyLength() default AESKeyLength.AES_256;

  /**
   * Algorithm that should be used to generate random numbers for secure tokens.
   */
  String secureTokenRandomAlgorithm() default SECURE_TOKEN_RANDOM_DEFAULT_ALGORITHM;

  /**
   * Algorithm that is used to generate RSA keys.
   */
  String rsaAlgorithm() default RSA_DEFAULT_ALGORITHM;

  /**
   * RSA transformation that used used to encrypt and decrypt messages using RSA.
   */
  String rsaTransform() default RSA_DEFAULT_TRANSFORM;
}

/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.encryption;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.anaptecs.jeaf.tools.api.encryption.AESEncrypted;
import com.anaptecs.jeaf.tools.api.encryption.AESKeyLength;
import com.anaptecs.jeaf.tools.api.encryption.AESSecretKey;
import com.anaptecs.jeaf.tools.api.encryption.EncryptionTools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EncryptionToolsTests {
  @Test
  @Order(10)
  public void testAESEncrypted( ) {
    // Good case
    String lIVString = "IV123456";
    String lCipherString = "CIPHER1234567890";
    AESEncrypted lEncrypted = new AESEncrypted(lIVString, lCipherString);
    assertTrue(Arrays.equals(new byte[] { 33, 93, 118, -33, -114, 122 }, lEncrypted.getIV()));
    assertTrue(Arrays.equals(new byte[] { 8, -125, -57, 17, 29, 118, -33, -114, 122, -17, -49, 116 },
        lEncrypted.getCipherText()));
    assertEquals(lIVString, lEncrypted.getIVAsString());
    assertEquals(lCipherString, lEncrypted.getCipherTextAsString());

    byte[] lIVBytes = new byte[] { 33, 93, 118, -32, -117, 122 };
    byte[] lCipherBytes = new byte[] { 8, -125, -57, 17, 29, 118, -33, -114, 122, -17, -49, 116 };
    lEncrypted = new AESEncrypted(lIVBytes, lCipherBytes);
    assertTrue(Arrays.equals(lIVBytes, lEncrypted.getIV()));
    assertTrue(Arrays.equals(lCipherBytes, lEncrypted.getCipherText()));
    assertFalse(lIVBytes.equals(lEncrypted.getIV()));
    assertFalse(lCipherBytes.equals(lEncrypted.getCipherText()));

    // Test handling of null values.
    lEncrypted = new AESEncrypted((byte[]) null, (byte[]) null);
    assertNull(lEncrypted.getIVAsString());
    assertNull(lEncrypted.getCipherTextAsString());
    assertNull(lEncrypted.getIV());
    assertNull(lEncrypted.getCipherText());

    lEncrypted = new AESEncrypted((String) null, (String) null);
    assertNull(lEncrypted.getIVAsString());
    assertNull(lEncrypted.getCipherTextAsString());

    // Use characters that are not support for a Base64 encoding like '_'
    try {
      lEncrypted = new AESEncrypted(lIVString, "123_sad");
      fail("Expecting exception when using invalid base64 character.");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Illegal base64 character 5f", e.getMessage());
    }
    try {
      lEncrypted = new AESEncrypted("123_sad", lCipherString);
      fail("Expecting exception when using invalid base64 character.");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Illegal base64 character 5f", e.getMessage());
    }
  }

  @Test
  @Order(20)
  public void testAESKeyLength( ) {
    AESKeyLength lKeyLength = AESKeyLength.AES_128;
    assertEquals(128, lKeyLength.getKeyLength());
    lKeyLength = AESKeyLength.AES_192;
    assertEquals(192, lKeyLength.getKeyLength());
    lKeyLength = AESKeyLength.AES_256;
    assertEquals(256, lKeyLength.getKeyLength());

    // Ensure for compatibility purposes that new literals are not added by accident.
    for (AESKeyLength lLength : AESKeyLength.values()) {
      switch (lLength) {
        // Supported key lengths.
        case AES_128:
        case AES_192:
        case AES_256:
          break;

        default:
          fail("Unexpected enumeration literal " + lLength.name());
      }
    }
  }

  @Test
  @Order(30)
  public void testAESSecretKey( ) {
    // Good case
    AESSecretKey lSecretKey = new AESSecretKey("ThisIsMyVeryPrivateKey", "Salt&Pepper", AESKeyLength.AES_128,
        EncryptionTools.PBKDF2_WITH_HMAC_SHA256, 17);
    assertNotNull(lSecretKey.getSecretKey());

    SecretKey lInternalKey = lSecretKey.getSecretKey();
    AESSecretKey lSecretKey2 = new AESSecretKey(lInternalKey);
    assertEquals(lInternalKey, lSecretKey2.getSecretKey());

    // Test usage with invalid algorithm
    try {
      new AESSecretKey("ThisIsMyVeryPrivateKey", "Salt&Pepper", AESKeyLength.AES_128, "unknown_algorithm", 17);
      fail("Wrong hash algorithm is expected to cause exception.");
    }
    catch (JEAFSystemException e) {
      assertEquals("[0 1049] 1049", e.getMessage());
      assertEquals(NoSuchAlgorithmException.class, e.getCause().getClass());
    }
  }

  @Test
  public void testFromKeyLength( ) {
    assertEquals(AESKeyLength.AES_256, AESKeyLength.fromKeyLength(Integer.MAX_VALUE));
    assertEquals(AESKeyLength.AES_256, AESKeyLength.fromKeyLength(257));
    assertEquals(AESKeyLength.AES_256, AESKeyLength.fromKeyLength(256));
    assertEquals(AESKeyLength.AES_192, AESKeyLength.fromKeyLength(255));
    assertEquals(AESKeyLength.AES_128, AESKeyLength.fromKeyLength(180));
    assertEquals(AESKeyLength.AES_128, AESKeyLength.fromKeyLength(0));
    assertEquals(AESKeyLength.AES_128, AESKeyLength.fromKeyLength(-20));
  }

}

package com.anaptecs.jeaf.tools.api;

import com.anaptecs.jeaf.xfun.annotations.MessageResource;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class contains all generated constants for messages of JEAF that are used by JEAF Tools
 *
 * @author JEAF Development Team
 * @version 1.0
 */
@MessageResource(path = "ToolsMessages.xml")
public final class ToolsMessages {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "ToolsMessages.xml";

  /**
   * Exceptions with this error code are thrown if a new instance of a class could not be created using
   * Class.newInstance().
   */
  public static final ErrorCode UNABLE_TO_CREATE_NEW_INSTANCE;

  /**
   * Exceptions with this error code are thrown if a locale string does neither define a language nor country.
   */
  public static final ErrorCode LANGUAGE_OR_COUNTRY_MISSING;

  /**
   * Exceptions with this error code are thrown if a locale string does have the required format.
   */
  public static final ErrorCode INVALID_LOCALE_STRING_FORMAT;

  /**
   * Exceptions with this error code are thrown if a class that should be created by reflection is not assignable to a
   * specific type.
   */
  public static final ErrorCode CLASS_NOT_ASSIGNABLE;

  /**
   * Exceptions with this error code are thrown if an invalid http status code is used.
   */
  public static final ErrorCode INVALID_HTTP_STATUS_CODE;

  /**
   * Exceptions with this error code are thrown if lookup for an website fails.
   */
  public static final ErrorCode UNABLE_TO_LOOKUP_WEBSITE_INFORMATION;

  /**
   * Exceptions with this error code are thrown if an invalid value date format is used.
   */
  public static final ErrorCode INVALID_DATE_FORMAT;

  /**
   * Exceptions with this error code are thrown if an IOException occurs during the serialization of an object.
   */
  public static final ErrorCode UNABLE_TO_SERIALIZE_OBJECT;

  /**
   * Exceptions with this error code are thrown if an IOException occurs during the deserialization of an object.
   */
  public static final ErrorCode UNABLE_TO_DESERIALIZE_OBJECT;

  /**
   * Exceptions with this error code are thrown if an unknow algorithm is passed to JEAFs secure token generator.
   */
  public static final ErrorCode UNKNOWN_ALGORITHM;

  /**
   * Error code is used to indicate that the Serialization failed because of an IOException.
   */
  public static final ErrorCode ERROR_DURING_SERIALIZATION;

  /**
   * Error code is used to indicate that the Deserialization failed because of an IOException.
   */
  public static final ErrorCode ERROR_DURING_DESERIALIZATION;

  /**
   * Error code is used to indicate that the Deserialization failed because of an ClassNotFoundException.
   */
  public static final ErrorCode ERROR_DURING_DESERIALIZATION_CLASS_NOT_FOUND;

  /**
   * Error code is used to indicate that the Serialization failed because of an I/O exception.
   */
  public static final ErrorCode UNABLE_TO_RESOLVE_NETWORK_INFO;

  /**
   * Error code is used to indicate that host name could not be resolved.
   */
  public static final ErrorCode UNKNOWN_HOST;

  /**
   * Error code is used to indicate that host name could be reached due to an network error.
   */
  public static final ErrorCode NETWORK_ERROR_ON_PING;

  /**
   * Error code is used to indicate that a URL,is not valid.
   */
  public static final ErrorCode INVALID_URL;

  /**
   * Error code is used to indicate that an xml document could not be written to stream.
   */
  public static final ErrorCode UNABLE_TO_WRITE_XML;

  /**
   * Error code is used to indicate that a required xml element could not be find within a specific subtree.
   */
  public static final ErrorCode REQUIRED_ELEMENT_NOT_FOUND;

  /**
   * Error code is used to indicate that a single element occurs more than one within a specific subtree.
   */
  public static final ErrorCode ELEMENT_NOT_UNIQUE;

  /**
   * Error code is used to when an invalid timestamp format is used.
   */
  public static final ErrorCode INVALID_TIMESTAMP_FORMAT;

  /**
   * Error code is used to indicate that a required xml element could not be find within a specific subtree.
   */
  public static final ErrorCode REQUIRED_ATTRIBUTE_NOT_FOUND;

  /**
   * Exceptions with this error code are thrown if during parsing an XML resource an exception occurs.
   */
  public static final ErrorCode UNABLE_TO_PARSE_XML_FILE;

  /**
   * Exceptions occurs if all document builders from pool are already in use.
   */
  public static final ErrorCode UNABLE_TO_CLAIM_POOLED_DOCUMENT_BUILDER;

  /**
   * Exceptions occurs if a new document builders could not be created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_DOCUMENT_BUILDER;

  /**
   * Exceptions occurs if an element is expected to have a node value but does not.
   */
  public static final ErrorCode ELEMENT_VALUE_MISSING;

  /**
   * Error code is used to indicate that a new SSL Socket Factory could ot be created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_SSL_SOCKET_FACTORY;

  /**
   * Messages with this message id are traced if an exception occurs when trying to load a locale provider.
   */
  public static final ErrorCode UNABLE_TO_DELETE_FILE;

  /**
   * Exceptions with this error are thrown when a new file could not be created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_NEW_FILE;

  /**
   * Messages with this message id are traced after a file was copied.
   */
  public static final MessageID TRANSFERED_FILE_CONTENT;

  /**
   * Messages with this message id are traced after a zip file was extracted.
   */
  public static final MessageID EXTRACTED_FILE;

  /**
   * Exceptions with this error when an IOException occurs during access on file attributes via NIO.
   */
  public static final ErrorCode UNABLE_TO_ACCESS_FILE_ATTRIBUTES;

  /**
   * Exceptions with this error when a new directory could not be created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_DIRECTORY;

  /**
   * Exceptions with this error when a new directory could not be created.
   */
  public static final ErrorCode INVALID_EXTENSION;

  /**
   * Exceptions with this error are thrown when a passed file object does not point to a directory.
   */
  public static final ErrorCode NOT_A_DIRECTORY;

  /**
   * Exceptions with this error are thrown when a passed file object does not point to a directory.
   */
  public static final ErrorCode UNABLE_TO_CREATE_CANONICAL_PATH;

  /**
   * Exceptions with this error are thrown when the maximum amount of bytes that is allowed to be transfered is
   * exceeded.
   */
  public static final ErrorCode MAX_BYTES_EXCEEDED;

  /**
   * Exceptions with this error are thrown when the maximum amount of bytes that is allowed to be transfered is
   * exceeded.
   */
  public static final ErrorCode ZIP_EXTRACTION_ABORTED;

  /**
   * Exceptions with this error are thrown when a directory traversal attack was detected.
   */
  public static final ErrorCode PREVENTED_DIRECTORY_TRAVERSAL_ATTACK;

  /**
   * Exceptions with this error are thrown when size of a not exiusting directory should be calculated..
   */
  public static final ErrorCode CALCULATION_OF_DIR_SIZE_FAILED;

  /**
   * Exceptions with this error code are thrown if constraint checks for the parameters of a request fail.
   */
  public static final ErrorCode REQUEST_VALIDATION_FAILED;

  /**
   * Exceptions with this error code are thrown if constraint checks for the response of a request fails.
   */
  public static final ErrorCode RESPONSE_VALIDATION_FAILED;

  /**
   * Messages with this message id are traced if an exception occurs when trying to encrypt a string.
   */
  public static final ErrorCode UNABLE_TO_ENCRYPT_STRING;

  /**
   * Messages with this message id are traced if an exception occurs when trying to decrypt a string.
   */
  public static final ErrorCode UNABLE_TO_DECRYPT_STRING;

  /**
   * Security warning if all SSL certificates are accpeted.
   */
  public static final MessageID SSL_WARNING;

  /**
   *
   */
  public static final ErrorCode UNABLE_TO_VERIFY_SIGNATURE;

  /**
   *
   */
  public static final ErrorCode UNABLE_TO_GENERATE_KEY_PAIR;

  /**
   *
   */
  public static final ErrorCode UNABLE_TO_GENERATE_KEY_FROM_BYTES;

  /**
   *
   */
  public static final ErrorCode RSA_MAX_MESSAGE_SIZE_EXCEEDED;

  /**
   *
   */
  public static final ErrorCode UNABLE_TO_CREATE_AES_SECRET_KEY;

  /**
   *
   */
  public static final ErrorCode UNABLE_TO_SIGN_MESSAGE;

  /**
   *
   */
  public static final ErrorCode INVALID_TOKEN_LENGTH;

  /**
   *
   */
  public static final ErrorCode UNSUPPORTED_ALGORITHM;

  /**
   * Exceptions with this error code are thrown if constraint checks for the parameters of a request fail.
   */
  public static final ErrorCode INVALID_JMX_METER_NAME;

  /**
   * Exceptions with this error code are thrown in case that invalid ISO 3166 alpha-2 or alpha-3 country code is used.
   */
  public static final ErrorCode INVALID_COUNTRY_CODE;

  /**
   * Excetions with this error code are thrown in case that at least one constraint violation for an object failed.
   */
  public static final ErrorCode OBJECT_VALIDATION_FAILED;

  /**
   * Error code is used in case that an object could not be acquired from the pool.
   */
  public static final ErrorCode UNABLE_TO_ACQUIRE_OBJECT_FROM_POOL;

  /**
   * Message is used in case that the size of a pool is increased.
   */
  public static final MessageID INCREASED_POOL_SIZE;

  /**
   * Message is used in case that a pool already has it's maximum size and more objects are requested.
   */
  public static final ErrorCode POOL_OVERLOADED;

  /**
   * Message with this error code are used in case that a new instance of a JEAF Tools implementation could not be
   * created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_TOOLS_IMPLEMENTATION;

  /**
   * Error code is used in case that a requested tools implementation is not available.
   */
  public static final ErrorCode TOOLS_IMPLEMENTATION_NOT_AVAILABLE;

  /**
   * This message is used in case that another tools implementation is already is already used and another one for the
   * same interface is also provided.
   */
  public static final MessageID IGNORING_TOOLS_IMPLEMENTATION;
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    MessageRepository lRepository = XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    // Handle all info messages.
    TRANSFERED_FILE_CONTENT = lRepository.getMessageID(1029);
    EXTRACTED_FILE = lRepository.getMessageID(1030);
    SSL_WARNING = lRepository.getMessageID(1044);
    INCREASED_POOL_SIZE = lRepository.getMessageID(1057);
    IGNORING_TOOLS_IMPLEMENTATION = lRepository.getMessageID(1061);
    // Handle all messages for errors.
    UNABLE_TO_CREATE_NEW_INSTANCE = lRepository.getErrorCode(1000);
    LANGUAGE_OR_COUNTRY_MISSING = lRepository.getErrorCode(1001);
    INVALID_LOCALE_STRING_FORMAT = lRepository.getErrorCode(1002);
    CLASS_NOT_ASSIGNABLE = lRepository.getErrorCode(1003);
    INVALID_HTTP_STATUS_CODE = lRepository.getErrorCode(1004);
    UNABLE_TO_LOOKUP_WEBSITE_INFORMATION = lRepository.getErrorCode(1005);
    INVALID_DATE_FORMAT = lRepository.getErrorCode(1006);
    UNABLE_TO_SERIALIZE_OBJECT = lRepository.getErrorCode(1007);
    UNABLE_TO_DESERIALIZE_OBJECT = lRepository.getErrorCode(1008);
    UNKNOWN_ALGORITHM = lRepository.getErrorCode(1009);
    ERROR_DURING_SERIALIZATION = lRepository.getErrorCode(1010);
    ERROR_DURING_DESERIALIZATION = lRepository.getErrorCode(1011);
    ERROR_DURING_DESERIALIZATION_CLASS_NOT_FOUND = lRepository.getErrorCode(1012);
    UNABLE_TO_RESOLVE_NETWORK_INFO = lRepository.getErrorCode(1013);
    UNKNOWN_HOST = lRepository.getErrorCode(1014);
    NETWORK_ERROR_ON_PING = lRepository.getErrorCode(1015);
    INVALID_URL = lRepository.getErrorCode(1016);
    UNABLE_TO_WRITE_XML = lRepository.getErrorCode(1017);
    REQUIRED_ELEMENT_NOT_FOUND = lRepository.getErrorCode(1018);
    ELEMENT_NOT_UNIQUE = lRepository.getErrorCode(1019);
    INVALID_TIMESTAMP_FORMAT = lRepository.getErrorCode(1020);
    REQUIRED_ATTRIBUTE_NOT_FOUND = lRepository.getErrorCode(1021);
    UNABLE_TO_PARSE_XML_FILE = lRepository.getErrorCode(1022);
    UNABLE_TO_CLAIM_POOLED_DOCUMENT_BUILDER = lRepository.getErrorCode(1023);
    UNABLE_TO_CREATE_DOCUMENT_BUILDER = lRepository.getErrorCode(1024);
    ELEMENT_VALUE_MISSING = lRepository.getErrorCode(1025);
    UNABLE_TO_CREATE_SSL_SOCKET_FACTORY = lRepository.getErrorCode(1026);
    UNABLE_TO_DELETE_FILE = lRepository.getErrorCode(1027);
    UNABLE_TO_CREATE_NEW_FILE = lRepository.getErrorCode(1028);
    UNABLE_TO_ACCESS_FILE_ATTRIBUTES = lRepository.getErrorCode(1031);
    UNABLE_TO_CREATE_DIRECTORY = lRepository.getErrorCode(1032);
    INVALID_EXTENSION = lRepository.getErrorCode(1033);
    NOT_A_DIRECTORY = lRepository.getErrorCode(1034);
    UNABLE_TO_CREATE_CANONICAL_PATH = lRepository.getErrorCode(1035);
    MAX_BYTES_EXCEEDED = lRepository.getErrorCode(1036);
    ZIP_EXTRACTION_ABORTED = lRepository.getErrorCode(1037);
    PREVENTED_DIRECTORY_TRAVERSAL_ATTACK = lRepository.getErrorCode(1038);
    CALCULATION_OF_DIR_SIZE_FAILED = lRepository.getErrorCode(1039);
    REQUEST_VALIDATION_FAILED = lRepository.getErrorCode(1040);
    RESPONSE_VALIDATION_FAILED = lRepository.getErrorCode(1041);
    UNABLE_TO_ENCRYPT_STRING = lRepository.getErrorCode(1042);
    UNABLE_TO_DECRYPT_STRING = lRepository.getErrorCode(1043);
    UNABLE_TO_VERIFY_SIGNATURE = lRepository.getErrorCode(1045);
    UNABLE_TO_GENERATE_KEY_PAIR = lRepository.getErrorCode(1046);
    UNABLE_TO_GENERATE_KEY_FROM_BYTES = lRepository.getErrorCode(1047);
    RSA_MAX_MESSAGE_SIZE_EXCEEDED = lRepository.getErrorCode(1048);
    UNABLE_TO_CREATE_AES_SECRET_KEY = lRepository.getErrorCode(1049);
    UNABLE_TO_SIGN_MESSAGE = lRepository.getErrorCode(1050);
    INVALID_TOKEN_LENGTH = lRepository.getErrorCode(1051);
    UNSUPPORTED_ALGORITHM = lRepository.getErrorCode(1052);
    INVALID_JMX_METER_NAME = lRepository.getErrorCode(1053);
    INVALID_COUNTRY_CODE = lRepository.getErrorCode(1054);
    OBJECT_VALIDATION_FAILED = lRepository.getErrorCode(1055);
    UNABLE_TO_ACQUIRE_OBJECT_FROM_POOL = lRepository.getErrorCode(1056);
    POOL_OVERLOADED = lRepository.getErrorCode(1058);
    UNABLE_TO_CREATE_TOOLS_IMPLEMENTATION = lRepository.getErrorCode(1059);
    TOOLS_IMPLEMENTATION_NOT_AVAILABLE = lRepository.getErrorCode(1060);
    // Handle all localized strings.
  }

  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private ToolsMessages( ) {
    // Nothing to do.
  }
}
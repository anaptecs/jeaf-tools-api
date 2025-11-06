/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api;

import com.anaptecs.jeaf.tools.api.cache.CacheTools;
import com.anaptecs.jeaf.tools.api.collections.CollectionTools;
import com.anaptecs.jeaf.tools.api.date.DateTools;
import com.anaptecs.jeaf.tools.api.encoding.EncodingTools;
import com.anaptecs.jeaf.tools.api.encryption.EncryptionTools;
import com.anaptecs.jeaf.tools.api.file.FileTools;
import com.anaptecs.jeaf.tools.api.http.WebTools;
import com.anaptecs.jeaf.tools.api.lang.AutoBoxingTools;
import com.anaptecs.jeaf.tools.api.locale.LocaleTools;
import com.anaptecs.jeaf.tools.api.monitoring.MonitoringTools;
import com.anaptecs.jeaf.tools.api.network.NetworkingTools;
import com.anaptecs.jeaf.tools.api.performance.PerformanceTools;
import com.anaptecs.jeaf.tools.api.pooling.PoolingTools;
import com.anaptecs.jeaf.tools.api.reflect.ReflectionTools;
import com.anaptecs.jeaf.tools.api.regexp.RegExpTools;
import com.anaptecs.jeaf.tools.api.serialization.SerializationTools;
import com.anaptecs.jeaf.tools.api.ssl.SSLTools;
import com.anaptecs.jeaf.tools.api.stream.StreamTools;
import com.anaptecs.jeaf.tools.api.string.StringTools;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.tools.api.xml.XMLTools;

/**
 * Class is the JEAF entry point to access some general functions of JEAF. Since JEAF supports a wide range of
 * environments the appropriate entry point implementation has to be chosen. Usually this this would be the entry point
 * implementation for a full JSE or JEE environment.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public class Tools {
  /**
   * Method returns the auto boxing tools implementation that is configured.
   * 
   * @return {@link AutoBoxingTools} Auto boxing tools implementation that is configured. The method never returns null
   */
  public static AutoBoxingTools getAutoBoxingTools( ) {
    return AutoBoxingTools.getAutoBoxingTools();
  }

  /**
   * Method returns the cache tools implementation of the current environment.
   * 
   * @return {@link CacheTools} Cache tools implementation that is used in the current environment. The method never
   * returns null.
   */
  public static CacheTools getCacheTools( ) {
    return CacheTools.getCacheTools();
  }

  /**
   * Method returns the collection tools implementation of the current environment.
   * 
   * @return {@link CollectionTools} Collection tools implementation that is used in the current environment. The method
   * never returns null.
   */
  public static CollectionTools getCollectionTools( ) {
    return CollectionTools.getCollectionTools();
  }

  /**
   * Method returns the date tools implementation of the current environment.
   * 
   * @return {@link DateTools} Date tools implementation that is used in the current environment. The method never
   * returns null.
   */
  public static DateTools getDateTools( ) {
    return DateTools.getDateTools();
  }

  /**
   * Method returns the configured implementation of encoding tools.
   * 
   * @return {@link EncodingTools} Encoding Tools implementation. The method never returns null.
   */
  public static EncodingTools getEncodingTools( ) {
    return EncodingTools.getEncodingTools();
  }

  /**
   * Method returns the encryption tools implementation of the current environment.
   * 
   * @return {@link EncryptionTools} Encryption tools implementation that is used in the current environment. The method
   * never returns null.
   */
  public static EncryptionTools getEncryptionTools( ) {
    return EncryptionTools.getEncryptionTools();
  }

  /**
   * Method returns the file tools implementation of the current environment.
   * 
   * @return {@link FileTools} file tools implementation that is used in the current environment. The method never
   * returns null.
   */
  public static FileTools getFileTools( ) {
    return FileTools.getFileTools();
  }

  /**
   * Method returns the locale tools implementation of the current environment.
   * 
   * @return {@link LocaleTools} locale tools implementation that is used in the current environment. The method never
   * returns null.
   */
  public static LocaleTools getLocaleTools( ) {
    return LocaleTools.getLocaleTools();
  }

  /**
   * Method returns the monitoring tools that are configured.
   * 
   * @return {@link MonitoringTools} Current implementation of monitoring tools. The method never returns null.
   */
  public static MonitoringTools getMonitoringTools( ) {
    return MonitoringTools.getMonitoringTools();
  }

  /**
   * Method returns the networking tools implementation of the current environment.
   * 
   * @return {@link NetworkingTools} networking tools implementation that is used in the current environment. The method
   * never returns null.
   */
  public static NetworkingTools getNetworkingTools( ) {
    return NetworkingTools.getNetworkingTools();
  }

  /**
   * Method returns the performance tools implementation for the current environment.
   * 
   * @return {@link PerformanceTools} Performance tools implementation that is used for the current environment. The
   * method never returns null.
   */
  public static PerformanceTools getPerformanceTools( ) {
    return PerformanceTools.getPerformanceTools();
  }

  /**
   * Method returns the reflection tools implementation of the current environment.
   * 
   * @return {@link ReflectionTools} reflection tools implementation that is used in the current environment. The method
   * never returns null.
   */
  public static ReflectionTools getReflectionTools( ) {
    return ReflectionTools.getReflectionTools();
  }

  /**
   * Method returns the regular expression tools implementation for the current environment.
   * 
   * @return {@link RegExpTools} Regular expression tools implementation that is used for the current environment. The
   * method never returns null.
   */
  public static RegExpTools getRegExpTools( ) {
    return RegExpTools.getRegExpTools();
  }

  /**
   * Method returns the serialization tools implementation of the current environment.
   * 
   * @return {@link SerializationTools} Serialization tools implementation that is used in the current environment. The
   * method never returns null.
   */
  public static SerializationTools getSerializationTools( ) {
    return SerializationTools.getSerializationTools();
  }

  /**
   * Method returns the SSL tools implementation for the current environment.
   * 
   * @return {@link SSLToolss} SSL tools implementation that is used for the current environment. The method never
   * returns null.
   */
  public static SSLTools getSSLTools( ) {
    return SSLTools.getSSLTools();
  }

  /**
   * Method returns the stream tool implementation that is configured to be used.
   * 
   * @return {@link StreamTools} Stream tools implementation. The method never returns null.
   */
  public static StreamTools getStreamTools( ) {
    return StreamTools.getStreamTools();
  }

  /**
   * Method returns the string tools implementation of the current environment.
   * 
   * @return {@link StringTools} String tools implementation that is used in the current environment. The method never
   * returns null.
   */
  public static StringTools getStringTools( ) {
    return StringTools.getStringTools();
  }

  /**
   * Method returns the validation tools implementation for the current environment.
   * 
   * @return {@link ValidationTools} Validation tools implementation that is used for the current environment. The
   * method never returns null.
   */
  public static ValidationTools getValidationTools( ) {
    return ValidationTools.getValidationTools();
  }

  /**
   * Method returns the web tools implementation for the current environment.
   * 
   * @return {@link WebTools} web tools implementation that is used for the current environment. The method never
   * returns null.
   */
  public static WebTools getWebTools( ) {
    return WebTools.getWebTools();
  }

  /**
   * Method returns the XML tools implementation of the current environment.
   * 
   * @return {@link XMLTools} XML tools implementation that is used in the current environment. The method never returns
   * null.
   */
  public static XMLTools getXMLTools( ) {
    return XMLTools.getXMLTools();
  }

  /**
   * Method returns the configured implementation of the pooling tools.
   * 
   * @return PoolingTools Configured implementation of pooling tools. The method never returns null.
   */
  public static PoolingTools getPoolingTools( ) {
    return PoolingTools.getPoolingTools();
  }
}

/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;

/**
 * Interface defines methods that are available to make the use of streams as simple as possible.
 * 
 * @author JEAF Development Team
 */
public interface StreamTools {
  /**
   * Configured implementation of stream tools.
   */
  static final StreamTools STREAM_TOOLS = ToolsLoader.getTools(StreamTools.class);

  /**
   * Method returns the configured implementation of the Stream Tools.
   * 
   * @return {@link StreamTools} Configured implementation of stream tools. The method never returns null.
   */
  static StreamTools getStreamTools( ) {
    return STREAM_TOOLS;
  }

  /**
   * Method returns the content of the passed stream.
   * 
   * @param pInputStream Input stream from which the content should be returned. The parameter must not be null.
   * @return byte[] byte Array with the content of the file. The method never returns null. If the file is zero bytes
   * then an empty array with length 0 will be returned.
   * @throws IOException
   */
  byte[] getStreamContent( InputStream pInputStream ) throws IOException;

  /**
   * Method returns the content of the passed stream. The file content will be converted from bytes to String using the
   * configured default encoding.
   * 
   * @param pInputStream Input stream with the content that should be returned. The parameter must not be null.
   * @return {@link String} Content of the stream as string. The method never returns null. If the stream contains zero
   * bytes then an empty String will be returned.
   * @throws IOException
   */
  String getStreamContentAsString( InputStream pInputStream ) throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pStreamName Name of the stream that will be copied. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all cases.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams )
    throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pStreamName Name of the stream that will be copied. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all cases.
   * @param pMaxBytes Maximum bytes that should be written. If the streams contains more bytes then the copy process
   * will be aborted.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams,
      long pMaxBytes )
    throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pStreamName Name of the stream that will be copied. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all cases.
   * @param pNoBuffering Parameter defines if buffer should used or not. The parameter may be null. In this case
   * {@link BufferingMode#AUTO} will be used.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams,
      BufferingMode pBufferingMode )
    throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pStreamName Name of the stream that will be copied. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all cases.
   * @param pMaxBytes Maximum bytes that should be written. If the streams contains more bytes then the copy process
   * will be aborted.
   * @param pNoBuffering Parameter defines if buffer should used or not. The parameter may be null. In this case
   * {@link BufferingMode#AUTO} will be used.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams,
      long pMaxBytes, BufferingMode pBufferingMode )
    throws IOException;

  /**
   * Method traces information about a copy process.
   * 
   * @param pFileName Name of the file that was copied.
   * @param pByteCount Number of bytes that were copied.
   * @param pDuration Duration of the copy process in nanoseconds.
   */
  void traceIOSummary( String pFileName, long pByteCount, long pDuration, MessageID pMessageID );

}

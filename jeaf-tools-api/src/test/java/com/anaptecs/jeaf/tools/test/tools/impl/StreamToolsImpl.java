/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.stream.BufferingMode;
import com.anaptecs.jeaf.tools.api.stream.StreamTools;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;

@ToolsImplementation(toolsInterface = StreamTools.class)
public class StreamToolsImpl implements StreamTools {

  @Override
  public byte[] getStreamContent( InputStream pInputStream ) throws IOException {
    return null;
  }

  @Override
  public String getStreamContentAsString( InputStream pInputStream ) throws IOException {
    return null;
  }

  @Override
  public long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams, long pMaxBytes )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams, BufferingMode pBufferingMode )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pStreamName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams, long pMaxBytes, BufferingMode pBufferingMode )
    throws IOException {
    return 0;
  }

  @Override
  public void traceIOSummary( String pFileName, long pByteCount, long pDuration, MessageID pMessageID ) {
  }

}

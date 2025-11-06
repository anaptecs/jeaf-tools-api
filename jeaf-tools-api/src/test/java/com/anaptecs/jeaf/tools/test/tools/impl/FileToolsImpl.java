/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.test.tools.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.file.FileTools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

@ToolsImplementation(toolsInterface = FileTools.class)
public class FileToolsImpl implements FileTools {
  @Override
  public URL locateResourceURL( String pResourceName ) throws IOException {
    return null;
  }

  @Override
  public InputStream getResourceAsStream( String pResourceName ) throws IOException {
    return null;
  }

  @Override
  public byte[] getFileContent( File pFile ) throws IOException {
    return null;
  }

  @Override
  public byte[] getFileContent( String pFileName ) throws IOException {
    return null;
  }

  @Override
  public byte[] getFileContent( InputStream pInputStream ) throws IOException {
    return null;
  }

  @Override
  public String getFileContentAsString( File pFile ) throws IOException {
    return null;
  }

  @Override
  public String getFileContentAsString( String pFileName ) throws IOException {
    return null;
  }

  @Override
  public String getFileContentAsString( InputStream pInputStream ) throws IOException {
    return null;
  }

  @Override
  public List<String> readLines( InputStream pInputStream, int pFirstLine, int pAmountOfLines ) throws IOException {
    return null;
  }

  @Override
  public List<String> readLines( File pFile, int pFirstLine, int pAmountOfLines ) throws IOException {
    return null;
  }

  @Override
  public List<String> readLines( String pFileName, int pFirstLine, int pAmountOfLines ) throws IOException {
    return null;
  }

  @Override
  public String readLinesAsString( InputStream pInputStream, int pFirstLine, int pAmountOfLines ) throws IOException {
    return null;
  }

  @Override
  public String readLinesAsString( File pFile, int pFirstLine, int pAmountOfLines ) throws IOException {
    return null;
  }

  @Override
  public String readLinesAsString( String pFileName, int pFirstLine, int pAmountOfLines ) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeFileContent( OutputStream pOutputStream, String pFileContent ) throws IOException {
  }

  @Override
  public void writeFileContent( OutputStream pOutputStream, byte[] pFileContent ) throws IOException {
  }

  @Override
  public void writeFileContent( File pFile, byte[] pFileContent ) throws IOException {
  }

  @Override
  public void writeFileContent( File pFile, String pFileContent ) throws IOException {
  }

  @Override
  public void writeFileContent( String pFileName, byte[] pFileContent ) throws IOException {
  }

  @Override
  public void writeFileContent( String pFileName, String pFileContent ) throws IOException {
  }

  @Override
  public long copyFile( File pSource, File pDestination ) throws IOException {
    return 0;
  }

  @Override
  public long copyFile( String pSource, String pDestination ) throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pFileName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pFileName, InputStream pInputStream, OutputStream pOutputStream,
      boolean pCloseStreams, long pMaxSize )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pFileName, InputStream pInputStream, RandomAccessFile pFile, boolean pClose )
    throws IOException {
    return 0;
  }

  @Override
  public long copyContent( String pFileName, InputStream pInputStream, RandomAccessFile pFile, boolean pClose,
      long pMaxSize )
    throws IOException {
    return 0;
  }

  @Override
  public long calculateDirectorySize( File pDirectory ) {
    return 0;
  }

  @Override
  public void createDirectory( String pDirectoryPath ) throws JEAFSystemException {
  }

  @Override
  public void createDirectory( Path pDirectoryPath ) throws JEAFSystemException {
  }

  @Override
  public void createDirectory( File pDirectory ) throws JEAFSystemException {
  }

  @Override
  public void delete( String pFilePath ) throws JEAFSystemException {
  }

  @Override
  public void delete( Path pFilePath ) throws JEAFSystemException {
  }

  @Override
  public void delete( File pFile ) throws JEAFSystemException {
  }

  @Override
  public boolean tryDelete( String pFilePath ) {
    return false;
  }

  @Override
  public boolean tryDelete( Path pFilePath ) {
    return false;
  }

  @Override
  public boolean tryDelete( File pFile ) {
    return false;
  }

  @Override
  public void deleteRecursive( Path pFilePath ) throws JEAFSystemException {
  }

  @Override
  public void deleteRecursive( String pFilePath ) throws JEAFSystemException {
  }

  @Override
  public void deleteRecursive( File pFile ) throws JEAFSystemException {
  }

  @Override
  public boolean tryDeleteRecursive( String pFilePath, boolean pContinue ) {
    return false;
  }

  @Override
  public boolean tryDeleteRecursive( Path pFilePath, boolean pContinue ) {
    return false;
  }

  @Override
  public boolean tryDeleteRecursive( File pFile, boolean pContinue ) {
    return false;
  }

  @Override
  public void extractZipFile( String pZipFilePath, String pExtractDirectoryPath, long pMaxSize ) throws IOException {
  }

  @Override
  public void extractZipFile( File pZipFile, File pExtractDirectory, long pMaxSize ) throws IOException {
  }

  @Override
  public String getBaseName( Path pFile ) {
    return null;
  }

  @Override
  public String getBaseName( File pFile ) {
    return null;
  }

  @Override
  public String getBaseName( String pFilename ) {
    return null;
  }

  @Override
  public String getExtension( Path pFile ) {
    return null;
  }

  @Override
  public String getExtension( File pFile ) {
    return null;
  }

  @Override
  public String getExtension( String pFilename ) {
    return null;
  }

  @Override
  public Date getCreationTime( File pFile ) {
    return null;
  }

  @Override
  public Date getLastModificationTime( File pFile ) {
    return null;
  }

  @Override
  public Date getLastAccessTime( File pFile ) {
    return null;
  }

  @Override
  public Calendar getCreation( File pFile ) {
    return null;
  }

  @Override
  public Calendar getLastModification( File pFile ) {
    return null;
  }

  @Override
  public Calendar getLastAccess( File pFile ) {
    return null;
  }

  @Override
  public FilenameFilter createExtensionFilenameFilter( List<String> pAcceptedExtensions ) {
    return null;
  }

  @Override
  public FilenameFilter createExtensionFilenameFilter( List<String> pAcceptedExtensions, List<String> pExclusionList ) {
    return null;
  }

  @Override
  public List<File> listFiles( File pDirectory ) {
    return null;
  }

  @Override
  public List<File> listFiles( File pDirectory, List<String> pAcceptedExtensions, List<String> pExclusionList ) {
    return null;
  }

  @Override
  public List<File> listFiles( File pDirectory, FilenameFilter pFileFilter ) {
    return null;
  }

  @Override
  public List<String> listFiles( String pDirectoryName ) {
    return null;
  }

  @Override
  public List<String> listFiles( String pDirectoryName, List<String> pAcceptedExtensions,
      List<String> pExclusionList ) {
    return null;
  }

  @Override
  public List<String> listFiles( String pDirectoryName, FilenameFilter pFileFilter ) {
    return null;
  }

}

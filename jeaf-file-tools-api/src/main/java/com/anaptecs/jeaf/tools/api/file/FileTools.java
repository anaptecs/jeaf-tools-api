/**
 * Copyright 2004 - 2013 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.file;

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

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines the methods that are available to make the use of Java's handling with files as simple as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface FileTools {
  /**
   * Configured implementation of file tools.
   */
  static final FileTools FILE_TOOLS = ToolsLoader.getTools(FileTools.class);

  /**
   * Method returns the configured implementation of the File Tools.
   * 
   * @return {@link FileTools} Configured implementation of file tools. The method never returns null.
   */
  static FileTools getFileTools( ) {
    return FILE_TOOLS;
  }

  /**
   * Method tries to locate the resource with the passed name within the class path of this application. Therefore the
   * class uses the class loader that was used to load this class.
   * 
   * @param pResourceName Name of the resource that should be loaded. The parameter must not be null.
   * @return URL URL of the resource with the passed name. The method never returns null.
   * @throws IOException if the resource could not be found.
   */
  URL locateResourceURL( String pResourceName ) throws IOException;

  /**
   * Method tries to locate the resource within the class path of this application and return it as Stream. Therefore
   * the class uses the class loader that was use to load this class.
   * 
   * @param pResourceName Name of the resource that should be loaded. The parameter must not be null.
   * @return InputStream from the resource.
   * @throws IOException if the resource could not be found.
   */
  InputStream getResourceAsStream( String pResourceName ) throws IOException;

  /**
   * Method returns the content of the passed file.
   * 
   * @param pFile File whose content should be returned. The parameter must not be null.
   * @return byte[] byte Array with the content of the file. The method never returns null. If the file is zero bytes
   * then an empty array with length 0 will be returned.
   * @throws IOException
   */
  byte[] getFileContent( File pFile ) throws IOException;

  /**
   * Method returns the content of the file with the passed name.
   * 
   * @param pFileName Name of the file whose content should be returned. The parameter must not be null.
   * @return byte[] byte Array with the content of the file. The method never returns null. If the file is zero bytes
   * then an empty array with length 0 will be returned.
   * @throws IOException
   */
  byte[] getFileContent( String pFileName ) throws IOException;

  /**
   * Method returns the content of the file with the passed name.
   * 
   * @param pInputStream Input stream from which the content should be returned. The parameter must not be null.
   * @return byte[] byte Array with the content of the file. The method never returns null. If the file is zero bytes
   * then an empty array with length 0 will be returned.
   * @throws IOException
   */
  byte[] getFileContent( InputStream pInputStream ) throws IOException;

  /**
   * Method returns the content of the passed file. The file content will be converted from bytes to String using the
   * current encoding.
   * 
   * @param pFile File whose content should be returned. The parameter must not be null.
   * @return {@link String} Content of the file as string. The method never returns null. If the file is zero bytes then
   * an empty String will be returned.
   * @throws IOException
   */
  String getFileContentAsString( File pFile ) throws IOException;

  /**
   * Method returns the content of the file with the passed name. The file content will be converted from bytes to
   * String using the current encoding.
   * 
   * @param pFileName Name of the file whose content should be returned. The parameter must not be null.
   * @return {@link String} Content of the file as string. The method never returns null. If the file is zero bytes then
   * an empty String will be returned.
   * @throws IOException
   */
  String getFileContentAsString( String pFileName ) throws IOException;

  /**
   * Method returns the content of the file with the passed name. The file content will be converted from bytes to
   * String using the current encoding.
   * 
   * @param pInputStream Input stream with the content that should be returned. The parameter must not be null.
   * @return {@link String} Content of the stream as string. The method never returns null. If the stream contains zero
   * bytes then an empty String will be returned.
   * @throws IOException
   */
  String getFileContentAsString( InputStream pInputStream ) throws IOException;

  /**
   * Method reads the passed amount of lines from the passed input stream.
   * 
   * @param pInputStream Input stream from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link List} List of Strings. Each string represents a single line of the file. The method never returns
   * null.
   */
  List<String> readLines( InputStream pInputStream, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method reads the passed amount of lines from the passed file.
   * 
   * @param pFile File from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link List} List of Strings. Each string represents a single line of the file. The method never returns
   * null.
   */
  List<String> readLines( File pFile, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method reads the passed amount of lines from the file with the passed name.
   * 
   * @param pFileName Name of the file from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link List} List of Strings. Each string represents a single line of the file. The method never returns
   * null.
   */
  List<String> readLines( String pFileName, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method returns the passed amount of lines from the passed input stream as one String. {@link File#separator} will
   * be used as separator for each line.
   * 
   * @param pInputStream Input stream from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link String} String containing all the lines that were read. The method never returns null.
   */
  String readLinesAsString( InputStream pInputStream, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method returns the passed amount of lines from the passed file as one String. {@link File#separator} will be used
   * as separator for each line.
   * 
   * @param pFile File from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link String} String containing all the lines that were read. The method never returns null.
   */
  String readLinesAsString( File pFile, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method returns the passed amount of lines from the file with passed name as one String. {@link File#separator} will
   * be used as separator for each line.
   * 
   * @param pFileName Name of the file from which the content should be read. The parameter must not be null.
   * @param pFirstLine Index of the first line that should be read. Index starts with 0. The value must be zero or
   * greater.
   * @param pAmountOfLines Amount of lines that should be read. The value must be greater than zero.
   * @return {@link String} String containing all the lines that were read. The method never returns null.
   */
  String readLinesAsString( String pFileName, int pFirstLine, int pAmountOfLines ) throws IOException;

  /**
   * Method writes the passed content to the passed stream.
   * 
   * @param pOutputStream Output stream to which the content should be written. The parameter must not be null and its
   * the caller's responsibility to close the stream again.
   * @param pFileContent Content as string that should be written. The parameter may be null. In this case the file will
   * be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( OutputStream pOutputStream, String pFileContent ) throws IOException;

  /**
   * Method writes the passed content to the passed stream.
   * 
   * @param pOutputStream Output stream to which the content should be written. The parameter must not be null and its
   * the caller's responsibility to close the stream again.
   * @param pFileContent Byte array with the content that should be written. The parameter may be null. In this case the
   * file will be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( OutputStream pOutputStream, byte[] pFileContent ) throws IOException;

  /**
   * Method writes the passed content to the passed file.
   * 
   * @param pFile File whose content should be written. The parameter must not be null.
   * @param pFileContent Byte array with the content that should be written. The parameter may be null. In this case the
   * file will be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( File pFile, byte[] pFileContent ) throws IOException;

  /**
   * Method writes the passed content to the passed file.
   * 
   * @param pFile File whose content should be written. The parameter must not be null.
   * @param pFileContent String with the content that should be written. The parameter may be null. In this case the
   * file will be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( File pFile, String pFileContent ) throws IOException;

  /**
   * Method writes the passed content to the file with the passed name.
   * 
   * @param pFileName Name of the file whose content should be written. The parameter must not be null.
   * @param pFileContent Byte array with the content that should be written. The parameter may be null. In this case the
   * file will be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( String pFileName, byte[] pFileContent ) throws IOException;

  /**
   * Method writes the passed content to the file with the passed name.
   * 
   * @param pFileName Name of the file whose content should be written. The parameter must not be null.
   * @param pFileContent String with the content that should be written. The parameter may be null. In this case the
   * file will be empty.
   * @throws IOException Signals that an I/O exception has occurred.
   */
  void writeFileContent( String pFileName, String pFileContent ) throws IOException;

  /**
   * Method copies the file with the passed name to the passed destination.
   * 
   * @param pSource Name of the file that should be copied. The parameter must not be null.
   * @param pDestination Name of the destination file. The parameter must not be null.
   * @return long Size of the copied file in bytes.
   * @throws IOException if an error occurs when trying to copy the file.
   */
  long copyFile( String pSource, String pDestination ) throws IOException;

  /**
   * Method copies the file with the passed name to the passed destination.
   * 
   * @param pSource File that should be copied. The parameter must not be null.
   * @param pDestination Destination file. The parameter must not be null.
   * @return long Size of the copied file in bytes.
   * @throws IOException if an error occurs when trying to copy the file.
   */
  long copyFile( File pSource, File pDestination ) throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pFileName Name of the file that will be copied using streams. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all cases.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pFileName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams )
    throws IOException;

  /**
   * Method copies the content of the input stream to the passed output stream.
   * 
   * @param pFileName Name of the file that will be copied using streams. The name is only required for tracing.
   * @param pInputStream Source of the data that should be copied. The parameter must not be null.
   * @param pOutputStream Destination where the data should be copied to. The parameter must not be null.
   * @param pCloseStreams If the parameter is set to true then the streams will be closed in all case.
   * @param pMaxBytes Maximum bytes that should be written. If the streams contains more bytes then the copy process
   * will be aborted. It's the responsibility of the caller to delete the created file if desired.
   * @return long Number of bytes that where copied.
   * @throws IOException If an exception occurs during copying.
   */
  long copyContent( String pFileName, InputStream pInputStream, OutputStream pOutputStream, boolean pCloseStreams,
      long pMaxBytes )
    throws IOException;

  /**
   * Method transfers the content of the passed input stream to the passed file.
   * 
   * @param pFileName Name of the target file. The parameter must not be null.
   * @param pInputStream Input stream. The parameter must not be null.
   * @param pFile File to which the input stream should be written. The parameter must not be null.
   * @param pClose If the parameter is set to true then the stream and file will be closed in any cases.
   * @return long Number of bytes that were copied.
   * @throws IOException If an exception occurs during copying.
   */
  public long copyContent( String pFileName, InputStream pInputStream, RandomAccessFile pFile, boolean pClose )
    throws IOException;

  /**
   * Method transfers the content of the passed input stream to the passed file.
   * 
   * @param pFileName Name of the target file. The parameter must not be null.
   * @param pInputStream Input stream. The parameter must not be null.
   * @param pFile File to which the input stream should be written. The parameter must not be null.
   * @param pClose If the parameter is set to true then the stream and file will be closed in any case.
   * @param pMaxBytes Maximum bytes that should be written. If the streams contains more bytes then the copy process
   * will be aborted. It's the responsibility of the caller to delete the created file if desired.
   * @return long Number of bytes that were copied.
   * @throws IOException If an exception occurs during copying.
   */
  public long copyContent( String pFileName, InputStream pInputStream, RandomAccessFile pFile, boolean pClose,
      long pMaxBytes )
    throws IOException;

  /**
   * Method recursively calculates the size of the passed directory.
   * 
   * @param pDirectory Path to directory whose size should be calculated. Parameter must not be null and has to point to
   * an existing directory.
   * @return long Size in byte of the directory.
   */
  long calculateDirectorySize( File pDirectory );

  /**
   * Method creates a new directory. If a directory already exists then nothing happens.
   * 
   * @param pDirectoryPath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the new directory cold not be created for some reason.
   */
  void createDirectory( String pDirectoryPath ) throws JEAFSystemException;

  /**
   * Method creates a new directory. If a directory already exists then nothing happens.
   * 
   * @param pDirectoryPath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the new directory cold not be created for some reason.
   */
  void createDirectory( Path pDirectoryPath ) throws JEAFSystemException;

  /**
   * Method creates a new directory. If a directory already exists then nothing happens.
   * 
   * @param pDirectory Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the new directory cold not be created for some reason.
   */
  void createDirectory( File pDirectory ) throws JEAFSystemException;

  /**
   * Method deletes the file or directory with the passed path. If the passed file path points to a directory then it
   * can only be deleted if it is empty. If the file could not be deleted the method will throw an exception.
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file path could not be deleted.
   */
  void delete( String pFilePath ) throws JEAFSystemException;

  /**
   * Method deletes the file or directory with the passed path. If the passed file path points to a directory then it
   * can only be deleted if it is empty. If the file could not be deleted the method will throw an exception.
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file path could not be deleted.
   */
  void delete( Path pFilePath ) throws JEAFSystemException;

  /**
   * Method deleted the passed file object. If the passed file object points to a directory then it can only be deleted
   * if it is empty. If the file could not be deleted the method will throw an exception.
   * 
   * @param pFile File object that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file object could not be deleted.
   */
  void delete( File pFile ) throws JEAFSystemException;

  /**
   * Method deletes the file or directory with the passed path. If the passed file path points to a directory then it
   * can only be deleted if it is empty. If the file could not be deleted the method return false.
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @return boolean Method returns true if the file could be deleted and false if not.
   */
  boolean tryDelete( String pFilePath );

  /**
   * Method deletes the file or directory with the passed path. If the passed file path points to a directory then it
   * can only be deleted if it is empty. If the file could not be deleted the method return false.
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @return boolean Method returns true if the file could be deleted and false if not.
   */
  boolean tryDelete( Path pFilePath );

  /**
   * Method deleted the passed file object. If the passed file object points to a directory then it can only be deleted
   * if it is empty. If the file could not be deleted the method return false.
   * 
   * @param pFile File object that should be deleted. The parameter must not be null.
   * @return boolean Method returns true if the file could be deleted and false if not.
   */
  boolean tryDelete( File pFile );

  /**
   * Method deletes the passed file path and all of its child elements if it is a directory. If the passed file path
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file path or any of its child elements could not be deleted.
   */
  void deleteRecursive( Path pFilePath ) throws JEAFSystemException;

  /**
   * Method deletes the passed file path and all of its child elements if it is a directory. If the passed file path
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file path or any of its child elements could not be deleted.
   */
  void deleteRecursive( String pFilePath ) throws JEAFSystemException;

  /**
   * Method deletes the passed file object and all of its child elements if it is a directory. If the passed file object
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFile File object that should be deleted. The parameter must not be null.
   * @throws JEAFSystemException if the passed file object or any of its child elements could not be deleted.
   */
  void deleteRecursive( File pFile ) throws JEAFSystemException;

  /**
   * Method deletes the passed file path and all of its child elements if it is a directory. If the passed file path
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @param pContinue Parameter defines if the method should try to delete further files if one file or directory can
   * not be deleted. <code>true</code> means that the method continues to try to delete and <code>false</code> not.
   * @return boolean Method returns true if the file or directory could be deleted and false if not.
   */
  boolean tryDeleteRecursive( String pFilePath, boolean pContinue );

  /**
   * Method deletes the passed file path and all of its child elements if it is a directory. If the passed file path
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFilePath Path of the file or directory that should be deleted. The parameter must not be null.
   * @param pContinue Parameter defines if the method should try to delete further files if one file or directory can
   * not be deleted. <code>true</code> means that the method continues to try to delete and <code>false</code> not.
   * @return boolean Method returns true if the file or directory could be deleted and false if not.
   */
  boolean tryDeleteRecursive( Path pFilePath, boolean pContinue );

  /**
   * Method deletes the passed file object and all of its child elements if it is a directory. If the passed file object
   * points to a directory then the directory may also contain other files and directories which will be deleted too.
   * The method thus is equivalent to "rm -rf".
   * 
   * @param pFile File object that should be deleted. The parameter must not be null.
   * @param pContinue Parameter defines if the method should try to delete further files if one file or directory can
   * not be deleted. <code>true</code> means that the method continues to try to delete and <code>false</code> not.
   * @return boolean Method returns true if the file or directory could be deleted and false if not.
   */
  boolean tryDeleteRecursive( File pFile, boolean pContinue );

  /**
   * Method extracts the passed zip file to the passed directory.
   * 
   * @param pZipFilePath Zip file that should be extracted. The parameter must not be null.
   * @param pExtractDirectoryPath Directory to which the zip file should be extracted. The extract directory must
   * already exist. The parameter must not be null
   * @param pMaxSize Maximum size that the extracted archive may consume on the file system. The parameter is required
   * for security reasons to prevent Zip Bomb attacks. If the check should not be executed then {@link Long#MAX_VALUE}
   * should be passed as maximum size.
   * @throws IOException if an IOException occurs when trying to extract the passed zip file.
   */
  void extractZipFile( String pZipFilePath, String pExtractDirectoryPath, long pMaxSize ) throws IOException;

  /**
   * Method extracts the passed zip file to the passed directory.
   * 
   * @param pZipFile Zip file that should be extracted. The parameter must not be null.
   * @param pExtractDirectory Directory to which the zip file should be extracted. The extract directory must already
   * exist. The parameter must not be null
   * @param pMaxSize Maximum size that the extracted archive may consume on the file system. The parameter is required
   * for security reasons to prevent Zip Bomb attacks. If the check should not be executed then {@link Long#MAX_VALUE}
   * should be passed as maximum size.
   * @throws IOException if an IOException occurs when trying to extract the passed zip file.
   */
  void extractZipFile( File pZipFile, File pExtractDirectory, long pMaxSize ) throws IOException;

  /**
   * Method returns the name of the file without its extension.
   * 
   * @param pFile The file. The parameter must not be null.
   * @return {@link String} Base name of the file. If the file has no base name then null will be returned.
   */
  String getBaseName( Path pFile );

  /**
   * Method returns the name of the file without its extension.
   * 
   * @param pFile The file. The parameter must not be null.
   * @return {@link String} Base name of the file. If the file has no base name then null will be returned.
   */
  String getBaseName( File pFile );

  /**
   * Method returns the name of the file without its extension.
   * 
   * @param pFilename Complete name of the file. The parameter must not be null.
   * @return {@link String} Base name of the file. If the file has no base name then null will be returned.
   */
  String getBaseName( String pFilename );

  /**
   * Method returns the extension of the passed file name.
   * 
   * @param pFile The file. The parameter must not be null.
   * @return {@link String} Extension of the file. Method returns null if the file name has no extension.
   */
  String getExtension( Path pFile );

  /**
   * Method returns the extension of the passed file name.
   * 
   * @param pFile The file. The parameter must not be null.
   * @return {@link String} Extension of the file. Method returns null if the file name has no extension.
   */
  String getExtension( File pFile );

  /**
   * Method returns the extension of the passed file name.
   * 
   * @param pFilename Complete name of the file. The parameter must not be null.
   * @return {@link String} Extension of the file. Method returns null if the file name has no extension.
   */
  String getExtension( String pFilename );

  /**
   * Method returns the creation time of the file as {@link Date}.
   * 
   * @param pFile File for which the creation time should be returned. The parameter must not be null.
   * @return {@link Date} Creation time of the file. The method never returns null.
   */
  Date getCreationTime( File pFile );

  /**
   * Method returns the last modification of the file as {@link Date}.
   * 
   * @param pFile File for which the last modification time should be returned. The parameter must not be null.
   * @return {@link Date} Last modification time of the file. The method never returns null.
   */
  Date getLastModificationTime( File pFile );

  /**
   * Method returns the last access time of the file as {@link Date}.
   * 
   * @param pFile File for which the last access time should be returned. The parameter must not be null.
   * @return {@link Date} Last access time of the file. The method never returns null.
   */
  Date getLastAccessTime( File pFile );

  /**
   * Method returns the creation time of the file as {@link Calendar}.
   * 
   * @param pFile File for which the creation time should be returned. The parameter must not be null.
   * @return {@link Calendar} Creation time of the file. The method never returns null.
   */
  Calendar getCreation( File pFile );

  /**
   * Method returns the last modification of the file as {@link Calendar}.
   * 
   * @param pFile File for which the last modification time should be returned. The parameter must not be null.
   * @return {@link Calendar} Last modification time of the file. The method never returns null.
   */
  Calendar getLastModification( File pFile );

  /**
   * Method returns the last access time of the file as {@link Calendar}.
   * 
   * @param pFile File for which the last access time should be returned. The parameter must not be null.
   * @return {@link Calendar} Last access time of the file. The method never returns null.
   */
  Calendar getLastAccess( File pFile );

  /**
   * Method creates a new file name filter that filters based on the passed extensions.
   * 
   * @param pAcceptedExtensions List contains the white list for all file extensions that should be accepted by the
   * filter. The extensions can be provided with or without a leading star operator (*.txt or .txt / *.hbm.xml or
   * .hbm.xml). First characters must either be '*.' or '.' and the trimmed string must at least contain 1 real
   * character in addition to the mentioned prefix. If the passed list of accepted extensions is null or empty then this
   * means that all extensions are accepted.
   */
  FilenameFilter createExtensionFilenameFilter( List<String> pAcceptedExtensions );

  /**
   * Method creates a new file name filter that filters based on the passed extensions. The exclusion list is an
   * additional feature of the filter in addition to the extension based filtering.
   * 
   * @param pAcceptedExtensions List contains the white list for all file extensions that should be accepted by the
   * filter. The extensions can be provided with or without a leading star operator (*.txt or .txt / *.hbm.xml or
   * .hbm.xml). First characters must either be '*.' or '.' and the trimmed string must at least contain 1 real
   * character in addition to the mentioned prefix. If the passed list of accepted extensions is null or empty then this
   * means that all extensions are accepted.
   * @param pExclusionList List contains names of all files that should be excluded by the filter. The file names must
   * not contain any path information. The parameter may be null.
   */
  FilenameFilter createExtensionFilenameFilter( List<String> pAcceptedExtensions, List<String> pExclusionList );

  /**
   * Method returns all files that are inside the passed directory.
   * 
   * @param pDirectory Directory that should be used as the basis for the lookup for files. The parameter must not be
   * null and the passed File object must be an existing directory.
   * @return {@link List} List with all files that were found. The method never returns null.
   */
  List<File> listFiles( File pDirectory );

  /**
   * Method returns all files that are inside the passed directory and match the passed filter criteria.
   * 
   * @param pDirectory Directory that should be used as the basis for the lookup for files. The parameter must not be
   * null and the passed File object must be an existing directory.
   * @param pAcceptedExtensions List contains the white list for all file extensions that should be accepted by the
   * filter. The extensions can be provided with or without a leading star operator (*.txt or .txt / *.hbm.xml or
   * .hbm.xml). First characters must either be '*.' or '.' and the trimmed string must at least contain 1 real
   * character in addition to the mentioned prefix. If the passed list of accepted extensions is null or empty then this
   * means that all extensions are accepted.
   * @param pExclusionList List contains names of all files that should be excluded by the filter. The file names must
   * not contain any path information. The parameter may be null.
   * @return {@link List} List with all files that were found according to the passed filter criteria. The method never
   * returns null.
   */
  List<File> listFiles( File pDirectory, List<String> pAcceptedExtensions, List<String> pExclusionList );

  /**
   * Method returns all files that are inside the passed directory and match the passed filter criteria.
   * 
   * @param pDirectory Directory that should be used as the basis for the lookup for files. The parameter must not be
   * null and the passed File object must be an existing directory.
   * @param pFileFilter File filter that should be used to filter directory content. Only files that are accepted by the
   * passed filter will be returned. The parameter may be null.
   * @return {@link List} List with all files that were found according to the passed filter criteria. The method never
   * returns null.
   */
  List<File> listFiles( File pDirectory, FilenameFilter pFileFilter );

  /**
   * Method returns all files that are inside the passed directory.
   * 
   * @param pDirectoryName Name of the Directory that should be used as the basis for the lookup for files. The
   * parameter must not be null and the passed file must be a directory.
   * @return {@link List} List with all files that were found. The method never returns null.
   */
  List<String> listFiles( String pDirectoryName );

  /**
   * Method returns the names of all files that are inside the passed directory and match the passed filter criteria.
   * 
   * @param pDirectoryName Name of the Directory that should be used as the basis for the lookup for files. The
   * parameter must not be null and the passed file must be a directory.
   * @param pAcceptedExtensions List contains the white list for all file extensions that should be accepted by the
   * filter. The extensions can be provided with or without a leading star operator (*.txt or .txt / *.hbm.xml or
   * .hbm.xml). First characters must either be '*.' or '.' and the trimmed string must at least contain 1 real
   * character in addition to the mentioned prefix. If the passed list of accepted extensions is null or empty then this
   * means that all extensions are accepted.
   * @param pExclusionList List contains names of all files that should be excluded by the filter. The file names must
   * not contain any path information. The parameter may be null.
   * @return {@link List} List with all file names that were found according to the passed filter criteria. The method
   * never returns null.
   */
  List<String> listFiles( String pDirectoryName, List<String> pAcceptedExtensions, List<String> pExclusionList );

  /**
   * Method returns all files that are inside the passed directory and match the passed filter criteria.
   * 
   * @param pDirectoryName Name of the Directory that should be used as the basis for the lookup for files. The
   * parameter must not be null and the passed file must be a directory.
   * @param pFileFilter File filter that should be used to filter directory content. Only files that are accepted by the
   * passed filter will be returned. The parameter may be null.
   * @return {@link List} List with all files that were found according to the passed filter criteria. The method never
   * returns null.
   */
  List<String> listFiles( String pDirectoryName, FilenameFilter pFileFilter );

}

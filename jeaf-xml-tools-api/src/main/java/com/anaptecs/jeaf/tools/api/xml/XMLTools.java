/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.xml;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Interface defines methods to make the handling of XML data as easy as possible.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.2
 */
public interface XMLTools {
  /**
   * Configured implementation of XML tools.
   */
  static final XMLTools XML_TOOLS = ToolsLoader.getTools(XMLTools.class);

  /**
   * Method returns the configured implementation of the XML Tools.
   * 
   * @return {@link XMLTools} Configured implementation of XML tools. The method never returns null.
   */
  static XMLTools getXMLTools( ) {
    return XML_TOOLS;
  }

  /**
   * Method creates a new and empty DOM document and returns it.
   * 
   * @return Document Created DOM document. The method never returns null.
   * @throws ParserConfigurationException if no non validating document builder can be created.
   */
  Document createDocument( ) throws ParserConfigurationException;

  /**
   * Method creates new DocumentBuilder object, which already has an error handler set. This error handler reacts on all
   * occurring problems with an exception.
   * 
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be created or not. If the
   * parameter is true, a validating one is created, otherwise not.
   * @return DocumentBuilder Created DocumentBuilder object. The method never returns null.
   * @throws ParserConfigurationException if no DocumentBuilder object could be created.
   */
  DocumentBuilder createDocumentBuilder( boolean pValidating ) throws ParserConfigurationException;

  /**
   * Method creates a new DOM document out of the file with the passed file name. Therefore a DocumentBuilder object is
   * used that is depending on parameter pValidating either validated or not.
   * 
   * @param pFileName Name of the file out of which the DOM document should be created. The parameter must not be null.
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be used to create the new
   * DOM document. If the parameter is true, the document is validated, otherwise not.
   * @return Document Created DOM document. The returned document is already normalized. The method never returns null.
   * @throws JEAFSystemException if no DocumentBuilder object could be created or an error occurs during the parsing
   * process or an error occurs while reading from the file with the passed name.
   */
  Document parseFile( String pFileName, boolean pValidating ) throws JEAFSystemException;

  /**
   * Method creates a new DOM document out of the file with the passed file name. Therefore a DocumentBuilder object is
   * used that is depending on parameter pValidating either validated or not.
   * 
   * @param pFileName Name of the file out of which the DOM document should be created. The parameter must not be null.
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be used to create the new
   * DOM document. If the parameter is true, the document is validated, otherwise not.
   * @param pSystemID The system id provides the base for resolving relative URIs during the parsing process. The
   * parameter may be null.
   * @return Document Created DOM document. The returned document is already normalized. The method never returns null.
   * @throws JEAFSystemException if no DocumentBuilder object could be created or an error occurs during the parsing
   * process or an error occurs while reading from the file with the passed name.
   */
  Document parseFile( String pFileName, boolean pValidating, String pSystemID ) throws JEAFSystemException;

  /**
   * Method creates a new DOM document out of the file with the passed file name. Therefore a DocumentBuilder object is
   * used that is depending on parameter pValidating either validated or not.
   * 
   * @param pInputStream Input stream which is used as input for the XML parser to create the DOM document. The
   * parameter must not be null. In order to improve the parsing performance the input stream will be buffered.
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be used to create the new
   * DOM document. If the parameter is true, the document is validated, otherwise not.
   * @return Document Created DOM document. The returned document is already normalized. The method never returns null.
   * @throws JEAFSystemException if no DocumentBuilder object could be created or an error occurs during the parsing
   * process or an error occurs while reading from the file with the passed name.
   */
  Document parseInputStream( InputStream pInputStream, boolean pValidating ) throws JEAFSystemException;

  /**
   * Method creates a new DOM document out of the file with the passed file name. Therefore a DocumentBuilder object is
   * used that is depending on parameter pValidating either validated or not.
   * 
   * @param pInputStream Input stream which is used as input for the XML parser to create the DOM document. The
   * parameter must not be null. In order to improve the parsing performance the input stream will be buffered.
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be used to create the new
   * DOM document. If the parameter is true, the document is validated, otherwise not.
   * @param pSystemID The system id provides the base for resolving relative URIs during the parsing process. The
   * parameter may be null.
   * @param pStreamName Name of the stream that is read. The parameter is only used in cases that an exception occurs.
   * The parameter may be null.
   * @return Document Created DOM document. The returned document is already normalized. The method never returns null.
   * @throws JEAFSystemException if no DocumentBuilder object could be created or an error occurs during the parsing
   * process or an error occurs while reading from the file with the passed name.
   */
  Document parseInputStream( InputStream pInputStream, boolean pValidating, String pSystemID, String pStreamName )
    throws JEAFSystemException;

  /**
   * Method creates a new DOM document out of the passed xml encoded string. Therefore a DocumentBuilder object is used
   * that is depending on parameter pValidating either validated or not.
   * 
   * @param pXMLEncodedString String which is used as input for the XML parser to create the DOM document. The parameter
   * must not be null.
   * @param pValidating Parameter indicates whether a validating DocumentBuilder object should be used to create the new
   * DOM document. If the parameter is true, the document is validated, otherwise not.
   * @param pSystemID The system id provides the base for resolving relative URIs during the parsing process. The
   * parameter may be null.
   * @param pStringName Name of the string that is read. The parameter is only used in cases that an exception occurs.
   * The parameter may be null.
   * @return Document Created DOM document. The returned document is already normalized. The method never returns null.
   * @throws JEAFSystemException if no DocumentBuilder object could be created or an error occurs during the parsing
   * process or an error occurs while reading from the file with the passed name.
   */
  Document parseString( String pXMLEncodedString, boolean pValidating, String pSystemID, String pStringName )
    throws JEAFSystemException;

  /**
   * Method writes the passed DOM document to the passed output stream.
   * 
   * @param pDocument DOM document that should be written to the output stream. The parameter must not be null.
   * @param pOutputStream Output stream to which the document should be written. The parameter must not be null and the
   * stream must be open. The method won't close the passed stream no matter what happens.
   */
  void writeDocument( Document pDocument, OutputStream pOutputStream );

  /**
   * Method writes the passed DOM document to the passed output stream.
   * 
   * @param pDocument DOM document that should be written to the output stream. The parameter must not be null.
   * @param pDocumentProperties Document properties define additional information like the XML Prolog and references to
   * a DTD. The parameter may be null. In this case default values will be used.
   * @param pOutputStream Output stream to which the document should be written. The parameter must not be null and the
   * stream must be open. The method won't close the passed stream no matter what happens.
   */
  void writeDocument( Document pDocument, DocumentProperties pDocumentProperties, OutputStream pOutputStream );

  /**
   * Method converts the passed XML document object to a string.
   * 
   * @param pDocument Document object that should be converted to a string. The parameter must not be null.
   * @return String Containing the complete XML document as string. The method never returns null.
   */
  String toString( Document pDocument );

  /**
   * Method converts the passed XML document object to a string.
   * 
   * @param pDocument Document object that should be converted to a string. The parameter must not be null.
   * @param pDocumentProperties Document properties define additional information like the XML Prolog and references to
   * a DTD. The parameter may be null. In this case default values will be used.
   * @return String Containing the complete XML document as string. The method never returns null.
   */
  String toString( Document pDocument, DocumentProperties pDocumentProperties );

  /**
   * Method creates a String representation if the passed element. The method does not care about any child elements.
   * 
   * @param pElement XML element that should be returned as String representation. The parameter must not be null.
   * @return {@link String} String representation of this element. The method never returns null.
   */
  String toString( Element pElement );

  /**
   * Method creates a String representation if the passed element. The method does not care about any child elements.
   * 
   * @param pElement XML element that should be returned as String representation. The parameter must not be null.
   * @param pIndent Parameter defines if the element should be indented if it has children.
   * @return {@link String} String representation of this element. The method never returns null.
   */
  String toString( Element pElement, boolean pIndent );

  /**
   * Method returns the element with the passed name form the passed subtree of a DOM document. The method requires that
   * the searched elements exists exactly once within the passed subtree.
   * 
   * @param pElementName Name of the element whose value should be returned from the subtree. There must be exactly one
   * element with the passed name in the passed subtree. The parameter must not be null.
   * @param pElement Subtree from which the element value should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * the element is required.
   * @return {@link Element} Only element within the subtree with the passed name. The method may return null if an
   * optional element is not defined in the passed subtree.
   */
  Element getSingleElement( String pElementName, Element pElement, boolean pRequired );

  /**
   * Method returns the element with the passed name form the passed DOM document. The method requires that the searched
   * elements exists exactly once within the passed subtree.
   * 
   * @param pElementName Name of the element whose value should be returned from the subtree. There must be exactly one
   * element with the passed name in the passed subtree. The parameter must not be null.
   * @param pDocument Document from which the element value should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * the element is required.
   * @return {@link Element} Only element within the subtree with the passed name. The method may return null if an
   * optional element is not defined in the passed subtree.
   */
  Element getSingleElement( String pElementName, Document pDocument, boolean pRequired );

  /**
   * Method returns all descendant elements with the passed name from the passed element.
   * 
   * @param pElementName Name of the element that should be returned from the subtree.
   * @param pElement Element who's descendants should be resolved. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * at least one element is required.
   * @return {@link List} List of all elements with the passed name in the subtree. The method never returns null.
   */
  List<Element> getDescendantElements( String pElementName, Element pElement, boolean pRequired );

  /**
   * Method returns all descendant elements with the passed name from the passed document.
   * 
   * @param pElementName Name of the element that should be returned from the subtree.
   * @param pDocument Document who's descendants should be resolved. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * at least one element is required.
   * @return {@link List} List of all elements with the passed name in the subtree. The method never returns null.
   */
  List<Element> getDescendantElements( String pElementName, Document pDocument, boolean pRequired );

  /**
   * Method returns the value of the passed element.
   * 
   * @param pElement Element whose value should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if the passed element must have a real value or if it is optional.
   * @return String Value of the passed element. The method may return null if the value is optional.
   */
  String getElementValue( Element pElement, boolean pRequired );

  /**
   * Method returns the value of the element with the passed name form the passed subtree of a DOM document. The method
   * requires that the searched elements exists exactly once within the passed subtree.
   * 
   * @param pElementName Name of the element that should be returned from the subtree. There must be exactly one element
   * with the passed name in the passed subtree. The parameter must not be null.
   * @param pElement Subtree from which the element should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * the element is required.
   * @return {@link String} Value of the element. The method may return null in cases where {@link String#trim()}
   * returns an empty string or if an optional element is not defined in the passed subtree.
   */
  String getElementValueFromSubtree( String pElementName, Element pElement, boolean pRequired );

  /**
   * Method returns the value of the element with the passed name form the passed DOM document. The method requires that
   * the searched elements exists exactly once within the passed document.
   * 
   * @param pElementName Name of the element that should be returned from the document. There must be exactly one
   * element with the passed name in the passed subtree. The parameter must not be null.
   * @param pDocument Document who's descendants should be resolved. The parameter must not be null.
   * @param pRequired Parameter defines if the searched element is required or optional. If the parameter is true than
   * the element is required.
   * @return {@link String} Value of the element. The method may return null in cases where {@link String#trim()}
   * returns an empty string or if an optional element is not defined in the passed subtree.
   */
  String getElementValueFromSubtree( String pElementName, Document pDocument, boolean pRequired );

  /**
   * Method returns the first element with the given name from the passed subtree of a DOM document. The method does not
   * require that the searched elements exist exactly once within the passed subtree.
   * 
   * @param pElementName Name of the element that should be returned from the subtree. The parameter must not be null.
   * @param pElement Subtree from which the element value should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if the passed element must have a real value or if it is optional.
   * @return {@link Element} The first element within the subtree with the passed name. The method may return null if an
   * optional element is not defined in the passed subtree.
   */
  Element getFirstChildElement( String pElementName, Element pElement, boolean pRequired );

  /**
   * Method returns the children of the passed element.
   * 
   * @param pElementName Name of the element that should be returned from the children. The parameter must not be null.
   * @param pElement Element from which the children should be returned. The parameter must not be null.
   * @param pRequired Parameter defines if at least one child is required or if it is optional.
   * @return {@link List} List of children. The method never returns null.
   */
  List<Element> getChildren( String pElementName, Element pElement, boolean pRequired );

  /**
   * Method returns the attribute with the passed name from the passed element
   * 
   * @param pElement Element whose attribute value should be returned. The parameter must not be null.
   * @param pAttributeName Name of the attribute whose value should be returned. The parameter must not be null.
   * @param pRequired Parameter defines is the attribute is required nor not.
   * @return {@link String} Value of the attribute or null if it does not exist and has no default value. In case that
   * the attribute is required then an exception instead of null will be returned.
   * @throws JEAFSystemException If parameter <code>pRequired</code> is set to true and the attribute is not present
   * then an exception will be thrown.
   */
  String getAttributeValue( Element pElement, String pAttributeName, boolean pRequired ) throws JEAFSystemException;
}

/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.api.xml;

import javax.xml.transform.OutputKeys;

/**
 * Class can be used to configure the transformation process when serialization a DOM document. Through this class thins
 * like the XML prolog and references to a DTD can be configured.
 * 
 * @author JEAF Development Team.
 * @version JEAF Release 1.5.x
 */
public class DocumentProperties {
  /**
   * {@link OutputKeys#OMIT_XML_DECLARATION}
   */
  private final boolean omitXMLDeclaration;

  /**
   * {@link OutputKeys#VERSION}
   */
  private final String version;

  /**
   * {@link OutputKeys#ENCODING}
   */
  private final String encoding;

  /**
   * {@link OutputKeys#STANDALONE}
   */
  private final boolean standalone;

  /**
   * {@link OutputKeys#DOCTYPE_PUBLIC}
   */
  private final String doctypePublic;

  /**
   * {@link OutputKeys#DOCTYPE_SYSTEM}
   */
  private final String doctypeSystem;

  /**
   * {@link OutputKeys#INDENT}
   */
  private final boolean indent;

  /**
   * {@link OutputKeys#CDATA_SECTION_ELEMENTS}
   */
  private final String cdataSectionElements;

  /**
   * Constructor is private as instances of this class can only be created using its builder.
   * 
   * @param pBuilder Builder that should be used to set attributes of this object. The parameter must not be null.
   */
  private DocumentProperties( Builder pBuilder ) {
    omitXMLDeclaration = pBuilder.omitXMLDeclaration;
    version = pBuilder.version;
    encoding = pBuilder.encoding;
    standalone = pBuilder.standalone;
    doctypePublic = pBuilder.doctypePublic;
    doctypeSystem = pBuilder.doctypeSystem;
    indent = pBuilder.indent;
    cdataSectionElements = pBuilder.cdataSectionElements;
  }

  public boolean omitXMLDeclaration( ) {
    return omitXMLDeclaration;
  }

  public String getVersion( ) {
    return version;
  }

  public String getEncoding( ) {
    return encoding;
  }

  public boolean isStandalone( ) {
    return standalone;
  }

  public String getDoctypePublic( ) {
    return doctypePublic;
  }

  public String getDoctypeSystem( ) {
    return doctypeSystem;
  }

  public boolean isIndent( ) {
    return indent;
  }

  public String getCDataSectionElements( ) {
    return cdataSectionElements;
  }

  public static class Builder {
    private boolean omitXMLDeclaration = false;

    private String version = "1.0";

    private String encoding = "UTF-8";

    private boolean standalone = true;

    private String doctypePublic;

    private String doctypeSystem;

    private boolean indent = true;

    private String cdataSectionElements = "";

    private Builder( ) {
    }

    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * {@link OutputKeys#OMIT_XML_DECLARATION}
     */
    public Builder omitXMLDeclaration( boolean pOmitXMLDeclaration ) {
      omitXMLDeclaration = pOmitXMLDeclaration;
      return this;
    }

    /**
     * {@link OutputKeys#VERSION}
     */
    public Builder setVersion( String pVersion ) {
      version = pVersion;
      return this;
    }

    /**
     * {@link OutputKeys#ENCODING}
     */
    public Builder setEncoding( String pEncoding ) {
      encoding = pEncoding;
      return this;
    }

    /**
     * {@link OutputKeys#STANDALONE}
     */
    public Builder setStandalone( boolean pStandalone ) {
      standalone = pStandalone;
      return this;
    }

    /**
     * {@link OutputKeys#DOCTYPE_PUBLIC}
     */
    public Builder setDoctypePublic( String pDoctypePublic ) {
      doctypePublic = pDoctypePublic;
      return this;
    }

    /**
     * {@link OutputKeys#DOCTYPE_SYSTEM}
     */
    public Builder setDoctypeSystem( String pDoctypeSystem ) {
      doctypeSystem = pDoctypeSystem;
      return this;
    }

    /**
     * {@link OutputKeys#INDENT}
     */
    public Builder setIndent( boolean pIndent ) {
      indent = pIndent;
      return this;
    }

    /**
     * {@link OutputKeys#CDATA_SECTION_ELEMENTS}
     */
    public Builder setCDataSectionElements( String pCdataSectionElements ) {
      cdataSectionElements = pCdataSectionElements;
      return this;
    }

    public DocumentProperties build( ) {
      return new DocumentProperties(this);
    }
  }
}

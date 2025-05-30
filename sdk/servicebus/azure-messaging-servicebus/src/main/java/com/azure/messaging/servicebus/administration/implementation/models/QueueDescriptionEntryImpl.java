// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * Represents an entry in the feed when querying queues.
 */
@Fluent
public final class QueueDescriptionEntryImpl implements XmlSerializable<QueueDescriptionEntryImpl> {
    private static final String WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM = "http://www.w3.org/2005/Atom";

    /*
     * Base URL for the query.
     */
    private String base;

    /*
     * The URL of the GET request
     */
    private String id;

    /*
     * The name of the queue
     */
    private TitleImpl title;

    /*
     * The timestamp for when this queue was published
     */
    private OffsetDateTime published;

    /*
     * The timestamp for when this queue was last updated
     */
    private OffsetDateTime updated;

    /*
     * The author that created this resource
     */
    private ResponseAuthorImpl author;

    /*
     * The URL for the HTTP request
     */
    private ResponseLinkImpl link;

    /*
     * The QueueDescription
     */
    private QueueDescriptionEntryContentImpl content;

    /**
     * Creates an instance of QueueDescriptionEntry class.
     */
    public QueueDescriptionEntryImpl() {
    }

    /**
     * Get the base property: Base URL for the query.
     * 
     * @return the base value.
     */
    public String getBase() {
        return this.base;
    }

    /**
     * Set the base property: Base URL for the query.
     * 
     * @param base the base value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setBase(String base) {
        this.base = base;
        return this;
    }

    /**
     * Get the id property: The URL of the GET request.
     * 
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: The URL of the GET request.
     * 
     * @param id the id value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the title property: The name of the queue.
     * 
     * @return the title value.
     */
    public TitleImpl getTitle() {
        return this.title;
    }

    /**
     * Set the title property: The name of the queue.
     * 
     * @param title the title value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setTitle(TitleImpl title) {
        this.title = title;
        return this;
    }

    /**
     * Get the published property: The timestamp for when this queue was published.
     * 
     * @return the published value.
     */
    public OffsetDateTime getPublished() {
        return this.published;
    }

    /**
     * Set the published property: The timestamp for when this queue was published.
     * 
     * @param published the published value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setPublished(OffsetDateTime published) {
        this.published = published;
        return this;
    }

    /**
     * Get the updated property: The timestamp for when this queue was last updated.
     * 
     * @return the updated value.
     */
    public OffsetDateTime getUpdated() {
        return this.updated;
    }

    /**
     * Set the updated property: The timestamp for when this queue was last updated.
     * 
     * @param updated the updated value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setUpdated(OffsetDateTime updated) {
        this.updated = updated;
        return this;
    }

    /**
     * Get the author property: The author that created this resource.
     * 
     * @return the author value.
     */
    public ResponseAuthorImpl getAuthor() {
        return this.author;
    }

    /**
     * Set the author property: The author that created this resource.
     * 
     * @param author the author value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setAuthor(ResponseAuthorImpl author) {
        this.author = author;
        return this;
    }

    /**
     * Get the link property: The URL for the HTTP request.
     * 
     * @return the link value.
     */
    public ResponseLinkImpl getLink() {
        return this.link;
    }

    /**
     * Set the link property: The URL for the HTTP request.
     * 
     * @param link the link value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setLink(ResponseLinkImpl link) {
        this.link = link;
        return this;
    }

    /**
     * Get the content property: The QueueDescription.
     * 
     * @return the content value.
     */
    public QueueDescriptionEntryContentImpl getContent() {
        return this.content;
    }

    /**
     * Set the content property: The QueueDescription.
     * 
     * @param content the content value to set.
     * @return the QueueDescriptionEntry object itself.
     */
    public QueueDescriptionEntryImpl setContent(QueueDescriptionEntryContentImpl content) {
        this.content = content;
        return this;
    }

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        return toXml(xmlWriter, null);
    }

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter, String rootElementName) throws XMLStreamException {
        rootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "entry" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeNamespace(WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM);
        xmlWriter.writeStringAttribute("base", this.base);
        xmlWriter.writeStringElement(WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM, "id", this.id);
        xmlWriter.writeXml(this.title, "title");
        xmlWriter.writeStringElement(WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM, "published",
            this.published == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.published));
        xmlWriter.writeStringElement(WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM, "updated",
            this.updated == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.updated));
        xmlWriter.writeXml(this.author, "author");
        xmlWriter.writeXml(this.link, "link");
        xmlWriter.writeXml(this.content, "content");
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of QueueDescriptionEntry from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of QueueDescriptionEntry if the XmlReader was pointing to an instance of it, or null if it
     * was pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the QueueDescriptionEntry.
     */
    public static QueueDescriptionEntryImpl fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of QueueDescriptionEntry from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of QueueDescriptionEntry if the XmlReader was pointing to an instance of it, or null if it
     * was pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the QueueDescriptionEntry.
     */
    public static QueueDescriptionEntryImpl fromXml(XmlReader xmlReader, String rootElementName)
        throws XMLStreamException {
        String finalRootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "entry" : rootElementName;
        return xmlReader.readObject(WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM, finalRootElementName, reader -> {
            QueueDescriptionEntryImpl deserializedQueueDescriptionEntry = new QueueDescriptionEntryImpl();
            deserializedQueueDescriptionEntry.base = reader.getStringAttribute(null, "base");
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("id".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.id = reader.getStringElement();
                } else if ("title".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.title = TitleImpl.fromXml(reader, "title");
                } else if ("published".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.published
                        = reader.getNullableElement(dateString -> CoreUtils.parseBestOffsetDateTime(dateString));
                } else if ("updated".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.updated
                        = reader.getNullableElement(dateString -> CoreUtils.parseBestOffsetDateTime(dateString));
                } else if ("author".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.author = ResponseAuthorImpl.fromXml(reader, "author");
                } else if ("link".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.link = ResponseLinkImpl.fromXml(reader, "link");
                } else if ("content".equals(elementName.getLocalPart())
                    && WWW_W3_ORG_TWO_ZERO_ZERO_FIVE_ATOM.equals(elementName.getNamespaceURI())) {
                    deserializedQueueDescriptionEntry.content
                        = QueueDescriptionEntryContentImpl.fromXml(reader, "content");
                } else {
                    reader.skipElement();
                }
            }

            return deserializedQueueDescriptionEntry;
        });
    }
}

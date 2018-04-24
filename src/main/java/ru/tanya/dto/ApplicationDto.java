package ru.tanya.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;

@JacksonXmlRootElement(localName = "Application")
public class ApplicationDto {
    @JsonProperty("APPLICATION_ID")
    @JacksonXmlProperty(isAttribute = true, localName = "application_id")
    private Long id;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    @JsonProperty("DT_CREATED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @JsonProperty("CONTACT_ID")
    @JacksonXmlProperty(isAttribute = true, localName = "contact_id")
    private Long contactId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}

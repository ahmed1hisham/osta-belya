
package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "user",
    "created_at",
    "active",
    "profile_type",
    "phones",
    "company_emails",
    "company_name",
    "state",
    "country",
    "city",
    "postal_code",
    "street",
    "email_notification",
    "order_retrieval_endpoint",
    "delivery_update_endpoint",
    "failed_attempts",
    "password",
    "custom_export_columns",
    "awb_banner",
    "email_banner",
    "delivery_status_callback",
    "merchant_external_link",
    "is_live",
    "sales_owner"
})
public class Profile {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("profile_type")
    private String profileType;
    @JsonProperty("phones")
    private List<String> phones = null;
    @JsonProperty("company_emails")
    private List<String> companyEmails = null;
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("street")
    private String street;
    @JsonProperty("email_notification")
    private Boolean emailNotification;
    @JsonProperty("order_retrieval_endpoint")
    private Object orderRetrievalEndpoint;
    @JsonProperty("delivery_update_endpoint")
    private Object deliveryUpdateEndpoint;
    @JsonProperty("failed_attempts")
    private Integer failedAttempts;
    @JsonProperty("password")
    private Object password;
    @JsonProperty("custom_export_columns")
    private List<Object> customExportColumns = null;
    @JsonProperty("awb_banner")
    private Object awbBanner;
    @JsonProperty("email_banner")
    private Object emailBanner;
    @JsonProperty("delivery_status_callback")
    private String deliveryStatusCallback;
    @JsonProperty("merchant_external_link")
    private Object merchantExternalLink;
    @JsonProperty("is_live")
    private Boolean isLive;
    @JsonProperty("sales_owner")
    private Object salesOwner;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("profile_type")
    public String getProfileType() {
        return profileType;
    }

    @JsonProperty("profile_type")
    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    @JsonProperty("phones")
    public List<String> getPhones() {
        return phones;
    }

    @JsonProperty("phones")
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @JsonProperty("company_emails")
    public List<String> getCompanyEmails() {
        return companyEmails;
    }

    @JsonProperty("company_emails")
    public void setCompanyEmails(List<String> companyEmails) {
        this.companyEmails = companyEmails;
    }

    @JsonProperty("company_name")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("company_name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("email_notification")
    public Boolean getEmailNotification() {
        return emailNotification;
    }

    @JsonProperty("email_notification")
    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    @JsonProperty("order_retrieval_endpoint")
    public Object getOrderRetrievalEndpoint() {
        return orderRetrievalEndpoint;
    }

    @JsonProperty("order_retrieval_endpoint")
    public void setOrderRetrievalEndpoint(Object orderRetrievalEndpoint) {
        this.orderRetrievalEndpoint = orderRetrievalEndpoint;
    }

    @JsonProperty("delivery_update_endpoint")
    public Object getDeliveryUpdateEndpoint() {
        return deliveryUpdateEndpoint;
    }

    @JsonProperty("delivery_update_endpoint")
    public void setDeliveryUpdateEndpoint(Object deliveryUpdateEndpoint) {
        this.deliveryUpdateEndpoint = deliveryUpdateEndpoint;
    }

    @JsonProperty("failed_attempts")
    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    @JsonProperty("failed_attempts")
    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
    }

    @JsonProperty("custom_export_columns")
    public List<Object> getCustomExportColumns() {
        return customExportColumns;
    }

    @JsonProperty("custom_export_columns")
    public void setCustomExportColumns(List<Object> customExportColumns) {
        this.customExportColumns = customExportColumns;
    }

    @JsonProperty("awb_banner")
    public Object getAwbBanner() {
        return awbBanner;
    }

    @JsonProperty("awb_banner")
    public void setAwbBanner(Object awbBanner) {
        this.awbBanner = awbBanner;
    }

    @JsonProperty("email_banner")
    public Object getEmailBanner() {
        return emailBanner;
    }

    @JsonProperty("email_banner")
    public void setEmailBanner(Object emailBanner) {
        this.emailBanner = emailBanner;
    }

    @JsonProperty("delivery_status_callback")
    public String getDeliveryStatusCallback() {
        return deliveryStatusCallback;
    }

    @JsonProperty("delivery_status_callback")
    public void setDeliveryStatusCallback(String deliveryStatusCallback) {
        this.deliveryStatusCallback = deliveryStatusCallback;
    }

    @JsonProperty("merchant_external_link")
    public Object getMerchantExternalLink() {
        return merchantExternalLink;
    }

    @JsonProperty("merchant_external_link")
    public void setMerchantExternalLink(Object merchantExternalLink) {
        this.merchantExternalLink = merchantExternalLink;
    }

    @JsonProperty("is_live")
    public Boolean getIsLive() {
        return isLive;
    }

    @JsonProperty("is_live")
    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    @JsonProperty("sales_owner")
    public Object getSalesOwner() {
        return salesOwner;
    }

    @JsonProperty("sales_owner")
    public void setSalesOwner(Object salesOwner) {
        this.salesOwner = salesOwner;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

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
        "auth_token",
        "delivery_needed",
        "merchant_id",
        "amount_cents",
        "currency",
        "merchant_order_id",
        "items"
})
public class OrderRequest {

    @JsonProperty("auth_token")
    private String authToken;
    @JsonProperty("delivery_needed")
    private String deliveryNeeded = "false";
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("amount_cents")
    private String amountCents;
    @JsonProperty("currency")
    private String currency = "EGP";
    @JsonProperty("merchant_order_id")
    private Integer merchantOrderId;
    @JsonProperty("items")
    private List<Object> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("auth_token")
    public String getAuthToken() {
        return authToken;
    }

    @JsonProperty("auth_token")
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @JsonProperty("delivery_needed")
    public String getDeliveryNeeded() {
        return deliveryNeeded;
    }

    @JsonProperty("delivery_needed")
    public void setDeliveryNeeded(String deliveryNeeded) {
        this.deliveryNeeded = deliveryNeeded;
    }

    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("amount_cents")
    public String getAmountCents() {
        return amountCents;
    }

    @JsonProperty("amount_cents")
    public void setAmountCents(String amountCents) {
        this.amountCents = amountCents;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("merchant_order_id")
    public Integer getMerchantOrderId() {
        return merchantOrderId;
    }

    @JsonProperty("merchant_order_id")
    public void setMerchantOrderId(Integer merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    @JsonProperty("items")
    public List<Object> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Object> items) {
        this.items = items;
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
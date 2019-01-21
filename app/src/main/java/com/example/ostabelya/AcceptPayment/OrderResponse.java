
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
    "created_at",
    "delivery_needed",
    "merchant",
    "collector",
    "amount_cents",
    "shipping_data",
    "shipping_details",
    "currency",
    "is_payment_locked",
    "merchant_order_id",
    "wallet_notification",
    "paid_amount_cents",
    "notify_user_with_email",
    "items",
    "order_url",
    "commission_fees",
    "delivery_fees",
    "payment_method",
    "merchant_staff_tag",
    "api_source",
    "pickup_data",
    "token",
    "url"
})
public class OrderResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("delivery_needed")
    private Boolean deliveryNeeded;
    @JsonProperty("merchant")
    private Merchant merchant;
    @JsonProperty("collector")
    private Object collector;
    @JsonProperty("amount_cents")
    private Integer amountCents;
    @JsonProperty("shipping_data")
    private Object shippingData;
    @JsonProperty("shipping_details")
    private Object shippingDetails;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("is_payment_locked")
    private Boolean isPaymentLocked;
    @JsonProperty("merchant_order_id")
    private String merchantOrderId;
    @JsonProperty("wallet_notification")
    private Object walletNotification;
    @JsonProperty("paid_amount_cents")
    private Integer paidAmountCents;
    @JsonProperty("notify_user_with_email")
    private Boolean notifyUserWithEmail;
    @JsonProperty("items")
    private List<Object> items = null;
    @JsonProperty("order_url")
    private String orderUrl;
    @JsonProperty("commission_fees")
    private Integer commissionFees;
    @JsonProperty("delivery_fees")
    private Integer deliveryFees;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("merchant_staff_tag")
    private Object merchantStaffTag;
    @JsonProperty("api_source")
    private String apiSource;
    @JsonProperty("pickup_data")
    private Object pickupData;
    @JsonProperty("token")
    private String token;
    @JsonProperty("url")
    private String url;
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

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("delivery_needed")
    public Boolean getDeliveryNeeded() {
        return deliveryNeeded;
    }

    @JsonProperty("delivery_needed")
    public void setDeliveryNeeded(Boolean deliveryNeeded) {
        this.deliveryNeeded = deliveryNeeded;
    }

    @JsonProperty("merchant")
    public Merchant getMerchant() {
        return merchant;
    }

    @JsonProperty("merchant")
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @JsonProperty("collector")
    public Object getCollector() {
        return collector;
    }

    @JsonProperty("collector")
    public void setCollector(Object collector) {
        this.collector = collector;
    }

    @JsonProperty("amount_cents")
    public Integer getAmountCents() {
        return amountCents;
    }

    @JsonProperty("amount_cents")
    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    @JsonProperty("shipping_data")
    public Object getShippingData() {
        return shippingData;
    }

    @JsonProperty("shipping_data")
    public void setShippingData(Object shippingData) {
        this.shippingData = shippingData;
    }

    @JsonProperty("shipping_details")
    public Object getShippingDetails() {
        return shippingDetails;
    }

    @JsonProperty("shipping_details")
    public void setShippingDetails(Object shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("is_payment_locked")
    public Boolean getIsPaymentLocked() {
        return isPaymentLocked;
    }

    @JsonProperty("is_payment_locked")
    public void setIsPaymentLocked(Boolean isPaymentLocked) {
        this.isPaymentLocked = isPaymentLocked;
    }

    @JsonProperty("merchant_order_id")
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    @JsonProperty("merchant_order_id")
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    @JsonProperty("wallet_notification")
    public Object getWalletNotification() {
        return walletNotification;
    }

    @JsonProperty("wallet_notification")
    public void setWalletNotification(Object walletNotification) {
        this.walletNotification = walletNotification;
    }

    @JsonProperty("paid_amount_cents")
    public Integer getPaidAmountCents() {
        return paidAmountCents;
    }

    @JsonProperty("paid_amount_cents")
    public void setPaidAmountCents(Integer paidAmountCents) {
        this.paidAmountCents = paidAmountCents;
    }

    @JsonProperty("notify_user_with_email")
    public Boolean getNotifyUserWithEmail() {
        return notifyUserWithEmail;
    }

    @JsonProperty("notify_user_with_email")
    public void setNotifyUserWithEmail(Boolean notifyUserWithEmail) {
        this.notifyUserWithEmail = notifyUserWithEmail;
    }

    @JsonProperty("items")
    public List<Object> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Object> items) {
        this.items = items;
    }

    @JsonProperty("order_url")
    public String getOrderUrl() {
        return orderUrl;
    }

    @JsonProperty("order_url")
    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    @JsonProperty("commission_fees")
    public Integer getCommissionFees() {
        return commissionFees;
    }

    @JsonProperty("commission_fees")
    public void setCommissionFees(Integer commissionFees) {
        this.commissionFees = commissionFees;
    }

    @JsonProperty("delivery_fees")
    public Integer getDeliveryFees() {
        return deliveryFees;
    }

    @JsonProperty("delivery_fees")
    public void setDeliveryFees(Integer deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    @JsonProperty("payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("payment_method")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("merchant_staff_tag")
    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    @JsonProperty("merchant_staff_tag")
    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    @JsonProperty("api_source")
    public String getApiSource() {
        return apiSource;
    }

    @JsonProperty("api_source")
    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    @JsonProperty("pickup_data")
    public Object getPickupData() {
        return pickupData;
    }

    @JsonProperty("pickup_data")
    public void setPickupData(Object pickupData) {
        this.pickupData = pickupData;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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

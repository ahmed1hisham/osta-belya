
package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private Integer id;
    private String createdAt;
    private Boolean deliveryNeeded;
    private Merchant merchant;
    private Object collector;
    private Integer amountCents;
    private ShippingData shippingData;
    private Object shippingDetails;
    private String currency;
    private Boolean isPaymentLocked;
    private String merchantOrderId;
    private Object walletNotification;
    private Integer paidAmountCents;
    private Boolean notifyUserWithEmail;
    private List<Object> items = null;
    private String orderUrl;
    private Integer commissionFees;
    private Integer deliveryFees;
    private String paymentMethod;
    private Object merchantStaffTag;
    private String apiSource;
    private Object pickupData;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDeliveryNeeded() {
        return deliveryNeeded;
    }

    public void setDeliveryNeeded(Boolean deliveryNeeded) {
        this.deliveryNeeded = deliveryNeeded;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Object getCollector() {
        return collector;
    }

    public void setCollector(Object collector) {
        this.collector = collector;
    }

    public Integer getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    public ShippingData getShippingData() {
        return shippingData;
    }

    public void setShippingData(ShippingData shippingData) {
        this.shippingData = shippingData;
    }

    public Object getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(Object shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getIsPaymentLocked() {
        return isPaymentLocked;
    }

    public void setIsPaymentLocked(Boolean isPaymentLocked) {
        this.isPaymentLocked = isPaymentLocked;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Object getWalletNotification() {
        return walletNotification;
    }

    public void setWalletNotification(Object walletNotification) {
        this.walletNotification = walletNotification;
    }

    public Integer getPaidAmountCents() {
        return paidAmountCents;
    }

    public void setPaidAmountCents(Integer paidAmountCents) {
        this.paidAmountCents = paidAmountCents;
    }

    public Boolean getNotifyUserWithEmail() {
        return notifyUserWithEmail;
    }

    public void setNotifyUserWithEmail(Boolean notifyUserWithEmail) {
        this.notifyUserWithEmail = notifyUserWithEmail;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public Integer getCommissionFees() {
        return commissionFees;
    }

    public void setCommissionFees(Integer commissionFees) {
        this.commissionFees = commissionFees;
    }

    public Integer getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(Integer deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public Object getPickupData() {
        return pickupData;
    }

    public void setPickupData(Object pickupData) {
        this.pickupData = pickupData;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

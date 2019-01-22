
package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.Map;

public class PaymentKeyClaims {

    private Integer exp;
    private Integer userId;
    private BillingData billingData;
    private String pmkIp;
    private Integer integrationId;
    private Boolean lockOrderWhenPaid;
    private String currency;
    private Integer orderId;
    private Integer amountCents;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BillingData getBillingData() {
        return billingData;
    }

    public void setBillingData(BillingData billingData) {
        this.billingData = billingData;
    }

    public String getPmkIp() {
        return pmkIp;
    }

    public void setPmkIp(String pmkIp) {
        this.pmkIp = pmkIp;
    }

    public Integer getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(Integer integrationId) {
        this.integrationId = integrationId;
    }

    public Boolean getLockOrderWhenPaid() {
        return lockOrderWhenPaid;
    }

    public void setLockOrderWhenPaid(Boolean lockOrderWhenPaid) {
        this.lockOrderWhenPaid = lockOrderWhenPaid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

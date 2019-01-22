
package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private String token;
    private String klass;
    private String walletIssuer;
    private String currency;
    private String redirectUrl;
    private String merTxnRef;
    private String message;
    private String txnResponseCode;
    private String createdAt;
    private Integer amount;
    private String uigTxnId;
    private String walletMsisdn;
    private String orderInfo;
    private Integer gatewayIntegrationPk;
    private String mpgTxnId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getWalletIssuer() {
        return walletIssuer;
    }

    public void setWalletIssuer(String walletIssuer) {
        this.walletIssuer = walletIssuer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getMerTxnRef() {
        return merTxnRef;
    }

    public void setMerTxnRef(String merTxnRef) {
        this.merTxnRef = merTxnRef;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTxnResponseCode() {
        return txnResponseCode;
    }

    public void setTxnResponseCode(String txnResponseCode) {
        this.txnResponseCode = txnResponseCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUigTxnId() {
        return uigTxnId;
    }

    public void setUigTxnId(String uigTxnId) {
        this.uigTxnId = uigTxnId;
    }

    public String getWalletMsisdn() {
        return walletMsisdn;
    }

    public void setWalletMsisdn(String walletMsisdn) {
        this.walletMsisdn = walletMsisdn;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getGatewayIntegrationPk() {
        return gatewayIntegrationPk;
    }

    public void setGatewayIntegrationPk(Integer gatewayIntegrationPk) {
        this.gatewayIntegrationPk = gatewayIntegrationPk;
    }

    public String getMpgTxnId() {
        return mpgTxnId;
    }

    public void setMpgTxnId(String mpgTxnId) {
        this.mpgTxnId = mpgTxnId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentResponse {

    private Integer id;
    private Boolean pending;
    private Integer amountCents;
    private Boolean success;
    private Boolean isAuth;
    private Boolean isCapture;
    private Boolean isStandalonePayment;
    private Boolean isVoided;
    private Boolean isRefunded;
    private Boolean is3dSecure;
    private Integer integrationId;
    private Integer profileId;
    private Boolean hasParentTransaction;
    private Order order;
    private String createdAt;
    private List<Object> transactionProcessedCallbackResponses = null;
    private String currency;
    private SourceData sourceData;
    private String apiSource;
    private Boolean isVoid;
    private Boolean isRefund;
    private Data data;
    private Boolean isHidden;
    private PaymentKeyClaims paymentKeyClaims;
    private Boolean errorOccured;
    private Boolean isLive;
    private Object otherEndpointReference;
    private Integer refundedAmountCents;
    private Integer sourceId;
    private Boolean isCaptured;
    private Integer capturedAmount;
    private Object merchantStaffTag;
    private Integer owner;
    private Object parentTransaction;
    private String redirectUrl;
    private String iframeRedirectionUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Integer getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public Boolean getIsCapture() {
        return isCapture;
    }

    public void setIsCapture(Boolean isCapture) {
        this.isCapture = isCapture;
    }

    public Boolean getIsStandalonePayment() {
        return isStandalonePayment;
    }

    public void setIsStandalonePayment(Boolean isStandalonePayment) {
        this.isStandalonePayment = isStandalonePayment;
    }

    public Boolean getIsVoided() {
        return isVoided;
    }

    public void setIsVoided(Boolean isVoided) {
        this.isVoided = isVoided;
    }

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    public Boolean getIs3dSecure() {
        return is3dSecure;
    }

    public void setIs3dSecure(Boolean is3dSecure) {
        this.is3dSecure = is3dSecure;
    }

    public Integer getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(Integer integrationId) {
        this.integrationId = integrationId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Boolean getHasParentTransaction() {
        return hasParentTransaction;
    }

    public void setHasParentTransaction(Boolean hasParentTransaction) {
        this.hasParentTransaction = hasParentTransaction;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Object> getTransactionProcessedCallbackResponses() {
        return transactionProcessedCallbackResponses;
    }

    public void setTransactionProcessedCallbackResponses(List<Object> transactionProcessedCallbackResponses) {
        this.transactionProcessedCallbackResponses = transactionProcessedCallbackResponses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SourceData getSourceData() {
        return sourceData;
    }

    public void setSourceData(SourceData sourceData) {
        this.sourceData = sourceData;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public Boolean getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(Boolean isVoid) {
        this.isVoid = isVoid;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public PaymentKeyClaims getPaymentKeyClaims() {
        return paymentKeyClaims;
    }

    public void setPaymentKeyClaims(PaymentKeyClaims paymentKeyClaims) {
        this.paymentKeyClaims = paymentKeyClaims;
    }

    public Boolean getErrorOccured() {
        return errorOccured;
    }

    public void setErrorOccured(Boolean errorOccured) {
        this.errorOccured = errorOccured;
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public Object getOtherEndpointReference() {
        return otherEndpointReference;
    }

    public void setOtherEndpointReference(Object otherEndpointReference) {
        this.otherEndpointReference = otherEndpointReference;
    }

    public Integer getRefundedAmountCents() {
        return refundedAmountCents;
    }

    public void setRefundedAmountCents(Integer refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Boolean getIsCaptured() {
        return isCaptured;
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public Integer getCapturedAmount() {
        return capturedAmount;
    }

    public void setCapturedAmount(Integer capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Object getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(Object parentTransaction) {
        this.parentTransaction = parentTransaction;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getIframeRedirectionUrl() {
        return iframeRedirectionUrl;
    }

    public void setIframeRedirectionUrl(String iframeRedirectionUrl) {
        this.iframeRedirectionUrl = iframeRedirectionUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

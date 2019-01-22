
package com.example.ostabelya.AcceptPayment;

import java.util.HashMap;
import java.util.Map;

public class SourceData {

    private String phoneNumber;
    private String pan;
    private String subType;
    private String type;
    private Object ownerName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(Object ownerName) {
        this.ownerName = ownerName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

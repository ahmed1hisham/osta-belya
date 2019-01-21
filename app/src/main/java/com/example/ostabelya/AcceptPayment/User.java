
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
    "username",
    "first_name",
    "last_name",
    "date_joined",
    "email",
    "is_active",
    "is_staff",
    "is_superuser",
    "last_login",
    "groups",
    "user_permissions"
})
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("date_joined")
    private String dateJoined;
    @JsonProperty("email")
    private String email;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("is_staff")
    private Boolean isStaff;
    @JsonProperty("is_superuser")
    private Boolean isSuperuser;
    @JsonProperty("last_login")
    private Object lastLogin;
    @JsonProperty("groups")
    private List<Object> groups = null;
    @JsonProperty("user_permissions")
    private List<Integer> userPermissions = null;
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

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("date_joined")
    public String getDateJoined() {
        return dateJoined;
    }

    @JsonProperty("date_joined")
    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("is_staff")
    public Boolean getIsStaff() {
        return isStaff;
    }

    @JsonProperty("is_staff")
    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    @JsonProperty("is_superuser")
    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    @JsonProperty("is_superuser")
    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    @JsonProperty("last_login")
    public Object getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("last_login")
    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonProperty("groups")
    public List<Object> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    @JsonProperty("user_permissions")
    public List<Integer> getUserPermissions() {
        return userPermissions;
    }

    @JsonProperty("user_permissions")
    public void setUserPermissions(List<Integer> userPermissions) {
        this.userPermissions = userPermissions;
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

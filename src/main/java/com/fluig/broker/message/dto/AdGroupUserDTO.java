package com.fluig.broker.message.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdGroupUserDTO {
    private String userObjectGuid;
    private String groupObjectGuid;

    public AdGroupUserDTO() {
    }

    public AdGroupUserDTO(String userObjectGuid, String groupObjectGuid) {
        this.userObjectGuid = userObjectGuid;
        this.groupObjectGuid = groupObjectGuid;
    }

    public String getUserObjectGuid() {
        return userObjectGuid;
    }

    public void setUserObjectGuid(String userObjectGuid) {
        this.userObjectGuid = userObjectGuid;
    }

    public String getGroupObjectGuid() {
        return groupObjectGuid;
    }

    public void setGroupObjectGuid(String groupObjectGuid) {
        this.groupObjectGuid = groupObjectGuid;
    }
}

package com.fluig.broker.message.dto;

import com.fluig.broker.message.enums.GroupScope;
import com.fluig.broker.message.enums.GroupType;

public class GroupCreateDTO {

    private String objectGuid;

    private String samAccountName;

    private String distinguishedName;

    private String name;

    private String displayName;

    private String description;

    private Long lastAdChangeMillis;

    private GroupType adGroupType;

    private GroupScope adGroupScope;

    public String getObjectGuid() {
        return objectGuid;
    }

    public void setObjectGuid(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    public String getSamAccountName() {
        return samAccountName;
    }

    public void setSamAccountName(String samAccountName) {
        this.samAccountName = samAccountName;
    }

    public String getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLastAdChangeMillis() {
        return lastAdChangeMillis;
    }

    public void setLastAdChangeMillis(Long lastAdChangeMillis) {
        this.lastAdChangeMillis = lastAdChangeMillis;
    }

    public GroupType getAdGroupType() {
        return adGroupType;
    }

    public void setAdGroupType(GroupType adGroupType) {
        this.adGroupType = adGroupType;
    }

    public GroupScope getAdGroupScope() {
        return adGroupScope;
    }

    public void setAdGroupScope(GroupScope adGroupScope) {
        this.adGroupScope = adGroupScope;
    }
}

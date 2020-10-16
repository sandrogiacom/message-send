package com.fluig.broker.message.dto;

import com.fluig.broker.message.enums.AdGroupStatus;

public class AdGroupIdentityCreateConfirmationDTO {

    private String adGroupId;
    private String companyId;
    private String objectGuid;
    private String idmGroupId;
    private AdGroupStatus status;
    private String errorMessage;

    public String getAdGroupId() {
        return adGroupId;
    }

    public void setAdGroupId(String adGroupId) {
        this.adGroupId = adGroupId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getObjectGuid() {
        return objectGuid;
    }

    public void setObjectGuid(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    public String getIdmGroupId() {
        return idmGroupId;
    }

    public void setIdmGroupId(String idmGroupId) {
        this.idmGroupId = idmGroupId;
    }

    public AdGroupStatus getStatus() {
        return status;
    }

    public void setStatus(AdGroupStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

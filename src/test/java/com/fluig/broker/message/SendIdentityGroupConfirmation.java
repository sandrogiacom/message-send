package com.fluig.broker.message;

import static com.fluig.broker.message.AdConstants.ACTIVE_DIRECTORY_ID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.AdGroupIdentityCreateConfirmationDTO;
import com.fluig.broker.message.dto.SyncEventDTO;
import com.fluig.broker.message.enums.AdGroupStatus;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendIdentityGroupConfirmation {


    public static final String AD_GROUP_ID = "33cb6dd8fcdc4ba5a8c00d6d644277e2";
    public static final String COMPANY_ID = "labs0da4110ba377d100f050cb4440db";
    public static final String OBJECT_GUID = "6de78c06cc3d45a4bba044f9776f41d2";
    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendGroupConfirmationMessageAccepted() {
        SyncEventDTO sync = new SyncEventDTO();
        sync.setType("IDM_GROUP_CREATE_CONFIRMATION");
        sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
        sync.setMessage(buildGroupConformation(AdGroupStatus.ACCEPTED));

        publisher.send(BrokerRequest.Builder.of()
                .originClientId("clientId") //ID id?
                .transactionId("9cb1798303ecf3a7")
                .exchangeName(BrokerConstants.IDM_AD_SYNC_IDENTITY_TOPIC)
                .routingKey(BrokerConstants.IDM_AD_SYNC_IDENTITY_RETURN_QUEUE)
                .body(toJson(sync).getBytes()).build());

    }

    @Test
    void sendGroupConfirmationMessageRejected() {
        SyncEventDTO sync = new SyncEventDTO();
        sync.setType("IDM_GROUP_CREATE_CONFIRMATION");
        sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
        sync.setMessage(buildGroupConformation(AdGroupStatus.REJECTED));

        publisher.send(BrokerRequest.Builder.of()
                .originClientId("clientId") //ID id?
                .transactionId("9cb1798303ecf3a7")
                .exchangeName(BrokerConstants.IDM_AD_SYNC_IDENTITY_TOPIC)
                .routingKey(BrokerConstants.IDM_AD_SYNC_IDENTITY_RETURN_QUEUE)
                .body(toJson(sync).getBytes()).build());

    }

    private AdGroupIdentityCreateConfirmationDTO buildGroupConformation(AdGroupStatus status) {
        AdGroupIdentityCreateConfirmationDTO confirmationDTO = new AdGroupIdentityCreateConfirmationDTO();
        confirmationDTO.setAdGroupId(AD_GROUP_ID);
        confirmationDTO.setCompanyId(COMPANY_ID);
        confirmationDTO.setIdmGroupId("12345");
        confirmationDTO.setObjectGuid(OBJECT_GUID);
        confirmationDTO.setStatus(status);
        if (status.equals(AdGroupStatus.REJECTED)) {
            confirmationDTO.setErrorMessage("Company Id not found");
        }
        return confirmationDTO;
    }

    private String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}

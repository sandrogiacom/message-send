package com.fluig.broker.message;

import static com.fluig.broker.message.BrokerConstants.IDM_SMART_SYNC_KEY_SYNC;
import static com.fluig.broker.message.enums.SyncMessageType.USER_UPDATE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.AdUserUpdateDTO;
import com.fluig.broker.message.dto.SyncEventDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendUserUpdateToSmartSync {

    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendUserUpdateToSmartSync() {
        SyncEventDTO sync = new SyncEventDTO();
        sync.setType(USER_UPDATE.name());
        sync.setActiveDirectoryId(AdConstants.ACTIVE_DIRECTORY_ID);
        sync.setMessage(buildUserUpdate());

        publisher.send(BrokerRequest.Builder.of()
                .originClientId("clientId") //ID id?
                .transactionId("9cb1798303ecf3a7")
                .exchangeName(BrokerConstants.IDM_SMART_SYNC_TOPIC)
                .routingKey(IDM_SMART_SYNC_KEY_SYNC + AdConstants.ACTIVE_DIRECTORY_ID)
                .body(sync).build());
    }

    private AdUserUpdateDTO buildUserUpdate() {
        var dto = new AdUserUpdateDTO();
        dto.setDomain("domain");
        dto.setFirstName("FirstName");
        dto.setLastName("LastName");
        dto.setObjectGuid("6de78c06cc3d45a4bba044f9776f41d2");
        return dto;
    }

}

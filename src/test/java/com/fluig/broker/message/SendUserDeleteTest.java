package com.fluig.broker.message;

import static com.fluig.broker.message.AdConstants.ACTIVE_DIRECTORY_ID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.SyncEventDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SendUserDeleteTest {

    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendUserDeleteMessage() {

        SyncEventDTO sync = new SyncEventDTO();
        sync.setType("USER_DELETE");
        sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
        sync.setMessage("2192afeaa4b74ec1a37ce4e590b21037");

        publisher.send(BrokerRequest.Builder.of()
                .originClientId("clientId") //ID id?
                .transactionId("9cb1798303ecf3a7")
                .exchangeName(BrokerConstants.IDM_AD_SYNC_TOPIC)
                .routingKey(BrokerConstants.IDM_AD_SYNC_QUEUE_SYNC)
                .body(sync).build());

    }

}

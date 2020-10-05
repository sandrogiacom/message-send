package com.fluig.broker.message;

import static com.fluig.broker.message.AdConstants.ACTIVE_DIRECTORY_ID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.AdGroupUserDTO;
import com.fluig.broker.message.dto.SyncEventDTO;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SendGroupUserCreateTest {

    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendCreateUserMessage() throws InterruptedException {
        //for (int i = 1; i <= 1; i++) {
            SyncEventDTO sync = new SyncEventDTO();
            sync.setType("GROUP_USER_CREATE");
            sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
            sync.setMessage(toJson(buildGroupUserCreate()));

            publisher.send(BrokerRequest.Builder.of()
                    .originClientId("clientId") //ID id?
                    .transactionId("9cb1798303ecf3a7")
                    .exchangeName(BrokerConstants.IDM_AD_SYNC_TOPIC)
                    .routingKey(BrokerConstants.IDM_AD_SYNC_QUEUE_SYNC)
                    .body(sync).build());

            //System.out.println("send message " + i);

            //Thread.sleep(1000);

        //}
    }

    private AdGroupUserDTO buildGroupUserCreate() {
        AdGroupUserDTO groupUser = new AdGroupUserDTO();
        groupUser.setGroupObjectGuid("3025bcdf3cb84847a047b0f172783130");
        groupUser.setUserObjectGuid("2192afeaa4b74ec1a37ce4e590b21037");
        return groupUser;
    }

    private String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}

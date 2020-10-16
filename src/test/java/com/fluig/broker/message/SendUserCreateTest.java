package com.fluig.broker.message;

import static com.fluig.broker.message.AdConstants.ACTIVE_DIRECTORY_ID;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.SyncEventDTO;
import com.fluig.broker.message.dto.UserCreateDTO;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SendUserCreateTest {

    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendCreateUserMessage() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            SyncEventDTO sync = new SyncEventDTO();
            sync.setType("USER_CREATE");
            sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
            sync.setMessage(toJson(buildUserCreate()));

            publisher.send(BrokerRequest.Builder.of()
                    .originClientId("clientId") //ID id?
                    //.tenantId("001") //companyId
                    //.user("currentUserId") //
                    //.tokenClientId("0ad5c746-3321-4257-806d-905ba00a0469") //smart_sync_token
                    .transactionId("9cb1798303ecf3a7")
                    .exchangeName(BrokerConstants.IDM_AD_SYNC_TOPIC)
                    .routingKey(BrokerConstants.IDM_AD_SYNC_QUEUE_SYNC)
                    .body(sync).build());

            System.out.println("send message " + i);

            Thread.sleep(1000);

        }
    }

    private UserCreateDTO buildUserCreate() {
        UserCreateDTO user = new UserCreateDTO();
        user.setSamAccountName("username");
        user.setEmail("username@mail.com");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setObjectGuid(UUID.randomUUID().toString().replace("-", ""));
        user.setDomain("DOMAIN");
        return user;
    }

    private String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}

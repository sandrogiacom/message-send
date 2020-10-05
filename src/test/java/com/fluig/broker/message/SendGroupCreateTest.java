package com.fluig.broker.message;

import static com.fluig.broker.message.AdConstants.ACTIVE_DIRECTORY_ID;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fluig.broker.BrokerPublisher;
import com.fluig.broker.dto.BrokerRequest;
import com.fluig.broker.message.dto.GroupCreateDTO;
import com.fluig.broker.message.dto.SyncEventDTO;
import com.fluig.broker.message.enums.GroupScope;
import com.fluig.broker.message.enums.GroupType;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SendGroupCreateTest {

    @Autowired
    private BrokerPublisher publisher;

    @Test
    void sendCreateGroupMessage() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            SyncEventDTO sync = new SyncEventDTO();
            sync.setType("GROUP_CREATE");
            sync.setActiveDirectoryId(ACTIVE_DIRECTORY_ID);
            sync.setMessage(toJson(buildGroupCreate()));

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

    private GroupCreateDTO buildGroupCreate() {
        GroupCreateDTO group = new GroupCreateDTO();
        group.setName("Group name");
        group.setSamAccountName("Group SamAccountName");
        group.setDescription("Group description");
        group.setDisplayName("Group displayName");
        group.setDistinguishedName("Group DistinguishedName");
        group.setObjectGuid(UUID.randomUUID().toString().replace("-", ""));
        group.setGroupScope(GroupScope.GLOBAL);
        group.setGroupType(GroupType.DISTRIBUTION);
        group.setLastAdChangeMillis(new Date().getTime());
        return group;
    }

    private String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}

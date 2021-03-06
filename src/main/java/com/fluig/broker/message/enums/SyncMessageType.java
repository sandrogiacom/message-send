package com.fluig.broker.message.enums;

public enum SyncMessageType {
    USER_CREATE,
    USER_UPDATE,
    USER_DELETE,
    GROUP_CREATE,
    GROUP_UPDATE,
    GROUP_DELETE,
    GROUP_USER_CREATE,
    GROUP_USER_DELETE,
    IDM_GROUP_CREATE,
    IDM_USER_CREATE,
    IDM_GROUP_CREATE_CONFIRMATION,
    IDM_USER_CREATE_CONFIRMATION,
    IDM_ASSOCIATE_USER_GROUP,
    IDM_DISSOCIATE_USER_GROUP,
    IDM_ASSOCIATE_USER_GROUP_FROM_IDENTITY,
    IDM_DISSOCIATE_USER_GROUP_FROM_IDENTITY
}

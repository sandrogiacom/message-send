package com.fluig.broker.message;

//TODO transformar em enum?
public final class BrokerConstants {

    /**
     * AdSync to SmartSync
     */
    public static final String IDM_AD_SYNC_TOPIC = "IDM.AD_SYNC.TOPIC.V1";
    //AdSync Synchronization Queue
    public static final String IDM_AD_SYNC_QUEUE_SYNC = "IDM.AD_SYNC.SYNC.V1";
    //AdSync Config Queue
    public static final String IDM_AD_SYNC_QUEUE_CONFIG = "IDM.AD_SYNC.CONFIG.V1";
    //AdSync Authentication Queue
    public static final String IDM_AD_SYNC_QUEUE_AUTH = "IDM.AD_SYNC.AUTH.V1";

    /**
     *  SmartSync to AdSync
     */
    public static final String IDM_SMART_SYNC_TOPIC = "IDM.SMART_SYNC.TOPIC.V1";
    //SmartSync Synchronization Queue
    public static final String IDM_SMART_SYNC_QUEUE_SYNC = "IDM.SMART_SYNC.SYNC.V1.";
    public static final String IDM_SMART_SYNC_KEY_SYNC = "sync.";
    //SmartSync Config Queue
    public static final String IDM_SMART_SYNC_QUEUE_CONFIG = "IDM.SMART_SYNC.CONFIG.V1.";
    public static final String IDM_SMART_SYNC_KEY_CONFIG = "config.";
    //SmartSync Authentication Queue
    public static final String IDM_SMART_SYNC_QUEUE_AUTH = "IDM.SMART_SYNC.AUTH.V1.";
    public static final String IDM_SMART_SYNC_KEY_AUTH = "auth.";

    /**
     * AdSync to Identity
     */
    public static final String IDM_AD_SYNC_IDENTITY_SYNC_TOPIC = "IDM.AD_SYNC_IDENTITY_SYNC.TOPIC.V1";
    //AdSync Synchronization Queue to Identity
    public static final String IDM_AD_SYNC_IDENTITY_SYNC_QUEUE = "IDM.AD_SYNC_IDENTITY_SYNC.QUEUE.V1";

    /**
     * Identity to AdSync
     */
    public static final String IDM_AD_SYNC_IDENTITY_TOPIC = "IDM.IDENTITY.AD_SYNC.TOPIC.V1";
    //Identity Synchronization Return Queue to AdSync
    public static final String IDM_AD_SYNC_IDENTITY_RETURN_QUEUE = "IDM.IDENTITY.AD_SYNC.RETURN.QUEUE.V1";
    //Identity Synchronization Queue to AdSync
    public static final String IDM_AD_SYNC_IDENTITY_QUEUE = "IDM.IDENTITY.AD_SYNC.QUEUE.V1";

    private BrokerConstants() {
    }

}

package com.fluig.broker.message.config;

import java.util.List;

import com.fluig.broker.config.BrokerConfigurerAdapter;
import com.fluig.broker.config.EnableBroker;
import com.fluig.broker.listener.BrokerReplyingListener;

@EnableBroker
public class IdentityExchange extends BrokerConfigurerAdapter {

    @Override
    public List<BrokerReplyingListener> getReplyingListeners() {
        return super.getReplyingListeners();
    }
}
